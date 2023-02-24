package icu.liuwisdom.admin.service;

import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.entity.SysLog;
import com.baomidou.mybatisplus.extension.service.IService;
import icu.liuwisdom.admin.query.SysLogQueryQuery;

import java.util.List;

/**
 * <p>
 * 系统操作日志 服务类
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
public interface SysLogService extends IService<SysLog> {

    PageInfo<SysLog> pageData(SysLogQueryQuery query);

    boolean delete(List<String> records);
}
