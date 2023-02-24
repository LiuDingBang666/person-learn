package icu.liuwisdom.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import icu.liuwisdom.business.entity.UserWishImpl;
import icu.liuwisdom.business.vo.UserWishVo;

import java.util.List;

/**
 * <p>
 * 愿望实现表 服务类
 * </p>
 *
 * @author ldb
 * @since 2022-12-12
 */
public interface UserWishImplService extends IService<UserWishImpl> {

    /**
     * 查询我实现的愿望
     *
     * @param id
     * @return icu.liuwisdom.business.vo.UserWishVo
     * @author LDB
     * @date 2022-12-12
     **/
    List<UserWishVo> mine(String id);
}
