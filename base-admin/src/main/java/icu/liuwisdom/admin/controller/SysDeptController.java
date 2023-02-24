package icu.liuwisdom.admin.controller;

import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.dto.SysDeptDto;
import icu.liuwisdom.admin.entity.SysDept;
import icu.liuwisdom.admin.query.SysDeptQuery;
import icu.liuwisdom.admin.service.SysDeptService;
import icu.liuwisdom.admin.vo.SysDeptVo;
import icu.liuwisdom.core.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 机构控制器
 *
 * @author ldb
 * @date 2022-6-1
 */
@RestController
@RequestMapping("dept")
@Api(tags = "机构管理")
public class SysDeptController {

    @Resource
    private SysDeptService sysDeptService;

    @ApiOperation("新增机构信息")
    @PreAuthorize("hasAuthority('sys:dept:add')")
    @PostMapping(value = "/")
    public HttpResult<SysDept> add(@RequestBody @Validated SysDeptDto record) {
        return HttpResult.ok("新增机构信息成功", sysDeptService.save(record));
    }

    @ApiOperation("修改机构信息")
    @PreAuthorize("hasAuthority('sys:dept:alter')")
    @PutMapping(value = "/")
    public HttpResult<SysDept> update(@RequestBody @Validated SysDeptDto record) {
        return HttpResult.ok("修改机构信息成功", sysDeptService.updateById(record));
    }

    @ApiOperation("删除机构信息")
    @PreAuthorize("hasAuthority('sys:dept:delete')")
    @DeleteMapping(value = "/{id}")
    public HttpResult<Boolean> delete(@PathVariable("id") String records) {
        return HttpResult.ok("删除机构信息成功", sysDeptService.delete(Arrays.asList(records.split(","))));
    }

    @ApiOperation("根据id查询机构信息")
    @PreAuthorize("hasAuthority('sys:dept:alter')")
    @GetMapping(value = "/{id}")
    public HttpResult<SysDeptVo> get(@PathVariable("id") String id) {
        return HttpResult.ok("根据id查询机构信息成功", sysDeptService.getById(id));
    }

    @ApiOperation("获取机构树")
    @PreAuthorize("hasAuthority('sys:dept:view')")
    @PostMapping(value = "/tree")
    public HttpResult<List<SysDeptVo>> findTree() {
        List<SysDeptVo> data = sysDeptService.findTree();
        return HttpResult.ok("获取机构树成功", data);
    }


    @ApiOperation("分页查询机构")
    @PreAuthorize("hasAuthority('sys:dept:view')")
    @PostMapping(value = "/page")
    public HttpResult<PageInfo<SysDeptVo>> page(@RequestBody SysDeptQuery query) {
        return HttpResult.ok("查询机构成功", sysDeptService.multiListPage(query));
    }

    @ApiOperation("获取机构下拉列表")
    @PreAuthorize("hasAuthority('sys:dept:view')")
    @PostMapping(value = "/selected")
    public HttpResult<List<SysDept>> selected() {
        return HttpResult.ok("获取机构下拉列表成功", sysDeptService.list());
    }
}
