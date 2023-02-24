package icu.liuwisdom.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.dto.SysRoleDto;
import icu.liuwisdom.admin.mapper.SysMenuMapper;
import icu.liuwisdom.admin.mapper.SysRoleDeptMapper;
import icu.liuwisdom.admin.mapper.SysRoleMapper;
import icu.liuwisdom.admin.mapper.SysRoleMenuMapper;
import icu.liuwisdom.admin.entity.SysMenu;
import icu.liuwisdom.admin.entity.SysRole;
import icu.liuwisdom.admin.entity.SysRoleDept;
import icu.liuwisdom.admin.entity.SysRoleMenu;
import icu.liuwisdom.admin.query.SysRoleQuery;
import icu.liuwisdom.admin.service.SysRoleMenuService;
import icu.liuwisdom.admin.service.SysRoleService;
import icu.liuwisdom.admin.vo.SysMenuVo;
import icu.liuwisdom.admin.vo.SysRoleVo;
import icu.liuwisdom.core.service.impl.BaseServiceImpl;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色管理 服务实现类
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
@Service
public class SysRoleServiceImplImpl extends BaseServiceImpl<SysRoleMapper, SysRole, SysRoleQuery, SysRoleVo> implements SysRoleService {
    @Resource
    SysRoleMenuService sysRoleMenuService;

    @Resource
    SysMenuServiceImpl sysMenuService;

    @Resource
    SysRoleMenuMapper sysRoleMenuMapper;
    @Resource
    SysRoleMapper sysRoleMapper;
    @Resource
    SysMenuMapper sysMenuMapper;

    @Resource
    SysRoleDeptMapper sysRoleDeptMapper;

    /**
     * 通过用户名查询角色信息
     *
     * @param name 用户名
     * @return java.util.Collection<java.lang.Object>
     * @author Ldb
     * @date 2022-06-02
     **/
    @Override
    public List<SysRole> findByName(String name) {
        return sysRoleMapper.selectByUserName(name);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(List<String> records) {
        return this.removeByIds(records);
    }

    @Override
    public PageInfo<SysRole> pageData(SysRoleQuery query) {
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<SysRole>().eq(StringUtils.isNotEmpty(query.getName()), SysRole::getName, query.getName());
        List<SysRole> data = sysRoleMapper.selectList(wrapper);
        return PageInfo.of(data);
    }

    /**
     * 根据用户id查询角色菜单信息
     *
     * @param userId 用户id
     * @return icu.liuwisdom.admin.vo.SysMenuVo
     * @author Ldb
     * @date 2022-06-02
     **/
    @Override
    public List<SysMenu> findRoleMenus(String userId) {
        // 获取用户菜单列表
        return sysMenuMapper.selectMenusByUserId(userId);
    }

    /**
     * 获取角色列表
     *
     * @param query 查询类
     * @return java.util.List<icu.liuwisdom.admin.po.SysRole>
     * @author LDB
     * @date 2022-07-17
     **/
    @Override
    public List<SysRole> getRoleList(SysRoleQuery query) {
        // 获取指定部门的角色信息
        List<String> roleId = new ArrayList<>();
        if (StringUtils.isNotEmpty(query.getFkDeptId())) {
            roleId = sysRoleDeptMapper.selectList(new LambdaQueryWrapper<SysRoleDept>().eq(StringUtils.isNotEmpty(query.getFkDeptId()), SysRoleDept::getDeptId, query.getFkDeptId())).stream().map(val -> val.getRoleId()).collect(Collectors.toList());
            // 当前机构没有角色
            if (roleId.isEmpty()) {
                return new ArrayList<>();
            }
        }
        return this.list(new LambdaQueryWrapper<SysRole>().in(!roleId.isEmpty(), SysRole::getId, roleId));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysRole save(SysRoleDto dto) {
        SysRole po = new SysRole();
        BeanUtils.copyProperties(dto, po);
        this.save(po);
        dto.setId(po.getId());
        insertRoleMenu(dto);
        return po;
    }

    /**
     * 新增角色菜单信息
     *
     * @param dto 表单
     * @return java.lang.Boolean
     * @author LDB
     * @date 2022-07-17
     **/
    private Boolean insertRoleMenu(SysRoleDto dto) {
        if (null == dto.getSysRoleMenus() || dto.getSysRoleMenus().isEmpty()) {
            return true;
        }
        List<SysRoleMenu> roleMenus = dto.getSysRoleMenus().stream().map(val -> {
            val.setRoleId(dto.getId());
            return val;
        }).collect(Collectors.toList());
        return sysRoleMenuService.saveBatch(roleMenus);
    }

    @Override
    public PageInfo<SysRoleVo> multiListPage(SysRoleQuery query) {
        PageInfo<SysRoleVo> info = super.multiListPage(query);
        val list = info.getList();
        for (SysRoleVo vo : list) {
            List<SysMenuVo> voList = vo.getMenu().stream().map(val -> val.toVo()).collect(Collectors.toList());
            vo.setMenuTree(sysMenuService.buildTree(voList));
        }
        info.setList(list);
        return info;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysRole updateById(SysRoleDto dto) {
        SysRole po = new SysRole();
        BeanUtils.copyProperties(dto, po);
        this.updateById(po);
        dto.setId(po.getId());
        deleteRoleMenuByRoleId(dto.getId());
        insertRoleMenu(dto);
        return po;
    }

    @Override
    public SysRoleVo getById(String id) {
        val data = sysRoleMapper.selectById(id);
        val vo = data.getMenu().stream().map(val -> val.toVo()).collect(Collectors.toList());
        data.setMenuTree(sysMenuService.buildTree(vo));
        return data;
    }

    /**
     * 通过角色id删除角色菜单信息
     *
     * @param id 角色id
     * @author LDB
     * @date 2022-07-17
     **/
    private void deleteRoleMenuByRoleId(String id) {
        sysRoleMenuMapper.delete(new LambdaQueryWrapper<SysRoleMenu>().eq(SysRoleMenu::getRoleId, id));
    }
}
