package icu.liuwisdom.business.mall.controller;

import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.entity.SysDept;
import icu.liuwisdom.admin.utils.UserUtils;
import icu.liuwisdom.business.mall.po.MallProduct;
import icu.liuwisdom.business.mall.query.MallProductQuery;
import icu.liuwisdom.business.mall.query.MallProductTypeQuery;
import icu.liuwisdom.business.mall.service.MallProductService;
import icu.liuwisdom.business.mall.vo.MallProductTypeVo;
import icu.liuwisdom.core.http.HttpResult;
import icu.liuwisdom.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Api(tags = "商城 产品信息")
@RestController
@RequestMapping("/mall/mallProduct")
public class MallProductController {

    @Resource
    MallProductService service;

    @ApiOperation(value = "新增")
    @PostMapping("/")
    public HttpResult<Boolean> add(@RequestBody @Validated MallProduct dto) {
        SysDept dept = UserUtils.getDept();
        if (Objects.nonNull(dept)) {
            dto.setFkDeptId(dept.getId());
            dto.setDeptName(dept.getName());
        }
        return HttpResult.ok(service.save(dto));
    }

    @ApiOperation(value = "分页")
    @PostMapping("/page")
    public HttpResult<PageInfo<MallProduct>> page(@RequestBody @Validated MallProductQuery query) {
        return HttpResult.ok(service.listPage(query));
    }

    @ApiOperation(value = "修改")
    @PutMapping("/")
    public HttpResult<Boolean> update(@RequestBody @Validated MallProduct dto) {
        SysDept dept = UserUtils.getDept();
        if (Objects.nonNull(dept)) {
            dto.setFkDeptId(dept.getId());
            dto.setDeptName(dept.getName());
        }
        return HttpResult.ok(service.updateById(dto));
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public HttpResult<Boolean> delete(@PathVariable("id") String id) {
        return HttpResult.ok(service.removeByIds(Arrays.asList(id.split(","))));
    }

    @ApiOperation(value = "查询")
    @GetMapping("/{id}")
    public HttpResult<MallProduct> get(@PathVariable("id") String id) {
        return HttpResult.ok(service.getById(id));
    }


    @ApiOperation(value = "分类查询商品树")
    @PostMapping("/shop/tree")
    public HttpResult<List<MallProductTypeVo>> shopTree(@RequestBody @Validated MallProductTypeQuery query) {
        List<MallProductTypeVo> data = service.shopTree(query);
        return HttpResult.ok(data);
    }


    @ApiOperation(value = "批量更新商品状态")
    @PutMapping("/updateState/{id}/{state}")
    public HttpResult<Boolean> updateState(@PathVariable("id") @ApiParam(name = "主键", required = true) String id
            , @PathVariable("state") @ApiParam(name = "状态值", required = true) Integer state) {
        return HttpResult.ok(service.updateState(StringUtils.strToList(id), state));
    }
}
