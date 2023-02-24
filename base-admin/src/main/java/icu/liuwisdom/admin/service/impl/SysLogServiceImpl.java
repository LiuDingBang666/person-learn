package icu.liuwisdom.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.entity.SysLog;
import icu.liuwisdom.admin.mapper.SysLogMapper;
import icu.liuwisdom.admin.query.SysLogQueryQuery;
import icu.liuwisdom.admin.service.SysLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 系统操作日志 服务实现类
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {
    @Resource
    SysLogMapper sysLogMapper;

    @Override
    public PageInfo<SysLog> pageData(SysLogQueryQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        LambdaQueryWrapper<SysLog> wrapper = new LambdaQueryWrapper<SysLog>()
                .eq(StringUtils.isNotEmpty(query.getUserName()), SysLog::getUserName, query.getUserName())
                .eq(StringUtils.isNotEmpty(query.getOperation()), SysLog::getOperation, query.getOperation())
                .eq(StringUtils.isNotEmpty(query.getIp()), SysLog::getIp, query.getIp());
        List<SysLog> data = sysLogMapper.selectList(wrapper);
        return PageInfo.of(data);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(List<String> records) {
        return this.removeByIds(records);
    }
}
