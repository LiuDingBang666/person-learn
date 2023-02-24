package icu.liuwisdom.admin.service;

import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.dto.SysDeptDto;
import icu.liuwisdom.admin.entity.SysDept;
import icu.liuwisdom.admin.query.SysDeptQuery;
import icu.liuwisdom.admin.vo.SysDeptVo;
import icu.liuwisdom.core.service.BaseService;

import java.util.List;

/**
 * <p>
 * 机构管理 服务类
 * </p>
 *
 * @author ldb
 * @since 2022-06-01
 */
public interface SysDeptService extends BaseService<SysDept, SysDeptQuery, SysDeptVo> {


    Boolean delete(List<String> records);

    List<SysDeptVo> findTree();

    PageInfo<SysDept> pageData(SysDeptQuery query);

    SysDept save(SysDeptDto dto);

    SysDept updateById(SysDeptDto dto);

    SysDeptVo getById(String id);
}
