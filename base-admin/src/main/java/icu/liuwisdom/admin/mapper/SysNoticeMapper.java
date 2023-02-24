package icu.liuwisdom.admin.mapper;

import icu.liuwisdom.admin.entity.SysNotice;
import icu.liuwisdom.admin.query.SysNoticeQuery;
import icu.liuwisdom.admin.vo.SysNoticeVo;
import icu.liuwisdom.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 通知表 Mapper 接口
 * </p>
 *
 * @author ldb
 * @since 2022-12-05
 */
public interface SysNoticeMapper extends BaseMapper<SysNotice, SysNoticeQuery, SysNoticeVo> {
    /**
     * 获取id
     *
     * @param query
     * @return java.util.List<java.lang.String>
     * @author LDB
     * @date 2022-12-06
     **/
    @Override
    List<String> selectIds(@Param("query") SysNoticeQuery query);

    /**
     * 分页查询获取结果
     *
     * @param query
     * @param ids
     * @return java.util.List<icu.liuwisdom.admin.vo.SysNoticeVo>
     * @author LDB
     * @date 2022-12-06
     **/
    @Override
    List<SysNoticeVo> basePage(@Param("query") SysNoticeQuery query, @Param("ids") List<String> ids);

    /**
     * 根据id查询
     *
     * @param id
     * @return icu.liuwisdom.admin.vo.SysNoticeVo
     * @author LDB
     * @date 2022-12-06
     **/
    SysNoticeVo selectById(String id);

    /**
     * 分页查询
     *
     * @param query
     * @return java.util.List<icu.liuwisdom.admin.vo.SysNoticeVo>
     * @author LDB
     * @date 2022-12-07
     **/
    List<SysNoticeVo> page(@Param("query") SysNoticeQuery query);
}
