package icu.liuwisdom.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import icu.liuwisdom.core.mapper.BaseMapper;
import icu.liuwisdom.core.modal.BaseModel;
import icu.liuwisdom.core.page.PageRequest;
import icu.liuwisdom.core.service.BaseService;
import lombok.val;

import java.util.List;

/**
 * 基础服务类
 *
 * @author LDB
 * @version 1.0
 * @date 2022-07-23 20:55
 */
public abstract class BaseServiceImpl<M extends BaseMapper<T, Q, V>, T extends BaseModel, Q extends PageRequest, V extends BaseModel> extends ServiceImpl<M, T> implements BaseService<T, Q, V> {
    /**
     * 单独抽出来的wrapper，供全局使用
     *
     * @author LDB
     * @date 2023-01-19 19:13
     * @version 1.0
     */

    LambdaQueryWrapper<T> wrapper = new LambdaQueryWrapper<T>();

    /**
     * 包装wrapper
     *
     * @param query
     * @return com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper<T>
     * @author LDB
     * @date 2023-01-19
     **/
    @Override
    public LambdaQueryWrapper<T> wrapper(Q query) {
        return this.wrapper;
    }

    /**
     * 查列表
     *
     * @param query
     * @return java.util.List<T>
     * @author LDB
     * @date 2023-01-19
     **/
    @Override
    public List<T> list(Q query) {
        return this.list(wrapper);
    }


    /**
     * 多表关联分页查询
     *
     * @param query 查询类
     * @return com.github.pagehelper.PageInfo<E>
     * @author LDB
     * @date 2022-07-23
     **/
    @Override
    public PageInfo<V> multiListPage(Q query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        val ids = baseMapper.selectIds(query);
//        PageInfo<V> pageInfo = new PageInfo<>();
//        BeanUtils.copyProperties(page, pageInfo);
        return PageInfo.of(baseMapper.basePage(query, ids));
    }


    /**
     * 单表分页(一对一)
     *
     * @param query 查询类
     * @return com.github.pagehelper.PageInfo<T>
     * @author LDB
     * @date 2022-07-24
     **/
    @Override
    public PageInfo<T> listPage(Q query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        return PageInfo.of(baseMapper.basePage(wrapper));
    }
}
