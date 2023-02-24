package icu.liuwisdom.admin.controller;

import com.github.pagehelper.PageInfo;
import com.google.gson.JsonObject;
import icu.liuwisdom.admin.entity.SysConfig;
import icu.liuwisdom.admin.query.SysConfigQuery;
import icu.liuwisdom.admin.service.SysConfigService;
import icu.liuwisdom.core.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * 系统配置控制器
 *
 * @author ldb
 * @date 2022-6-1
 */
@RestController
@RequestMapping("config")
@Api(tags = "系统配置")
public class SysConfigController {

    @Resource
    private SysConfigService sysConfigService;

    @PreAuthorize("hasAuthority('sys:config:add') ")
    @ApiOperation("新增系统配置")
    @PostMapping(value = "/")
    public HttpResult<Boolean> add(@RequestBody SysConfig record) {
        return HttpResult.ok("新增系统配置成功", sysConfigService.save(record));
    }

    @PreAuthorize("hasAuthority('sys:config:view') ")
    @ApiOperation("查询系统配置")
    @GetMapping(value = "/{id}")
    public HttpResult<SysConfig> add(@PathVariable("id") String id) {
        return HttpResult.ok("查询系统配置成功", sysConfigService.getById(id));
    }

    @PreAuthorize("hasAuthority('sys:config:alter')")
    @ApiOperation("修改系统配置")
    @PutMapping(value = "/")
    public HttpResult<Boolean> update(@RequestBody SysConfig record) {
        return HttpResult.ok("修改系统配置成功", sysConfigService.updateById(record));
    }

    @PreAuthorize("hasAuthority('sys:config:delete')")
    @ApiOperation("删除系统配置")
    @DeleteMapping(value = "/{id}")
    public HttpResult<Boolean> delete(@PathVariable("id") String ids) {
        return HttpResult.ok("删除系统配置成功", sysConfigService.delete(Arrays.asList(ids.split(","))));
    }

    @PreAuthorize("hasAuthority('sys:config:view')")
    @PostMapping(value = "/page")
    @ApiOperation("分页查询系统配置")
    public HttpResult<PageInfo<SysConfig>> findPage(@RequestBody SysConfigQuery query) {
        return HttpResult.ok("分页查询系统配置成功", sysConfigService.pageData(query));
    }

}
