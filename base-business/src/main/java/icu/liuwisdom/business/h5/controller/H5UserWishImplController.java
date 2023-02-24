package icu.liuwisdom.business.h5.controller;


import icu.liuwisdom.admin.utils.UserUtils;
import icu.liuwisdom.business.entity.UserWishImpl;
import icu.liuwisdom.business.service.UserWishImplService;
import icu.liuwisdom.business.vo.UserWishVo;
import icu.liuwisdom.core.http.HttpResult;
import icu.liuwisdom.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.val;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 愿望实现表 前端控制器
 * </p>
 *
 * @author ldb
 * @since 2022-12-12
 */
@Api(tags = "愿望实现表")
@RestController
@RequestMapping("/h5/userWishImpl")
public class H5UserWishImplController {
    @Resource
    UserWishImplService service;

    @ApiOperation("实现愿望")
    @PostMapping(value = "/")
    public HttpResult<Boolean> add(@RequestBody @Validated UserWishImpl record) {
        val user = UserUtils.getUser();
        record.setFkUserId(user.getId());
        record.setUserName(StringUtils.isBlank(user.getNickName()) ? user.getName() : user.getNickName());
        return HttpResult.ok("实现愿望成功", service.save(record));
    }

    @ApiOperation("查询我实现的愿望")
    @PostMapping(value = "/mine/")
    public HttpResult<List<UserWishVo>> mine() {
        val user = UserUtils.getUser();
        return HttpResult.ok("实现愿望成功", service.mine(user.getId()));
    }
}
