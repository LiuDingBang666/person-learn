package icu.liuwisdom.gencode.util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import icu.liuwisdom.gencode.config.AdviceVelocityTemplateEngine;
import icu.liuwisdom.gencode.config.GenConfig;
import icu.liuwisdom.gencode.constant.GenConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 代码生成工具
 * https://baomidou.com/pages/981406/#%E6%95%B0%E6%8D%AE%E5%BA%93%E9%85%8D%E7%BD%AE-datasourceconfig
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-18 14:35
 */
@Component
@Slf4j
public class GenUtil {
    private static GenUtil instance;

    /**
     * 模板前缀
     *
     * @author LDB
     * @date 2023-01-19 10:38
     * @version 1.0
     */
    private static final String TEMPLATE_PREFIX = "/customs/";

    @PostConstruct
    private void init() {
        instance = this;
    }

    /**
     * 生成代码
     * java: controller、xml、mapper、service、po
     * vue3
     *
     * @return java.lang.String
     * @author LDB
     * @date 2023-01-18
     **/
    public static void genCode(GenConfig config) {
        beforeGen(config);
        FastAutoGenerator.create(config.getUrl(), config.getUsername(), config.getPassword())
                // 全局配置
                .globalConfig(builder -> {
                    builder.author(config.getAuthor()) // 设置作者
                            .fileOverride() // 文件覆盖
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir(config.getOutputDir()); // 指定输出目录
                })
                // 包配置
                .packageConfig(builder -> {
                    builder.parent(config.getParent()) // 设置父包名
                            .moduleName(config.getModuleName())
                            .entity(GenConstant.ENTITY_NAME)
                            .pathInfo(getPathInfo(config)); // 设置mapperXml生成路径
                })
                // 策略配置
                .strategyConfig(builder -> {
                    // 设置需要生成的表名
                    builder.addInclude(config.getTables().split(","))
                            // 实体策略
                            .entityBuilder()
                            .enableLombok()
                            .entityBuilder()
                            .addIgnoreColumns("id", "create_by", "create_time", "last_update_by", "last_update_time", "remarks", "fk_create_user_id", "fk_update_user_id")
                            .serviceBuilder().formatServiceFileName("%sService");
                })
                // 模板配置
                .templateConfig(builder -> {
                    builder
                            .entity(GenUtil.TEMPLATE_PREFIX + GenConstant.ENTITY_FILE)
                            .service(GenUtil.TEMPLATE_PREFIX + GenConstant.SERVICE_FILE)
                            .serviceImpl(GenUtil.TEMPLATE_PREFIX + GenConstant.SERVICE_IMPL_FILE)
                            .mapper(GenUtil.TEMPLATE_PREFIX + GenConstant.MAPPER_FILE)
                            .mapperXml(GenUtil.TEMPLATE_PREFIX + GenConstant.XML_FILE)
                            .controller(GenUtil.TEMPLATE_PREFIX + GenConstant.CONTROLLER_FILE);
                })
                // 注入配置
                .injectionConfig(builder -> {
                    builder.customFile(getCustomFile())
                            .customMap(Collections.singletonMap("parentPackageName", config.getParent() + "." + config.getModuleName()));
                })
                .templateEngine(new AdviceVelocityTemplateEngine())
                .execute();
        afterGen(config);
    }

    /**
     * 生成代码之后的操作
     * 新增生成记录
     * 压缩生成文件
     * @param config
     * @author LDB
     * @date 2023-01-27
     **/
    private static void afterGen(GenConfig config) {

    }


    /**
     * 代码生成前做的操作
     *
     * @param config
     * @author LDB
     * @date 2023-01-19
     **/
    private static void beforeGen(GenConfig config) {
        if (StringUtils.isBlank(config.getOutputDir())) {
            // 生成的文件放入模板路径路径中
            config.setOutputDir(GenConstant.GEN_OUTPUT);
        }
    }

    /**
     * 获取定制文件信息
     *
     * @return java.util.HashMap<java.lang.String, java.lang.String>
     * @author LDB
     * @date 2023-01-19
     **/
    private static HashMap<String, String> getCustomFile() {
        HashMap<String, String> map = new HashMap<>(10);
        // todo Java模板
        map.put(GenConstant.QUERY, GenUtil.TEMPLATE_PREFIX + GenConstant.QUERY_TEMPLATE);
        map.put(GenConstant.VO, GenUtil.TEMPLATE_PREFIX + GenConstant.VO_TEMPLATE);
        map.put(GenConstant.DTO, GenUtil.TEMPLATE_PREFIX + GenConstant.DTO_TEMPLATE);
        // todo 前端模板
        return map;
    }

    /**
     * 获取路径生成Map
     *
     * @param config
     * @return java.util.HashMap<com.baomidou.mybatisplus.generator.config.OutputFile, java.lang.String>
     * @author LDB
     * @date 2023-01-19
     **/
    private static HashMap<OutputFile, String> getPathInfo(GenConfig config) {
        // 获取拼接后的路径信息
        StringBuilder builder = new StringBuilder(config.getOutputDir() + File.separator);
        getPackageList(config.getParent()).forEach(val -> {
            builder.append(val + File.separator);
        });
        builder.append(config.getModuleName());
        String parentPath = builder.toString();
        HashMap<OutputFile, String> map = new HashMap<>(10);
        map.put(OutputFile.other, parentPath);
        map.put(OutputFile.mapperXml, parentPath + File.separator + GenConstant.MAPPER);
        return map;
    }

    /**
     * 获取包名列表
     *
     * @param path
     * @return java.util.List<java.lang.String>
     * @author LDB
     * @date 2023-01-19
     **/
    public static List<String> getPackageList(String path) {
        List res = new ArrayList();
        StringBuffer builder = new StringBuffer();
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == 46) {
                res.add(builder.toString());
                builder = new StringBuffer();
            } else {
                builder.append(c);
            }
        }
        if (builder.length() > 0) {
            res.add(builder.toString());
        }
        return res;
    }

}
