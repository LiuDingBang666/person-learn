package icu.liuwisdom.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import icu.liuwisdom.business.entity.HomeSearch;
import icu.liuwisdom.business.query.HomeSearchQuery;

import java.util.List;

/**
 * <p>
 * 愿望实现表 Mapper 接口
 * </p>
 *
 * @author ldb
 * @since 2022-12-12
 */
public interface HomeSearchMapper extends BaseMapper<HomeSearch> {
    /**
     * 分页查询信息
     *
     * @param query
     * @return java.util.List<icu.liuwisdom.business.entity.HomeSearch>
     * @author LDB
     * @date 2022-12-13
     **/
    List<HomeSearch> page(HomeSearchQuery query);
}
