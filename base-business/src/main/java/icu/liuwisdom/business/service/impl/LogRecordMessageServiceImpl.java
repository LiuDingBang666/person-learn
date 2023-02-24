package icu.liuwisdom.business.service.impl;

import icu.liuwisdom.business.entity.LogRecordMessage;
import icu.liuwisdom.business.mapper.LogRecordMessageMapper;
import icu.liuwisdom.business.service.LogRecordMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 日志留言回复表 服务实现类
 * </p>
 *
 * @author ldb
 * @since 2022-12-12
 */
@Service
public class LogRecordMessageServiceImpl extends ServiceImpl<LogRecordMessageMapper, LogRecordMessage> implements LogRecordMessageService {

}
