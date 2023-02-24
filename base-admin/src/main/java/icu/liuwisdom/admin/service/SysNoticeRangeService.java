package icu.liuwisdom.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import icu.liuwisdom.admin.entity.SysNoticeRange;

/**
 * <p>
 * 通知范围表 服务类
 * </p>
 *
 * @author ldb
 * @since 2022-12-05
 */
public interface SysNoticeRangeService extends IService<SysNoticeRange> {
    /**
     * 通过通知id删除所有通知范围信息
     *
     * @param id
     * @return java.lang.Boolean
     * @author LDB
     * @date 2022-12-06
     **/
    Boolean deleteByNoticeId(String id);
}
