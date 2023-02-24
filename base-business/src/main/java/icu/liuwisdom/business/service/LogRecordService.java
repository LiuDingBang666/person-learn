package icu.liuwisdom.business.service;

import com.github.pagehelper.PageInfo;
import icu.liuwisdom.business.entity.LogRecord;
import icu.liuwisdom.business.query.LogRecordQuery;
import icu.liuwisdom.business.vo.LogRecordVo;
import icu.liuwisdom.core.service.BaseService;

/**
 * <p>
 * 日志记录表 服务类
 * </p>
 *
 * @author ldb
 * @since 2022-12-12
 */
public interface LogRecordService extends BaseService<LogRecord, LogRecordQuery, LogRecordVo> {


    /**
     * 分页查询我的日志
     *
     * @param query
     * @return com.github.pagehelper.PageInfo<icu.liuwisdom.business.entity.LogRecord>
     * @author LDB
     * @date 2022-12-12
     **/
    PageInfo<LogRecord> page(LogRecordQuery query);


    /**
     * 根据id查询日志消息
     *
     * @param id 主键id
     * @return icu.liuwisdom.business.vo.LogRecordVo
     * @author LDB
     * @date 2022-12-12
     **/
    LogRecordVo getById(String id);
}
