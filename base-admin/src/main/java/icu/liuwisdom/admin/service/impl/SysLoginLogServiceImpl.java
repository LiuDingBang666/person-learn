package icu.liuwisdom.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.dto.LoginBean;
import icu.liuwisdom.admin.mapper.SysLoginLogMapper;
import icu.liuwisdom.admin.entity.SysLoginLog;
import icu.liuwisdom.admin.query.SysLoginLogQuery;
import icu.liuwisdom.admin.service.SysLoginLogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 系统登录日志 服务实现类
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
@Service
public class SysLoginLogServiceImpl extends ServiceImpl<SysLoginLogMapper, SysLoginLog> implements SysLoginLogService {
    @Resource
    SysLoginLogMapper sysLoginLogMapper;

    @Override
    public PageInfo<SysLoginLog> pageData(SysLoginLogQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        LambdaQueryWrapper<SysLoginLog> wrapper = new LambdaQueryWrapper<SysLoginLog>()
                .eq(StringUtils.isNotEmpty(query.getUserName()), SysLoginLog::getUserName, query.getUserName())
                .eq(StringUtils.isNotEmpty(query.getStatus()), SysLoginLog::getStatus, query.getStatus())
                .eq(StringUtils.isNotEmpty(query.getIp()), SysLoginLog::getIp, query.getIp());
        List<SysLoginLog> data = sysLoginLogMapper.selectList(wrapper);
        return PageInfo.of(data);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(List<String> records) {
        return this.removeByIds(records);
    }

    @Override
    public void add(LoginBean loginBean, String msg, HttpServletRequest request) {
        SysLoginLog sysLoginLog = new SysLoginLog();
        sysLoginLog.setIp(request.getRemoteAddr());
        sysLoginLog.setUserName(loginBean.getAccount());
        sysLoginLog.setStatus(msg);
        this.save(sysLoginLog);
    }
}
