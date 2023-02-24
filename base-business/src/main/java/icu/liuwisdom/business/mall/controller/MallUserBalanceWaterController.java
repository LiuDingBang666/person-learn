package icu.liuwisdom.business.mall.controller;
import com.github.pagehelper.PageInfo;
import icu.liuwisdom.business.mall.dto.MallUserBalanceDto;
import icu.liuwisdom.business.mall.po.MallUserBalance;
import icu.liuwisdom.business.mall.po.MallUserBalanceWater;
import icu.liuwisdom.business.mall.query.MallUserBalanceQuery;
import icu.liuwisdom.business.mall.query.MallUserBalanceWaterQuery;
import icu.liuwisdom.business.mall.service.MallUserBalanceService;
import icu.liuwisdom.business.mall.service.MallUserBalanceWaterService;
import icu.liuwisdom.core.http.HttpResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Arrays;

@Api(tags = "商城 用户余额流水信息")
@Controller
@RequestMapping("/mall/mallUserBalanceWater")
public class MallUserBalanceWaterController {
    @Resource
    MallUserBalanceWaterService service;

    @ApiOperation(value = "分页")
    @PostMapping("/page")
    public HttpResult<PageInfo<MallUserBalanceWater>> page(@RequestBody @Validated MallUserBalanceWaterQuery query) {
        return HttpResult.ok(service.listPage(query));
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public HttpResult<Boolean> delete(@PathVariable("id") String id) {
        return HttpResult.ok(service.removeByIds(Arrays.asList(id.split(","))));
    }

    @ApiOperation(value = "查询")
    @GetMapping("/{id}")
    public HttpResult<MallUserBalanceWater> get(@PathVariable("id") String id) {
        return HttpResult.ok(service.getById(id));
    }
}
