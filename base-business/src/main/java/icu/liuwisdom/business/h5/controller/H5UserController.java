package icu.liuwisdom.business.h5.controller;

import icu.liuwisdom.admin.dto.SysUserDto;
import icu.liuwisdom.admin.entity.SysUser;
import icu.liuwisdom.admin.service.SysUserService;
import icu.liuwisdom.admin.utils.UserUtils;
import icu.liuwisdom.constant.SysConstants;
import icu.liuwisdom.core.http.HttpResult;
import icu.liuwisdom.utils.PasswordUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户控制器
 *
 * @author ldb
 * @date 2022-06-02F
 */
@RestController
@RequestMapping("/h5/user")
@Api(tags = "用户管理")
public class H5UserController {

    @Resource
    private SysUserService sysUserService;

    @ApiOperation("修改")
    @PutMapping(value = "/")
    public HttpResult update(@RequestBody @Validated SysUserDto record) {
        SysUser user = sysUserService.getById(record.getId());
        if (user != null) {
            if (SysConstants.ADMIN.equalsIgnoreCase(user.getName())) {
                return HttpResult.error("超级管理员不允许修改!");
            }
        }
        if (record.getPassword() != null) {
            String salt = PasswordUtils.getSalt();
            // 修改用户, 且修改了密码
            if (!record.getPassword().equals(user.getPassword())) {
                String password = PasswordUtils.encode(record.getPassword(), salt);
                record.setSalt(salt);
                record.setPassword(password);
            }
        }
        return HttpResult.ok("修改用户信息成功", sysUserService.updateById(record));
    }


    @ApiOperation("查询当前用户信息")
    @GetMapping(value = "/findByName")
    public HttpResult<SysUser> findByUserName() {
        return HttpResult.ok("通过用户名查询用户信息成功", sysUserService.findByName(UserUtils.getUser().getName()));
    }
}
