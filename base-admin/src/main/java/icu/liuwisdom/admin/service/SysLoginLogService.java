package icu.liuwisdom.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.dto.LoginBean;
import icu.liuwisdom.admin.entity.SysLoginLog;
import icu.liuwisdom.admin.query.SysLoginLogQuery;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 系统登录日志 服务类
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
public interface SysLoginLogService extends IService<SysLoginLog> {

    PageInfo<SysLoginLog> pageData(SysLoginLogQuery query);

    Boolean delete(List<String> records);

    void add(LoginBean loginBean, String msg, HttpServletRequest request);
}
