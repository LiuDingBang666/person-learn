package icu.liuwisdom.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 系统生产环境配置
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-01 19:43
 */
@Component
@Data
@ConfigurationProperties(value = "product")
public class SystemProductConfig {
    /**
     * 系统上传文件路径
     *
     * @author LDB
     * @date 2023-01-01 19:45
     * @version 1.0
     */
    private String uploadPath;

    /**
     * 模板文件路径
     *
     * @author LDB
     * @date 2023-01-18 22:30
     * @version 1.0
     */
    private String templatePath;

    /**
     * 临时文件文件路径
     *
     * @author LDB
     * @date 2023-01-18 22:30
     * @version 1.0
     */
    private String tempPath;
}
