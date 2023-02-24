package icu.liuwisdom.admin.service;

import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.dto.SysNoticeDto;
import icu.liuwisdom.admin.entity.SysNotice;
import icu.liuwisdom.admin.query.SysNoticeQuery;
import icu.liuwisdom.admin.vo.SysNoticeVo;
import icu.liuwisdom.core.service.BaseService;

/**
 * <p>
 * 通知表 服务类
 * </p>
 *
 * @author ldb
 * @since 2022-12-05
 */
public interface SysNoticeService extends BaseService<SysNotice, SysNoticeQuery, SysNoticeVo> {

    /**
     * 发布
     *
     * @param id 主键id
     * @return boolean
     * @author LDB
     * @date 2022-12-06
     **/
    boolean publish(String id);

    /**
     * 禁用
     *
     * @param id 主键id
     * @author LDB
     * @date 2022-12-06
     **/
    boolean disabled(String id);

    /**
     * 通过id查询
     *
     * @param id     id
     * @param update 是否更新阅读量
     * @return icu.liuwisdom.admin.vo.SysNoticeVo
     * @author LDB
     * @date 2022-12-18
     **/
    SysNoticeVo getById(String id, boolean update);


    /**
     * 新增
     *
     * @param dto
     * @return icu.liuwisdom.admin.entity.SysNotice
     * @author LDB
     * @date 2022-12-06
     **/
    SysNotice save(SysNoticeDto dto);

    /**
     * 修改
     *
     * @param dto
     * @return icu.liuwisdom.admin.entity.SysNotice
     * @author LDB
     * @date 2022-12-06
     **/
    SysNotice updateById(SysNoticeDto dto);


    /**
     * 通过id删除
     *
     * @param id
     * @return boolean
     * @author LDB
     * @date 2022-12-06
     **/
    boolean removeById(String id);


    /**
     * 分页查询我的通知
     *
     * @param query
     * @return com.github.pagehelper.PageInfo<icu.liuwisdom.admin.vo.SysNoticeVo>
     * @author LDB
     * @date 2022-12-07
     **/
    PageInfo<SysNoticeVo> page(SysNoticeQuery query);

}
