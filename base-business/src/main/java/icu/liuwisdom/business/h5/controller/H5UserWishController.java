package icu.liuwisdom.business.h5.controller;


import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.utils.UserUtils;
import icu.liuwisdom.business.entity.UserWish;
import icu.liuwisdom.business.query.UserWishQuery;
import icu.liuwisdom.business.service.UserWishService;
import icu.liuwisdom.business.vo.UserWishVo;
import icu.liuwisdom.core.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户愿望表 前端控制器
 * </p>
 *
 * @author ldb
 * @since 2022-12-12
 */
@Api(tags = "用户愿望表")
@RestController
@RequestMapping("/h5/userWish")
public class H5UserWishController {

    @Resource
    UserWishService service;

    @ApiOperation("新增")
    @PostMapping(value = "/")
    public HttpResult<Boolean> add(@RequestBody @Validated UserWish record) {
        record.setFkUserId(UserUtils.getUser().getId());
        return HttpResult.ok("新增成功", service.saveOrUpdate(record));
    }

    @ApiOperation("删除")
    @DeleteMapping(value = "/{id}")
    public HttpResult<Boolean> delete(@PathVariable("id") String records) {
        return HttpResult.ok("删除成功", service.removeById(records));
    }

    @ApiOperation("根据id查询")
    @GetMapping(value = "/{id}")
    public HttpResult<UserWishVo> get(@PathVariable("id") String id) {
        return HttpResult.ok("根据id查询成功", service.getById(id));
    }

    @ApiOperation("确认愿望已实现")
    @PutMapping(value = "/confirm/{id}")
    public HttpResult<Boolean> confirm(@PathVariable("id") String id) {
        return HttpResult.ok("确认实现成功", service.confirm(id));
    }


    @ApiOperation("选择自己的最希望实现的愿望")
    @PutMapping(value = "/select/{id}")
    public HttpResult<Boolean> select(@PathVariable("id") String id) {
        return HttpResult.ok("选择自己的最希望实现的愿望成功", service.selectWish(id));
    }

    @ApiOperation("是否已选择了需要实现的愿望")
    @GetMapping(value = "/hasSelect/")
    public HttpResult<Boolean> hasSelected() {
        return HttpResult.ok("是否已选择了需要实现的愿望", service.hasSelected(UserUtils.getUser().getId()));
    }

    @ApiOperation("是否还能选择愿望")
    @GetMapping(value = "/canSelected/")
    public HttpResult<Boolean> canSelected() {
        return HttpResult.ok("是否还能选择愿望", service.canSelected(UserUtils.getUser().getId()));
    }

    @ApiOperation("查询我的愿望")
    @PostMapping(value = "/list")
    public HttpResult<List<UserWish>> mine(@RequestBody UserWishQuery query) {
        query.setFkUserId(UserUtils.getUser().getId());
        return HttpResult.ok("查询我的愿望", service.list(query));
    }

    @ApiOperation("随机获取最可能实现的愿望")
    @GetMapping(value = "/random")
    public HttpResult<UserWish> bestWish() {
        return HttpResult.ok("新增成功", service.bestWish(UserUtils.getUser().getId()));
    }

    @ApiOperation("分页查询所有愿望")
    @PostMapping(value = "/page")
    public HttpResult<PageInfo<UserWishVo>> page(@RequestBody UserWishQuery query) {
        return HttpResult.ok("分页查询所有愿望成功", service.multiListPage(query));
    }
}
