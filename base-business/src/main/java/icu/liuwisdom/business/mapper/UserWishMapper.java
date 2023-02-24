package icu.liuwisdom.business.mapper;

import icu.liuwisdom.business.entity.UserWish;
import icu.liuwisdom.business.query.UserWishQuery;
import icu.liuwisdom.business.vo.UserWishVo;
import icu.liuwisdom.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户愿望表 Mapper 接口
 * </p>
 *
 * @author ldb
 * @since 2022-12-12
 */
public interface UserWishMapper extends BaseMapper<UserWish, UserWishQuery, UserWishVo> {

    /**
     * 通过id查询
     *
     * @param query 查询类
     * @return java.util.List<java.lang.String>
     * @author LDB
     * @date 2022-12-13
     **/
    List<String> selectIds(@Param("query") UserWishQuery query);

    /**
     * 通过id查询愿望信息
     *
     * @param id 愿望id
     * @return icu.liuwisdom.business.vo.UserWishVo
     * @author LDB
     * @date 2022-12-13
     **/
    UserWishVo selectById(String id);

    /**
     * 分页查询
     *
     * @param query 查询类
     * @param ids   主键id
     * @return java.util.List<icu.liuwisdom.business.vo.UserWishVo>
     * @author LDB
     * @date 2022-12-13
     **/
    List<UserWishVo> basePage(@Param("query") UserWishQuery query, @Param("ids") List<String> ids);
}
