package icu.liuwisdom.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import icu.liuwisdom.business.entity.HomeSearch;
import icu.liuwisdom.business.query.HomeSearchQuery;

/**
 * <p>
 * 首页搜索 服务类
 * </p>
 *
 * @author ldb
 * @since 2022-12-12
 */
public interface HomeSearchService extends IService<HomeSearch> {

    /**
     * 分页查询搜索信息
     *
     * @param query
     * @return com.github.pagehelper.PageInfo<icu.liuwisdom.business.entity.HomeSearch>
     * @author LDB
     * @date 2022-12-13
     **/
    PageInfo<HomeSearch> page(HomeSearchQuery query);
}
