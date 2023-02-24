package icu.liuwisdom.business.mapper;

import icu.liuwisdom.business.entity.LogRecord;
import icu.liuwisdom.business.query.LogRecordQuery;
import icu.liuwisdom.business.vo.LogRecordVo;
import icu.liuwisdom.core.mapper.BaseMapper;

/**
 * <p>
 * 日志记录表 Mapper 接口
 * </p>
 *
 * @author ldb
 * @since 2022-12-12
 */
public interface LogRecordMapper extends BaseMapper<LogRecord, LogRecordQuery, LogRecordVo> {
    /**
     * 根据id查询日志留言信息
     *
     * @param id 主键id
     * @return icu.liuwisdom.business.vo.LogRecordVo
     * @author LDB
     * @date 2022-12-13
     **/
    LogRecordVo selectById(String id);
}
