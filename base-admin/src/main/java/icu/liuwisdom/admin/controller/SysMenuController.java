package icu.liuwisdom.admin.controller;

import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.entity.SysMenu;
import icu.liuwisdom.admin.query.SysMenuQuery;
import icu.liuwisdom.admin.service.SysMenuService;
import icu.liuwisdom.admin.vo.SysMenuVo;
import icu.liuwisdom.core.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 菜单控制器
 *
 * @author ldb
 * @date 2022-06-01
 */
@RestController
@RequestMapping("menu")
@Api(tags = "系统菜单管理")
public class SysMenuController {

    @Resource
    private SysMenuService sysMenuService;

    @ApiOperation("根据id查询菜单信息")
    @PreAuthorize("hasAuthority('sys:menu:view')")
    @GetMapping(value = "/{id}")
    public HttpResult get(@PathVariable("id") String id) {
        SysMenu data = sysMenuService.getById(id);
        return HttpResult.ok("根据id查询菜单信息成功", data);
    }

    @ApiOperation("新增系统菜单")
    @PreAuthorize("hasAuthority('sys:menu:add')")
    @PostMapping(value = "/")
    public HttpResult add(@RequestBody SysMenu record) {
        if (record.getOrderNum() == null) {
            record.setOrderNum(0);
        }
        return HttpResult.ok("新增系统菜单成功", sysMenuService.save(record));
    }

    @ApiOperation("修改系统菜单")
    @PreAuthorize("hasAuthority('sys:menu:alter')")
    @PutMapping(value = "/")
    public HttpResult update(@RequestBody SysMenu record) {
        if (record.getOrderNum() == null) {
            record.setOrderNum(0);
        }
        return HttpResult.ok("修改系统菜单成功", sysMenuService.updateById(record));
    }

    @ApiOperation("删除系统菜单")
    @PreAuthorize("hasAuthority('sys:menu:delete')")
    @DeleteMapping(value = "/{id}")
    public HttpResult delete(@PathVariable("id") String ids) {
        return HttpResult.ok("删除系统菜单成功", sysMenuService.delete(Arrays.asList(ids.split(","))));
    }

    @ApiOperation("根据用户名查询导航树")
    @GetMapping(value = "/findNavTree/{userName}")
    public HttpResult findNavTree(@PathVariable("userName") String userName) {
        List<SysMenuVo> data = sysMenuService.findTree(userName);
        return HttpResult.ok("根据用户名查询导航树成功", data);
    }

    @ApiOperation("查询菜单树")
    @PreAuthorize("hasAuthority('sys:menu:view')")
    @PostMapping(value = "/findMenuTree")
    public HttpResult findMenuTree() {
        return HttpResult.ok("查询菜单树成功", sysMenuService.findTree(null));
    }


    @ApiOperation("分页查询菜单")
    @PreAuthorize("hasAuthority('sys:menu:view')")
    @PostMapping(value = "/page")
    public HttpResult<PageInfo<SysMenuVo>> page(@RequestBody SysMenuQuery query) {
        return HttpResult.ok("查询菜单树成功", sysMenuService.pageData(query));
    }
}
