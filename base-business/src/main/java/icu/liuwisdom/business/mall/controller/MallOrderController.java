package icu.liuwisdom.business.mall.controller;
import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.entity.SysDept;
import icu.liuwisdom.admin.utils.UserUtils;
import icu.liuwisdom.business.mall.dto.MallOrderDto;
import icu.liuwisdom.business.mall.po.MallProduct;
import icu.liuwisdom.business.mall.query.MallOrderQuery;
import icu.liuwisdom.business.mall.query.MallProductQuery;
import icu.liuwisdom.business.mall.query.MallProductTypeQuery;
import icu.liuwisdom.business.mall.service.MallOrderService;
import icu.liuwisdom.business.mall.service.MallProductService;
import icu.liuwisdom.business.mall.vo.MallOrderVo;
import icu.liuwisdom.business.mall.vo.MallProductTypeVo;
import icu.liuwisdom.core.http.HttpResult;
import icu.liuwisdom.utils.StringUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Api(tags = "商城 订单信息")
@Controller
@RequestMapping("/mall/mallOrder")
public class MallOrderController {

    @Resource
    MallOrderService service;

    @ApiOperation(value = "新增")
    @PostMapping("/")
    public HttpResult<Boolean> add(@RequestBody @Validated MallOrderDto dto) {
        return HttpResult.ok(service.save(dto));
    }

    @ApiOperation(value = "分页")
    @PostMapping("/page")
    public HttpResult<PageInfo<MallOrderVo>> page(@RequestBody @Validated MallOrderQuery query) {
        return HttpResult.ok(service.multiListPage(query));
    }

    @ApiOperation(value = "修改")
    @PutMapping("/")
    public HttpResult<Boolean> update(@RequestBody @Validated MallOrderDto dto) {
        return HttpResult.ok(service.updateById(dto));
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public HttpResult<Boolean> delete(@PathVariable("id") String id) {
        return HttpResult.ok(service.removeByIds(Arrays.asList(id.split(","))));
    }

    @ApiOperation(value = "查询")
    @GetMapping("/{id}")
    public HttpResult<MallOrderVo> get(@PathVariable("id") String id) {
        return HttpResult.ok(service.getById(id));
    }
}
