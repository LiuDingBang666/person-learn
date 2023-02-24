package icu.liuwisdom.core.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import icu.liuwisdom.core.exception.BusinessException;
import icu.liuwisdom.core.modal.BaseModel;

import java.util.List;
import java.util.Objects;

/**
 * 基础服务类接口
 *
 * @author LDB
 * @version 1.0
 * @date 2022-07-23 20:37
 */
@SuppressWarnings("all")
public interface BaseService<T, Q, V extends BaseModel> extends IService<T> {

    /**
     * 获取包装类
     *
     * @param q
     * @return com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper<T>
     * @author LDB
     * @date 2023-01-19
     **/
    public LambdaQueryWrapper<T> wrapper(Q q);

    /**
     * 简单list查询 - 直接依赖wrapper
     *
     * @return java.util.List<T>
     * @author LDB
     * @date 2023-01-19
     **/
    public default List<T> list(Q query) {
        return list(new LambdaQueryWrapper<T>());
    }


    @Override
    default boolean updateById(T entity) {
        this.checkPo(entity);
        return IService.super.updateById(entity);
    }

    @Override
    default boolean save(T entity) {
        this.checkPo(entity);
        return IService.super.save(entity);
    }

    /**
     * 更新前检查
     *
     * @param d
     * @author LDB
     * @date 2022-12-06
     **/
    default <C extends T> void checkPo(C data) {
        if (Objects.isNull(data)) {
            throw new BusinessException("实体类不存在");
        }
    }

    /**
     * 多表关联分页方法(一对多)
     *
     * @param query 查询类
     * @return com.github.pagehelper.PageInfo<T>
     * @author LDB
     * @date 2022-07-23
     **/
    PageInfo<V> multiListPage(Q query);

    /**
     * 单表分页(一对一)
     *
     * @param query   查询类
     * @param wrapper 查询条件类
     * @return com.github.pagehelper.PageInfo<T>
     * @author LDB
     * @date 2022-07-24
     **/
    PageInfo<T> listPage(Q query);

}
