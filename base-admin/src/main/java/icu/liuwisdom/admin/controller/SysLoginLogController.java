package icu.liuwisdom.admin.controller;

import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.entity.SysLoginLog;
import icu.liuwisdom.admin.query.SysLoginLogQuery;
import icu.liuwisdom.admin.service.SysLoginLogService;
import icu.liuwisdom.core.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * 登录日志控制器
 *
 * @author ldb
 * @date 2022-06-01
 */
@RestController
@RequestMapping("loginlog")
@Api(tags = "登录日志管理")
public class SysLoginLogController {

    @Resource
    private SysLoginLogService sysLoginLogService;

    @ApiOperation("分页查询登录日志")
    @PreAuthorize("hasAuthority('sys:loginlog:view')")
    @PostMapping(value = "/page")
    public HttpResult<PageInfo<SysLoginLog>> findPage(@RequestBody SysLoginLogQuery query) {
        PageInfo<SysLoginLog> data = sysLoginLogService.pageData(query);
        return HttpResult.ok("分页查询登录日志成功", data);
    }

    @ApiOperation("根据id查询登录日志管理信息")
    @PreAuthorize("hasAuthority('sys:loginlog:view')")
    @GetMapping(value = "/{id}")
    public HttpResult<SysLoginLog> get(@PathVariable("id") String id) {
        return HttpResult.ok("根据id查询登录日志管理信息", sysLoginLogService.getById(id));
    }

    @ApiOperation("删除登录日志")
    @PreAuthorize("hasAuthority('sys:loginlog:delete')")
    @DeleteMapping(value = "/{id}")
    public HttpResult delete(@PathVariable("id") String records) {
        return HttpResult.ok("删除登录日志成功", sysLoginLogService.delete(Arrays.asList(records.split(","))));
    }
}
