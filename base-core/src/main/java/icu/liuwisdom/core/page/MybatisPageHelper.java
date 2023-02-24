package icu.liuwisdom.core.page;

import cn.hutool.core.util.ReflectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

/**
 * 分页查询助手
 *
 * @author ldb
 * @ClassName MybatisPageHelper.java
 * @Data 2022-02-19 15:14
 */
@Data
@Deprecated
public class MybatisPageHelper {
    /**
     * 分页查询名,反射调用此方法
     */
    public static final String PAGE = "findPage";

    /**
     * 分页查询：约定分页查询方法名为findPage
     *
     * @param pageRequest
     * @param mapper
     * @return icu.liuwisdom.core.page.PageResult
     * @author Ldb
     * @date 2022-02-19
     **/
    public static PageResult findPage(PageRequest pageRequest, Object mapper) {
        return findPage(pageRequest, mapper, PAGE);
    }

    /**
     * 分页查询方法
     *
     * @param pageRequest
     * @param mapper
     * @param queryMethodName
     * @param args
     * @return icu.liuwisdom.core.page.PageResult
     * @author Ldb
     * @date 2022-02-19
     **/
    public static PageResult findPage(PageRequest pageRequest, Object mapper, String queryMethodName, Object... args) {
        // 设置分页查询
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        // 反射调用方法
        Object result = ReflectUtil.invoke(mapper, queryMethodName, args);
        return getPageResult(pageRequest, new PageInfo((List) result));
    }

    /**
     * 将分页信息封装到统一接口
     *
     * @param pageRequest
     * @param pageInfo
     * @return icu.liuwisdom.core.page.PageResult
     * @author Ldb
     * @date 2022-02-19
     **/
    private static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
