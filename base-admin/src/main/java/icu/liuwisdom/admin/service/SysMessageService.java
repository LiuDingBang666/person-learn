package icu.liuwisdom.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.entity.SysMessage;
import icu.liuwisdom.admin.query.SysMessageQuery;

/**
 * <p>
 * 消息表 服务类
 * </p>
 *
 * @author ldb
 * @since 2022-12-05
 */
public interface SysMessageService extends IService<SysMessage> {

    /**
     * 已读
     *
     * @param id
     * @return java.lang.Boolean
     * @author LDB
     * @date 2022-12-06
     **/
    Boolean read(String id);

    /**
     * 处理
     *
     * @param id
     * @return java.lang.Boolean
     * @author LDB
     * @date 2022-12-06
     **/
    Boolean handed(String id);

    /**
     * 分页数据
     *
     * @param query
     * @return com.github.pagehelper.PageInfo<icu.liuwisdom.admin.entity.SysMessage>
     * @author LDB
     * @date 2022-12-06
     **/
    PageInfo<SysMessage> pageData(SysMessageQuery query);
}
