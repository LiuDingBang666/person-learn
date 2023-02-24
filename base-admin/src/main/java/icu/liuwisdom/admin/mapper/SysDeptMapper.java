package icu.liuwisdom.admin.mapper;

import icu.liuwisdom.admin.entity.SysDept;
import icu.liuwisdom.admin.query.SysDeptQuery;
import icu.liuwisdom.admin.vo.SysDeptVo;
import icu.liuwisdom.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 机构管理 Mapper 接口
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
public interface SysDeptMapper extends BaseMapper<SysDept, SysDeptQuery, SysDeptVo> {

    /**
     * 查询用户id列表
     *
     * @param query
     * @return java.util.List<java.lang.String>
     * @author LDB
     * @date 2022-07-24
     **/
    @Override
    List<String> selectIds(@Param("query") SysDeptQuery query);


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
    List<SysDeptVo> basePage(@Param("query") SysDeptQuery query, @Param("ids") List<String> ids);


    SysDeptVo selectById(String id);
}
