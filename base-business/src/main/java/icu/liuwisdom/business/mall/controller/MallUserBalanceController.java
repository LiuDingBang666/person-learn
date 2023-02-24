package icu.liuwisdom.business.mall.controller;
import com.github.pagehelper.PageInfo;
import icu.liuwisdom.business.mall.dto.MallOrderDto;
import icu.liuwisdom.business.mall.dto.MallUserBalanceDto;
import icu.liuwisdom.business.mall.po.MallUserBalance;
import icu.liuwisdom.business.mall.query.MallOrderQuery;
import icu.liuwisdom.business.mall.query.MallUserBalanceQuery;
import icu.liuwisdom.business.mall.service.MallOrderService;
import icu.liuwisdom.business.mall.service.MallUserBalanceService;
import icu.liuwisdom.business.mall.vo.MallOrderVo;
import icu.liuwisdom.core.http.HttpResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Arrays;

@Api(tags = "商城 用户余额信息")
@Controller
@RequestMapping("/mall/mallUserBalance")
public class MallUserBalanceController {
    @Resource
    MallUserBalanceService service;

    @ApiOperation(value = "充值")
    @PutMapping("/recharge")
    public HttpResult<Boolean> recharge(@RequestBody @Validated MallUserBalanceDto dto) {
        return HttpResult.ok(service.recharge(dto));
    }

    @ApiOperation(value = "扣款")
    @PostMapping("/reduce")
    public HttpResult<Boolean> reduce(@RequestBody @Validated MallUserBalanceDto dto) {
        return HttpResult.ok(service.reduce(dto));
    }

    @ApiOperation(value = "新增")
    @PostMapping("/")
    public HttpResult<Boolean> add(@RequestBody @Validated MallUserBalanceDto dto) {
        return HttpResult.ok(service.save(dto));
    }

    @ApiOperation(value = "分页")
    @PostMapping("/page")
    public HttpResult<PageInfo<MallUserBalance>> page(@RequestBody @Validated MallUserBalanceQuery query) {
        return HttpResult.ok(service.listPage(query));
    }

    @ApiOperation(value = "修改")
    @PutMapping("/")
    public HttpResult<Boolean> update(@RequestBody @Validated MallUserBalanceDto dto) {
        return HttpResult.ok(service.updateById(dto));
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public HttpResult<Boolean> delete(@PathVariable("id") String id) {
        return HttpResult.ok(service.removeByIds(Arrays.asList(id.split(","))));
    }

    @ApiOperation(value = "查询")
    @GetMapping("/{id}")
    public HttpResult<MallUserBalance> get(@PathVariable("id") String id) {
        return HttpResult.ok(service.getById(id));
    }
}
