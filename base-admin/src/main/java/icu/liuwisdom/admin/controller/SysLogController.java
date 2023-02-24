package icu.liuwisdom.admin.controller;

import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.entity.SysLog;
import icu.liuwisdom.admin.query.SysLogQueryQuery;
import icu.liuwisdom.admin.service.SysLogService;
import icu.liuwisdom.core.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * 操作日志控制器
 *
 * @author ldb
 * @date 2022-6-1
 */
@RestController
@RequestMapping("log")
@Api(tags = "日志管理")
public class SysLogController {

    @Resource
    private SysLogService sysLogService;

    @ApiOperation("分页查询日志管理信息")
    @PreAuthorize("hasAuthority('sys:log:view')")
    @PostMapping(value = "/page")
    public HttpResult<PageInfo<SysLog>> findPage(@RequestBody SysLogQueryQuery query) {
        PageInfo<SysLog> data = sysLogService.pageData(query);
        return HttpResult.ok("分页查询日志管理信息成功", data);
    }

    @ApiOperation("根据id查询日志管理信息")
    @PreAuthorize("hasAuthority('sys:log:view')")
    @GetMapping(value = "/{id}")
    public HttpResult<SysLog> get(@PathVariable("id") String id) {
        return HttpResult.ok("根据id查询日志管理信息", sysLogService.getById(id));
    }


    @ApiOperation("根据id删除日志管理信息")
    @PreAuthorize("hasAuthority('sys:log:delete')")
    @DeleteMapping(value = "/{id}")
    public HttpResult delete(@PathVariable("id") String records) {
        return HttpResult.ok("根据id删除日志管理信息成功", sysLogService.delete(Arrays.asList(records.split(","))));
    }
}
