package icu.liuwisdom.gencode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 代码生成模块
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-14 21:30
 */
@SpringBootApplication(scanBasePackages = {"icu.liuwisdom"})
public class ApplicationStart {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart.class, args);
    }
}
