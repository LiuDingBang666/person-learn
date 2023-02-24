package icu.liuwisdom.gencode.config;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import icu.liuwisdom.gencode.util.GenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.util.Map;

/**
 * Velocity模板引擎增强类
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-19 8:53
 */
@Component
@Slf4j
public class AdviceVelocityTemplateEngine extends VelocityTemplateEngine {
    /**
     * 自定义模板文件生成
     *
     * @author LDB
     * @date 2023-01-19 9:10
     * @version 1.0
     */
    @Override
    protected void outputCustomFile(@NotNull Map<String, String> customFile, @NotNull TableInfo tableInfo, @NotNull Map<String, Object> objectMap) {
        log.info("开始生成自定义模板文件...");
        log.info("当前自定义文件..." + JSON.toJSONString(customFile));
        log.info("当前表..." + tableInfo.getName());
        log.info("当前配置..." + objectMap);
        String entityName = tableInfo.getEntityName();
        String otherPath = this.getPathInfo(OutputFile.other);
        customFile.forEach((key, value) -> {
            String fileName = String.format(otherPath + File.separator + GenUtil.getPackageList(key).get(0).toLowerCase() + File.separator + entityName + "%s" , key);
            this.outputFile(new File(fileName), objectMap, value);
        });
        log.info("生成自定义模板文件成功...");
    }
}
