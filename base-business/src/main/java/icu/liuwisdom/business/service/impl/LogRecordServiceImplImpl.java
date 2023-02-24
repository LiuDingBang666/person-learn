package icu.liuwisdom.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageInfo;
import icu.liuwisdom.business.entity.LogRecord;
import icu.liuwisdom.business.mapper.LogRecordMapper;
import icu.liuwisdom.business.query.LogRecordQuery;
import icu.liuwisdom.business.service.LogRecordService;
import icu.liuwisdom.business.vo.LogRecordMessageVo;
import icu.liuwisdom.business.vo.LogRecordVo;
import icu.liuwisdom.core.service.impl.BaseServiceImpl;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 日志记录表 服务实现类
 * </p>
 *
 * @author ldb
 * @since 2022-12-12
 */
@Service
public class LogRecordServiceImplImpl extends BaseServiceImpl<LogRecordMapper, LogRecord, LogRecordQuery, LogRecordVo> implements LogRecordService {
    @Resource
    LogRecordMapper mapper;

    @Override
    public LambdaQueryWrapper<LogRecord> wrapper(LogRecordQuery query) {
        return super.wrapper(query)
                .eq(StringUtils.isNotEmpty(query.getFkUserId()), LogRecord::getFkUserId, query.getFkUserId())
                .like(StringUtils.isNotEmpty(query.getTitle()), LogRecord::getTitle, query.getTitle())
                .like(StringUtils.isNotEmpty(query.getContent()), LogRecord::getContent, query.getContent())
                .eq(null != query.getIsPublic(), LogRecord::getIsPublic, query.getIsPublic());
    }

    @Override
    public PageInfo<LogRecord> page(LogRecordQuery query) {
        return this.listPage(query);
    }

    @Override
    public LogRecordVo getById(String id) {
        // 查询基本信息
        LogRecordVo vo = mapper.selectById(id);
        if (Objects.nonNull(vo.getMessages()) && !vo.getMessages().isEmpty()) {
            vo.setMessageTree(buildTree(vo.getMessages()));
        }
        // 组装留言信息
        return vo;
    }

    /**
     * 构建日志消息树
     *
     * @param messages 日志消息
     * @return java.util.List<icu.liuwisdom.business.vo.LogRecordMessageVo>
     * @author LDB
     * @date 2022-12-13
     **/
    public List<LogRecordMessageVo> buildTree(List<LogRecordMessageVo> messages) {
        val firstNode = messages.stream().filter(val -> StringUtils.isEmpty(val.getParentId())).collect(Collectors.toList());
        return findChildren(firstNode, messages);
    }

    /**
     * 查询子节点
     *
     * @param firstNode    首级节点
     * @param childrenNode 子节点
     * @return java.util.List<icu.liuwisdom.business.vo.LogRecordMessageVo>
     * @author LDB
     * @date 2022-12-13
     **/
    public List<LogRecordMessageVo> findChildren(List<LogRecordMessageVo> firstNode, List<LogRecordMessageVo> childrenNode) {
        for (LogRecordMessageVo parent : firstNode) {
            for (LogRecordMessageVo child : childrenNode) {
                if (StringUtils.isNotEmpty(child.getParentId()) && child.getParentId().equals(parent.getId())) {
                    parent.getChildren().add(child);
                }
            }
            if (!parent.getChildren().isEmpty()) {
                findChildren(parent.getChildren(), childrenNode);
            }
        }
        return firstNode;
    }
}
