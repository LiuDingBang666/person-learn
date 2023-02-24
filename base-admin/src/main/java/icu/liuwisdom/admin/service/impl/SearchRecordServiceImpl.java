package icu.liuwisdom.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import icu.liuwisdom.admin.entity.SearchRecord;
import icu.liuwisdom.admin.mapper.SearchRecordMapper;
import icu.liuwisdom.admin.service.SearchRecordService;
import icu.liuwisdom.utils.StringUtils;
import lombok.val;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * <p>
 * 搜索记录表 服务实现类
 * </p>
 *
 * @author ldb
 * @since 2022-12-11
 */
@Service
public class SearchRecordServiceImpl extends ServiceImpl<SearchRecordMapper, SearchRecord> implements SearchRecordService {
    @Resource
    SearchRecordMapper mapper;

    @Override
    public boolean save(SearchRecord entity) {
        if (StringUtils.isBlank(entity.getContent())) {
            return false;
        }
        val po = mapper.selectOne(new LambdaQueryWrapper<SearchRecord>().eq(SearchRecord::getContent, entity.getContent()).eq(SearchRecord::getFkUserId, entity.getFkUserId()).last("limit 1"));
        if (Objects.nonNull(po)) {
            return false;
        }
        return super.save(entity);
    }

    @Override
    public Boolean clean(String id) {
        this.remove(new LambdaQueryWrapper<SearchRecord>().eq(SearchRecord::getFkUserId, id));
        return true;
    }
}
