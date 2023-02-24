package icu.liuwisdom.admin.service;

import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.dto.SysRoleDto;
import icu.liuwisdom.admin.entity.SysMenu;
import icu.liuwisdom.admin.entity.SysRole;
import icu.liuwisdom.admin.query.SysRoleQuery;
import icu.liuwisdom.admin.vo.SysRoleVo;
import icu.liuwisdom.core.service.BaseService;

import java.util.List;

/**
 * <p>
 * 角色管理 服务类
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
public interface SysRoleService extends BaseService<SysRole, SysRoleQuery, SysRoleVo> {

    List<SysRole> findByName(String name);

    Boolean delete(List<String> records);

    PageInfo<SysRole> pageData(SysRoleQuery query);

    List<SysMenu> findRoleMenus(String userId);

    List<SysRole> getRoleList(SysRoleQuery query);

    SysRole save(SysRoleDto dto);

    SysRole updateById(SysRoleDto dto);

    SysRoleVo getById(String id);
}
