package icu.liuwisdom.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 应用程序 工作 -》 触发器 -》 调度器
 *
 * @author ldb
 * @ClassName QuartzApplccation.java
 * @Data 2022-03-01 9:39
 */
@SpringBootApplication(scanBasePackages = {"icu.liuwisdom"})
public class TaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }
}
