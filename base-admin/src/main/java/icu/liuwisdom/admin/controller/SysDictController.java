package icu.liuwisdom.admin.controller;

import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.entity.SysDict;
import icu.liuwisdom.admin.query.SysDictQuery;
import icu.liuwisdom.admin.service.SysDictService;
import icu.liuwisdom.core.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * 字典控制器
 *
 * @author ldb
 * @date 2022-06-01
 */
@RestController
@RequestMapping("dict")
@Api(tags = "字典管理")
public class SysDictController {

    @Resource
    private SysDictService sysDictService;

    @ApiOperation("新增数据字典信息")
    @PreAuthorize("hasAuthority('sys:dict:add')")
    @PostMapping(value = "/")
    public HttpResult add(@RequestBody SysDict record) {
        return HttpResult.ok("新增数据字典信息成功", sysDictService.save(record));
    }

    @ApiOperation("修改数据字典信息")
    @PreAuthorize("hasAuthority('sys:dict:add') AND hasAuthority('sys:dict:alter')")
    @PutMapping(value = "/")
    public HttpResult update(@RequestBody SysDict record) {
        return HttpResult.ok("修改数据字典信息成功", sysDictService.updateById(record));
    }

    @ApiOperation("删除数据字典信息")
    @PreAuthorize("hasAuthority('sys:dict:delete')")
    @DeleteMapping(value = "/{id}")
    public HttpResult delete(@PathVariable("id") String records) {
        return HttpResult.ok("删除数据字典信息成功", sysDictService.delete(Arrays.asList(records.split(","))));
    }

    @ApiOperation("查询数据字典信息")
    @PreAuthorize("hasAuthority('sys:dict:delete')")
    @GetMapping(value = "/{id}")
    public HttpResult get(@PathVariable("id") String id) {
        return HttpResult.ok("查询数据字典信息成功", sysDictService.getById(id));
    }

    @ApiOperation("分页查询数据字典信息")
    @PreAuthorize("hasAuthority('sys:dict:view')")
    @PostMapping(value = "/page")
    public HttpResult<PageInfo<SysDict>> pageData(@RequestBody SysDictQuery query) {
        PageInfo<SysDict> data = sysDictService.pageData(query);
        return HttpResult.ok("分页查询数据字典信息成功", data);
    }

}
