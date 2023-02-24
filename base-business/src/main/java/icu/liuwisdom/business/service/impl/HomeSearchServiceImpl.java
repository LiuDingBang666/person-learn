package icu.liuwisdom.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import icu.liuwisdom.business.entity.HomeSearch;
import icu.liuwisdom.business.mapper.HomeSearchMapper;
import icu.liuwisdom.business.query.HomeSearchQuery;
import icu.liuwisdom.business.service.HomeSearchService;
import lombok.val;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 日志留言回复表 服务实现类
 * </p>
 *
 * @author ldb
 * @since 2022-12-12
 */
@Service
public class HomeSearchServiceImpl extends ServiceImpl<HomeSearchMapper, HomeSearch> implements HomeSearchService {
    @Resource
    HomeSearchMapper mapper;

    @Override
    public PageInfo<HomeSearch> page(HomeSearchQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        val list = mapper.page(query);
        return PageInfo.of(list);
    }
}
