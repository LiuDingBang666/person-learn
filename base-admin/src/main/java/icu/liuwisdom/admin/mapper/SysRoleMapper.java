package icu.liuwisdom.admin.mapper;

import icu.liuwisdom.admin.entity.SysRole;
import icu.liuwisdom.admin.query.SysRoleQuery;
import icu.liuwisdom.admin.vo.SysRoleVo;
import icu.liuwisdom.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色管理 Mapper 接口
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
public interface SysRoleMapper extends BaseMapper<SysRole, SysRoleQuery, SysRoleVo> {

    List<SysRole> selectByUserName(String name);

    /**
     * 查询角色id列表
     *
     * @param query
     * @return java.util.List<java.lang.String>
     * @author LDB
     * @date 2022-07-24
     **/
    @Override
    List<String> selectIds(@Param("query") SysRoleQuery query);

    /**
     * 分页查询角色信息
     *
     * @param query
     * @param ids
     * @return java.util.List<icu.liuwisdom.admin.vo.SysRoleVo>
     * @author LDB
     * @date 2022-07-24
     **/
    @Override
    List<SysRoleVo> basePage(@Param("query") SysRoleQuery query, @Param("ids") List<String> ids);

    SysRoleVo selectById(String id);
}
