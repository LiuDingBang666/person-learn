package icu.liuwisdom.admin.service;

import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.entity.SysDict;
import com.baomidou.mybatisplus.extension.service.IService;
import icu.liuwisdom.admin.query.SysDictQuery;

import java.util.List;

/**
 * <p>
 * 字典表 服务类
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
public interface SysDictService extends IService<SysDict> {

    Boolean delete(List<String> records);

    PageInfo<SysDict> pageData(SysDictQuery query);
}
