package icu.liuwisdom.core.service;

import icu.liuwisdom.core.page.PageRequest;
import icu.liuwisdom.core.page.PageResult;

import java.util.List;

/**
 * 通用crud服务接口
 *
 * @author ldb
 * @ClassName service.java
 * @Data 2022-02-19 15:04
 */
@Deprecated
public interface CurdService<T> {
    /**
     * 新增
     *
     * @param data
     * @return T
     * @author Ldb
     * @date 2022-02-19
     **/
    T save(T data);

    /**
     * 删除
     *
     * @param data
     * @return int
     * @author Ldb
     * @date 2022-02-19
     **/
    int delete(T data);

    /**
     * 批量删除
     *
     * @param data
     * @return int
     * @author Ldb
     * @date 2022-02-19
     **/
    int delete(List<T> data);

    /**
     * 根据id查询
     *
     * @param id
     * @return T
     * @author Ldb
     * @date 2022-02-19
     **/
    T findById(String id);

    /**
     * 分页查询
     *
     * @param pageRequest
     * @return PageResult
     * @author Ldb
     * @date 2022-02-19
     **/
    PageResult findPage(PageRequest pageRequest);
}
