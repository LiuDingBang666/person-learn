package icu.liuwisdom.business.mall.controller;
import com.github.pagehelper.PageInfo;
import icu.liuwisdom.business.mall.dto.MallOrderDto;
import icu.liuwisdom.business.mall.dto.MallProductActivityDto;
import icu.liuwisdom.business.mall.po.MallProductActivity;
import icu.liuwisdom.business.mall.query.MallOrderQuery;
import icu.liuwisdom.business.mall.query.MallProductActivityQuery;
import icu.liuwisdom.business.mall.service.MallOrderProcessService;
import icu.liuwisdom.business.mall.service.MallProductActivityService;
import icu.liuwisdom.business.mall.vo.MallOrderVo;
import icu.liuwisdom.core.http.HttpResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Arrays;

@Api(tags = "商城 产品活动")
@Controller
@RequestMapping("/mall/mallProductActivity")
public class MallProductActivityController {

    @Resource
    MallProductActivityService service;
    @ApiOperation(value = "新增")
    @PostMapping("/")
    public HttpResult<Boolean> add(@RequestBody @Validated MallProductActivity dto) {
        return HttpResult.ok(service.save(dto));
    }

    @ApiOperation(value = "分页")
    @PostMapping("/page")
    public HttpResult<PageInfo<MallProductActivity>> page(@RequestBody @Validated MallProductActivityQuery query) {
        return HttpResult.ok(service.listPage(query));
    }

    @ApiOperation(value = "修改")
    @PutMapping("/")
    public HttpResult<Boolean> update(@RequestBody @Validated MallProductActivity dto) {
        return HttpResult.ok(service.updateById(dto));
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public HttpResult<Boolean> delete(@PathVariable("id") String id) {
        return HttpResult.ok(service.removeByIds(Arrays.asList(id.split(","))));
    }

    @ApiOperation(value = "查询")
    @GetMapping("/{id}")
    public HttpResult<MallProductActivity> get(@PathVariable("id") String id) {
        return HttpResult.ok(service.getById(id));
    }
}
