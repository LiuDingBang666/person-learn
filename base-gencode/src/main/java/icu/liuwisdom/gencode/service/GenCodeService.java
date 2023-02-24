package icu.liuwisdom.gencode.service;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import icu.liuwisdom.gencode.config.GenConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * 代码生成
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-18 14:43
 */

public interface GenCodeService {
    /**
     * 生成代码
     *
     * @author LDB
     * @date 2023-01-18 14:57
     * @version 1.0
     */
    Boolean gen(GenConfig config);

    /**
     * 测试连接
     *
     * @param config 配置信息
     * @return java.lang.Boolean
     * @author LDB
     * @date 2023-01-26
     **/
    Boolean connection(GenConfig config);

    /**
     * 获取数据源所有表信息
     *
     * @param config 配置信息
     * @return java.util.ArrayList<com.baomidou.mybatisplus.generator.config.po.TableInfo>
     * @author LDB
     * @date 2023-01-26
     **/
    List<TableInfo> tables(GenConfig config);
}
