package icu.liuwisdom.core.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import icu.liuwisdom.core.modal.BaseModel;
import icu.liuwisdom.core.page.PageRequest;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 基础Mapper
 *
 * @author LDB
 * @version 1.0
 * @date 2022-07-24 8:49
 */
@SuppressWarnings("all")
public interface BaseMapper<T extends BaseModel, Q extends PageRequest, V extends BaseModel> extends com.baomidou.mybatisplus.core.mapper.BaseMapper<T> {
    /**
     * 带条件查询id列表(默认返回所有id)
     *
     * @param wrapper 查询包装实体
     * @return java.util.List<E>
     * @author LDB
     * @date 2022-07-24
     **/
    default List<String> selectIds(@Param("query") Q query) {
        return this.selectList(null)
                .stream()
                .map(val -> val.getId())
                .collect(Collectors.toList());
    }

    /**
     * 带条件一对多分页查询(默认返回所有列表)
     *
     * @param wrapper 查询包装实体
     * @param ids     传入的id列表
     * @return java.util.List<T>
     * @author LDB
     * @date 2022-07-24
     **/
    default List<V> basePage(@Param("query") Q query, @Param("ids") List<String> ids) {
        return new ArrayList<V>();
    }

    /**
     * 带条件单表分页查询
     *
     * @param wrapper 查询包装类
     * @return java.util.List<T>
     * @author LDB
     * @date 2022-07-24
     **/
    default List<T> basePage(Wrapper<T> wrapper) {
        return this.selectList(wrapper);
    }
}
