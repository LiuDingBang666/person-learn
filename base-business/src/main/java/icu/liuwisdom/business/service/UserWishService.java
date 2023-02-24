package icu.liuwisdom.business.service;

import icu.liuwisdom.business.entity.UserWish;
import icu.liuwisdom.business.query.UserWishQuery;
import icu.liuwisdom.business.vo.UserWishVo;
import icu.liuwisdom.core.service.BaseService;

import java.util.List;

/**
 * <p>
 * 用户愿望表 服务类
 * </p>
 *
 * @author ldb
 * @since 2022-12-12
 */
public interface UserWishService extends BaseService<UserWish, UserWishQuery, UserWishVo> {

    /**
     * 获取最可能实现的愿望
     *
     * @param id 用户id
     * @return icu.liuwisdom.business.vo.UserWishVo
     * @author LDB
     * @date 2022-12-12
     **/
    UserWish bestWish(String id);

    /**
     * 查询我的愿望
     *
     * @param query 查询类
     * @return java.util.List<icu.liuwisdom.business.vo.UserWishVo>
     * @author LDB 查询类
     * @date 2022-12-12
     **/
    List<UserWish> list(UserWishQuery query);

    /**
     * 选择最可能实现的愿望
     *
     * @param id 主表id
     * @return java.lang.Boolean
     * @author LDB
     * @date 2022-12-12
     **/
    Boolean selectWish(String id);

    /**
     * 是否已选择了需要实现的愿望
     *
     * @param id 主表id
     * @return java.lang.Boolean
     * @author LDB
     * @date 2022-12-12
     **/
    Boolean hasSelected(String id);


    /**
     * 根据id查询用户愿望
     *
     * @param id 主键id
     * @return icu.liuwisdom.business.vo.LogRecordVo
     * @author LDB
     * @date 2022-12-12
     **/
    UserWishVo getById(String id);

    /**
     * 确认实现
     *
     * @param id 愿望id
     * @return java.lang.Object
     * @author LDB
     * @date 2022-12-12
     **/
    Boolean confirm(String id);

    /**
     * 是否还能继续选择愿望
     *
     * @param id 用户id
     * @return java.lang.Boolean
     * @author LDB
     * @date 2022-12-13
     **/
    Boolean canSelected(String id);
}
