package icu.liuwisdom.backup.po;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 数据源po
 *
 * @author ldb
 * @ClassName BackupDataSourceProperties.java
 * @Data 2022-02-22 10:14
 */
@Component
@ConfigurationProperties(prefix = "admin.backup.datasource")
@Data
public class BackupDataSourceProperties {
    private String host;

    private String userName;

    private String password;

    private String database;
}
