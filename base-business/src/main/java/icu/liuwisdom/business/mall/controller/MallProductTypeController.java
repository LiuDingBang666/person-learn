package icu.liuwisdom.business.mall.controller;

import com.github.pagehelper.PageInfo;
import icu.liuwisdom.business.mall.po.MallProductType;
import icu.liuwisdom.business.mall.query.MallProductTypeQuery;
import icu.liuwisdom.business.mall.service.MallProductTypeService;
import icu.liuwisdom.business.mall.vo.MallProductTypeVo;
import icu.liuwisdom.core.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Api(tags = "商城 分类信息")
@RestController
@RequestMapping("/mall/mallProductType")
public class MallProductTypeController {
    @Resource
    MallProductTypeService service;

    @ApiOperation("新增")
    @PostMapping("/")
    public HttpResult<Boolean> add(@RequestBody @Validated MallProductType dto) {
        return HttpResult.ok(service.save(dto));
    }

    @ApiOperation("分页")
    @PostMapping("/page")
    public HttpResult<PageInfo<MallProductType>> page(@RequestBody @Validated MallProductTypeQuery query) {
        return HttpResult.ok(service.listPage(query));
    }

    @ApiOperation("分类树")
    @PostMapping("/tree")
    public HttpResult<List<MallProductTypeVo>> tree(@RequestBody @Validated MallProductTypeQuery query) {
        return HttpResult.ok(service.tree(query));
    }

    @ApiOperation("修改")
    @PutMapping("/")
    public HttpResult<Boolean> update(@RequestBody @Validated MallProductType dto) {
        return HttpResult.ok(service.updateById(dto));
    }

    @ApiOperation("删除")
    @DeleteMapping("/{id}")
    public HttpResult<Boolean> delete(@PathVariable("id") String id) {
        return HttpResult.ok(service.removeByIds(Arrays.asList(id.split(","))));
    }

    @ApiOperation("查询")
    @GetMapping("/{id}")
    public HttpResult<MallProductType> get(@PathVariable("id") String id) {
        return HttpResult.ok(service.getById(id));
    }

}
