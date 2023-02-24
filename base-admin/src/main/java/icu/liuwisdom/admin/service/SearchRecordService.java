package icu.liuwisdom.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import icu.liuwisdom.admin.entity.SearchRecord;

/**
 * <p>
 * 搜索记录表 服务类
 * </p>
 *
 * @author ldb
 * @since 2022-12-11
 */
public interface SearchRecordService extends IService<SearchRecord> {

    /**
     * 清空历史记录
     *
     * @param id 用户id
     * @return java.lang.Boolean
     * @author LDB
     * @date 2022-12-11
     **/
    Boolean clean(String id);
}
