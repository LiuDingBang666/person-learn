package icu.liuwisdom.admin.service;

import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.entity.SysConfig;
import com.baomidou.mybatisplus.extension.service.IService;
import icu.liuwisdom.admin.query.SysConfigQuery;

import java.util.List;

/**
 * <p>
 * 系统配置表 服务类
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
public interface SysConfigService extends IService<SysConfig> {

    Boolean delete(List<String> records);

    PageInfo<SysConfig> pageData(SysConfigQuery query);
}
