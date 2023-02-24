package icu.liuwisdom.admin.mapper;

import icu.liuwisdom.admin.entity.SysUser;
import icu.liuwisdom.admin.query.SysUserQuery;
import icu.liuwisdom.admin.vo.SysUserVo;
import icu.liuwisdom.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户管理 Mapper 接口
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
public interface SysUserMapper extends BaseMapper<SysUser, SysUserQuery, SysUserVo> {
    /**
     * 通过用户名查询用户信息
     *
     * @param name
     * @return icu.liuwisdom.admin.vo.SysUserVo
     * @author LDB
     * @date 2022-06-08
     **/
    SysUserVo selectByName(String name);

    /**
     * 查询用户id列表
     *
     * @param query
     * @return java.util.List<java.lang.String>
     * @author LDB
     * @date 2022-07-24
     **/
    @Override
    List<String> selectIds(@Param("query") SysUserQuery query);


    /**
     * 分页查询用户信息
     *
     * @param query 查询类
     * @param ids   id列表
     * @return java.util.List<icu.liuwisdom.admin.po.SysUser>
     * @author LDB
     * @date 2022-07-24
     **/
    @Override
    List<SysUserVo> basePage(@Param("query") SysUserQuery query, @Param("ids") List<String> ids);


    SysUserVo selectById(String id);
}
