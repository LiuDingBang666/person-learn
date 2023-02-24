package icu.liuwisdom.task.config;

import icu.liuwisdom.task.job.DateTimeJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Quartz配置类
 *
 * @author ldb
 * @ClassName QuartzConfig.java
 * @Data 2022-03-01 10:34
 */
@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail printTimeJobDetail() {
        // 绑定一个任务
        return JobBuilder.newJob(DateTimeJob.class)
                // 给任务起一个名称
                .withIdentity("DateTimeJob")
                // 设置任务中自带的数据
                .usingJobData("msg", "Hello Quartz")
                // 没有触发器该任务也存在
                .storeDurably().build();
    }

    @Bean
    public Trigger printTimeJobTrigger() {
        // 定义一个定时任务表达式,设置触发规则
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/1 * * * * ?");
        return TriggerBuilder.newTrigger()
                // 触发器指定任务
                .forJob(printTimeJobDetail())
                // 给触发器指定一个名称
                .withIdentity("quartzTaskService")
                // 关联触发规则
                .withSchedule(cronScheduleBuilder).build();
    }
}
