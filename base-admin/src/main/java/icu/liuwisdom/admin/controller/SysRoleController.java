package icu.liuwisdom.admin.controller;

import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.dto.SysRoleDto;
import icu.liuwisdom.admin.mapper.SysRoleMapper;
import icu.liuwisdom.admin.entity.SysRole;
import icu.liuwisdom.admin.query.SysRoleQuery;
import icu.liuwisdom.admin.service.SysRoleService;
import icu.liuwisdom.admin.vo.SysRoleVo;
import icu.liuwisdom.constant.SysConstants;
import icu.liuwisdom.core.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 角色控制器
 *
 * @author ldb
 * @date 2022-06-01
 */
@RestController
@RequestMapping("role")
@Api(tags = "角色管理")
public class SysRoleController {

    @Resource
    private SysRoleService sysRoleService;

    @Resource
    private SysRoleMapper sysRoleMapper;

    @PreAuthorize("hasAuthority('sys:role:add')")
    @ApiOperation("新增角色信息")
    @PostMapping(value = "/")
    public HttpResult add(@RequestBody @Validated SysRoleDto record) {
        // 新增角色
        if ((record.getId() == null || record.getId().equals(0)) && !sysRoleService.findByName(record.getName()).isEmpty()) {
            return HttpResult.error("角色名已存在!");
        }
        return HttpResult.ok("新增用户角色信息成功", sysRoleService.save(record));
    }

    @PreAuthorize("hasAuthority('sys:role:alter')")
    @ApiOperation("修改角色信息")
    @PutMapping(value = "/")
    public HttpResult save(@RequestBody @Validated SysRoleDto record) {
        SysRole role = sysRoleService.getById(record.getId());
        if (role != null) {
            if (SysConstants.ADMIN.equalsIgnoreCase(role.getName())) {
                return HttpResult.error("超级管理员不允许修改!");
            }
        }
        // 新增角色
        if ((record.getId() == null || record.getId().equals(0)) && !sysRoleService.findByName(record.getName()).isEmpty()) {
            return HttpResult.error("角色名已存在!");
        }
        return HttpResult.ok("修改用户角色信息成功", sysRoleService.updateById(record));
    }

    @ApiOperation("删除角色信息")
    @PreAuthorize("hasAuthority('sys:role:delete')")
    @DeleteMapping(value = "/{id}")
    public HttpResult delete(@PathVariable("id") String id) {
        return HttpResult.ok("删除用户角色信息成功", sysRoleService.delete(Arrays.asList(id.split(","))));
    }

    @ApiOperation("分页查询角色信息")
    @PreAuthorize("hasAuthority('sys:role:view')")
    @PostMapping(value = "/page")
    public HttpResult<PageInfo<SysRoleVo>> pageData(@RequestBody SysRoleQuery query) {
        PageInfo<SysRoleVo> data = sysRoleService.multiListPage(query);
        return HttpResult.ok("分页查询用户角色信息成功", data);
    }

    @ApiOperation("查询角色下拉框")
    @PreAuthorize("hasAuthority('sys:role:view')")
    @PostMapping(value = "/selected")
    public HttpResult<List<SysRole>> selected(@RequestBody SysRoleQuery query) {
        List<SysRole> data = sysRoleService.getRoleList(query);
        return HttpResult.ok("分页查询用户角色信息成功", data);
    }

    @ApiOperation("通过id查询角色")
    @PreAuthorize("hasAuthority('sys:role:view')")
    @GetMapping(value = "/{id}")
    public HttpResult get(@PathVariable("id") String id) {
        return HttpResult.ok("通过id查询角色成功", sysRoleService.getById(id));
    }

    @ApiOperation("通过角色id查询菜单")
    @PreAuthorize("hasAuthority('sys:role:view')")
    @GetMapping(value = "/findRoleMenus")
    public HttpResult findRoleMenus(@RequestParam String roleId) {
        return HttpResult.ok("通过角色id查询菜单成功", sysRoleService.findRoleMenus(roleId));
    }

}
