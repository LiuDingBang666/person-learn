package icu.liuwisdom.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.entity.SysMenu;
import icu.liuwisdom.admin.entity.SysUser;
import icu.liuwisdom.admin.mapper.SysMenuMapper;
import icu.liuwisdom.admin.query.SysMenuQuery;
import icu.liuwisdom.admin.service.SysMenuService;
import icu.liuwisdom.admin.service.SysRoleService;
import icu.liuwisdom.admin.service.SysUserService;
import icu.liuwisdom.admin.vo.SysMenuVo;
import icu.liuwisdom.core.exception.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单管理 服务实现类
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
    @Resource
    SysRoleService sysRoleService;
    @Resource
    SysUserService sysUserService;

    @Resource
    SysMenuMapper sysMenuMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(List<String> records) {
        return this.removeByIds(records);
    }

    /**
     * 查询菜单树
     *
     * @param userName 用户名
     * @return icu.liuwisdom.admin.vo.SysMenuVo
     * @author Ldb
     * @date 2022-06-02
     **/
    @Override
    public List<SysMenuVo> findTree(String userName) {
        List<SysMenu> list;
        // 获取菜单列表
        if (StringUtils.isEmpty(userName) || userName.equals("admin")) {
            list = this.list();
        } else {
            // 用户名存在且不为超级管理员，获取用户角色下的菜单
            SysUser user = sysUserService.findByName(userName);
            if (null == user) {
                throw new BusinessException("用户不存在");
            }
            list = sysRoleService.findRoleMenus(user.getId());
        }
        List<SysMenuVo> menuVo = list.stream().map(i -> i.toVo()).collect(Collectors.toList());
        return buildTree(menuVo);
    }

    /**
     * 生成菜单树
     *
     * @param list 菜单列表
     *             菜单类型 按钮(type=2)需要过滤掉
     * @return java.util.List<icu.liuwisdom.admin.vo.SysMenuVo>
     * @author Ldb
     * @date 2022-06-03
     **/
    @Override
    public List<SysMenuVo> buildTree(List<SysMenuVo> list) {
        List<SysMenuVo> parents = new ArrayList<>();
        // 构建一级菜单
        for (SysMenuVo sysMenuVo : list) {
            if (StringUtils.isEmpty(sysMenuVo.getParentId()) || sysMenuVo.getParentId().equals(0) || sysMenuVo.getType().equals(0)) {
                sysMenuVo.setLevel(0);
                parents.add(sysMenuVo);
            }
        }
        // 对一级菜单进行排序
        parents = parents.stream().sorted(Comparator.comparingInt(SysMenu::getOrderNum))
                .collect(Collectors.toList());
        // 构建子级菜单
        findChildren(parents, list);
        return parents;
    }

    @Override
    public PageInfo<SysMenuVo> pageData(SysMenuQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<SysMenuVo> data = sysMenuMapper.pageData(query);
        return PageInfo.of(data);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(SysMenu entity) {
        boolean save = super.save(entity);
        updatePermission(entity);
        return save;
    }


    /**
     * 更新菜单权限
     * 1、原先已经绑定的菜单权限怎样处理(原先已配置的权限，需要被手动删除,除非将权限置空)
     * 2、新增加的菜单权限如何和之前的菜单权限区分（如果之前已经配置过，则跳过新增）
     * 权限配置参考 todo: 新增-sys:user:add,修改-sys:user:update
     *
     * @param entity 实体
     * @author LDB
     * @date 2022-09-18
     **/
    private void updatePermission(SysMenu entity) {
        String perms = entity.getPerms();
        // 权限不为空且必须为目录
        if (StringUtils.isEmpty(perms)) {
            if (entity.getType() == 1) {
                // 如果权限为空且为菜单。则删除该菜单下的所有权限按钮
                sysMenuMapper.delete(new LambdaQueryWrapper<SysMenu>()
                        .eq(SysMenu::getType, 2)
                        .eq(SysMenu::getParentId, entity.getId()));
            }
            return;
        }
        // 获取待新增的权限列表
        List<String> permissionList = Arrays.asList(perms.split(","));
        if (permissionList.isEmpty()) {
            throw new BusinessException("权限参数配置有误,正确格式为:新增-sys:user:add,修改-sys:user:update");
        }
        // 获取已存在的按钮权限
        List<String> permsBtn = sysMenuMapper.selectList(
                        new LambdaQueryWrapper<SysMenu>()
                                .eq(SysMenu::getParentId, entity.getId())
                                .eq(SysMenu::getType, 2))
                .stream().map(val -> val.getPerms()).collect(Collectors.toList());
        StringBuffer stringBuffer = new StringBuffer();
        //sys:user:updatesys:user:view
        permsBtn.forEach(val -> stringBuffer.append(val));
        String hasPermissionValue = stringBuffer.toString();
        // 只新增未新增过的按钮
        permissionList.stream()
                .forEach(val -> {
                    List<String> permissionInfo = Arrays.asList(val.split("-"));
                    if (permissionInfo.size() != 2) {
                        throw new BusinessException("权限参数配置有误,正确格式为:新增-sys:user:add");
                    }
                    SysMenu menu = new SysMenu();
                    if (StringUtils.isEmpty(hasPermissionValue) || hasPermissionValue.indexOf(permissionInfo.get(1)) == -1) {
                        menu.setParentId(entity.getId());
                        menu.setType(2);
                        menu.setOrderNum(0);
                        menu.setName(permissionInfo.get(0));
                        menu.setPerms(permissionInfo.get(1));
                        sysMenuMapper.insert(menu);
                    }
                });
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateById(SysMenu entity) {
        boolean res = super.updateById(entity);
        updatePermission(entity);
        return res;
    }

    /**
     * 查找子级菜单
     *
     * @param parents 一级菜单
     * @param list    菜单列表
     * @author Ldb
     * @date 2022-06-03
     **/

    private void findChildren(List<SysMenuVo> parents, List<SysMenuVo> list) {
        for (SysMenuVo parent : parents) {
            List<SysMenuVo> children = new ArrayList<>();
            for (SysMenuVo sysMenuVo : list) {
//                if (!StringUtils.isEmpty(sysMenuVo.getType()) && sysMenuVo.getType().equals(2)) {
//                    continue;
//                }
                String parentId = sysMenuVo.getParentId();
                if (!StringUtils.isEmpty(parentId) && parentId.equals(parent.getId())) {
                    sysMenuVo.setLevel(parent.getLevel() + 1);
                    sysMenuVo.setParentName(parent.getName());
                    children.add(sysMenuVo);
                }
            }
            // 对子级菜单信息排序
            children = children.stream().sorted(Comparator.comparingInt(SysMenu::getOrderNum)).collect(Collectors.toList());
            parent.setChildren(children);
            if (!children.isEmpty()) {
                findChildren(children, list);
            }
        }
    }
}
