package icu.liuwisdom.admin.controller;

import icu.liuwisdom.admin.dto.SysUserDto;
import icu.liuwisdom.admin.entity.SysUser;
import icu.liuwisdom.admin.query.SysUserQuery;
import icu.liuwisdom.admin.service.SysUserService;
import icu.liuwisdom.admin.vo.SysUserVo;
import icu.liuwisdom.constant.SysConstants;
import icu.liuwisdom.core.http.HttpResult;
import icu.liuwisdom.core.page.PageRequest;
import icu.liuwisdom.utils.FileUtils;
import icu.liuwisdom.utils.PasswordUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * 用户控制器
 *
 * @author ldb
 * @date 2022-06-02F
 */
@RestController
@RequestMapping("user")
@Api(tags = "用户管理")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @ApiOperation("新增用户信息")
    @PreAuthorize("hasAuthority('sys:user:add')")
    @PostMapping(value = "/")
    public HttpResult add(@RequestBody @Validated SysUserDto record) {
        // 新增用户
        if (sysUserService.findByName(record.getName()) != null) {
            return HttpResult.error("用户名已存在!");
        }
        String salt = PasswordUtils.getSalt();
        String password = PasswordUtils.encode(record.getPassword(), salt);
        record.setSalt(salt);
        record.setPassword(password);
        sysUserService.save(record);
        return HttpResult.ok("新增用户信息成功", record);
    }

    @ApiOperation("修改用户信息")
    @PreAuthorize("hasAuthority('sys:user:alter')")
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

    @ApiOperation("删除用户信息")
    @PreAuthorize("hasAuthority('sys:user:delete')")
    @DeleteMapping(value = "/{id}")
    public HttpResult delete(@PathVariable("id") String records) {
        List<String> ids = Arrays.asList(records.split(","));
        for (String id : ids) {
            SysUser sysUser = sysUserService.getById(id);
            if (sysUser != null && SysConstants.ADMIN.equalsIgnoreCase(sysUser.getName())) {
                return HttpResult.error("超级管理员不允许删除!");
            }
        }
        return HttpResult.ok("删除用户信息成功", sysUserService.delete(ids));
    }

    @ApiOperation("通过用户名查询用户信息")
    @GetMapping(value = "/findByName")
    public HttpResult findByUserName(@RequestParam String name) {
        return HttpResult.ok("通过用户名查询用户信息成功", sysUserService.findByName(name));
    }

    @ApiOperation("通过用户id查询用户信息")
    @PreAuthorize("hasAuthority('sys:user:view')")
    @GetMapping(value = "/{id}")
    public HttpResult<SysUserVo> get(@PathVariable("id") String id) {
        return HttpResult.ok("通过用户id查询用户信息", sysUserService.getById(id));
    }

    @ApiOperation("通过用户名查询用户所有信息")
    @GetMapping(value = "/findAllByName/{name}")
    public HttpResult<SysUserVo> findAllByUserName(@PathVariable("name") String name) {
        return HttpResult.ok("通过用户名查询用户信息成功", sysUserService.findAllByName(name));
    }

    @ApiOperation("通过用户名查询用户权限")
    @GetMapping(value = "/findPermissions")
    public HttpResult findPermissions(@RequestParam String name) {
        return HttpResult.ok("通过用户名查询用户权限成功", sysUserService.findPermissions(name));
    }

    @ApiOperation("通过用户id查询用户角色")
    @GetMapping(value = "/findUserRoles/{id}")
    public HttpResult findUserRoles(@PathVariable("id") String userId) {
        return HttpResult.ok("通过用户id查询用户角色成功", sysUserService.findUserRoles(userId));
    }

    @ApiOperation("分页查询用户信息")
    @PreAuthorize("hasAuthority('sys:user:view')")
    @PostMapping(value = "/page")
    public HttpResult findPage(@RequestBody SysUserQuery query) {
        return HttpResult.ok("分页查询用户信息成功", sysUserService.multiListPage(query));
    }

    @ApiOperation("导出用户信息")
    @PostMapping(value = "/export")
    public void exportExcelUser(@RequestBody PageRequest pageRequest, HttpServletResponse res) {
        File file = sysUserService.createUserExcelFile(pageRequest);
        FileUtils.downloadFile(res, file, file.getName());
    }

}
