package icu.liuwisdom.task.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * spring boot定时服务
 * EnableScheduling 启动定时任务
 * Configuration 定时任务配置类
 * Scheduled 定义某个定时任务
 *
 * @author ldb
 * @ClassName ScheduledService.java
 * @Data 2022-03-01 9:46
 */
@Component
@Configuration
@EnableScheduling
public class ScheduledServiceConfig {
    @Scheduled(fixedRate = 1000 * 30)
    public void reportCurrentTime() {
        System.out.println("每半分钟" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(System.currentTimeMillis()));
    }

    /**
     * cron表达式 秒 分 小时 日期 星期 年份
     */
    @Scheduled(cron = "0 */1 *  *  *  *")
    public void reportCurrentTimeByOneMin() {
        System.out.println("每分钟:" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(System.currentTimeMillis()));
    }
}


/*
 *   cron表达式说明
 *  *  表示所有值。   在分的字段上设置 *,表示每一分钟都会触发。
 *  ?  表示不指定值。 使用的场景为不需要关心当前设置这个字段的值。
 *  -  表示区间。例如 在小时上设置 “10-12”
 *  , 表示指定多个值，例如在周字段上设置 “MON,WED,FRI”
 *  /  用于递增触发。如在秒上面设置”5/15” 表示从5秒开始，每增15秒触发(5,20,35,50)。 在月字段上设置’1/3’所示每月1号开始，每隔三天触发一次。
 *  L 表示最后的意思。在日字段设置上，表示当月的最后一天(依据当前月份，如果是二月还会依据是否是润年[leap]), 在周字段上表示星期六，相当于”7”或”SAT”。如果在”L”前加上数字，则表示该数据的最后一个。例如在周字段上设置”6L”这样的格式,则表示“本月最后一个星期五”
 *  W 表示离指定日期的最近那个工作日(周一至周五). 例如在日字段上置”15W”，表示离每月15号最近的那个工作日触发。如果15号正好是周六，则找最近的周五(14号)触发, 如果15号是周未，则找最近的下周一(16号)触发.如果15号正好在工作日(周一至周五)，则就在该天触发。如果指定格式为 “1W”,它则表示每月1号往后最近的工作日触发。如果1号正是周六，则将在3号下周一触发。(注，”W”前只能设置具体的数字,不允许区间”-“)。
 *  # 序号(表示每月的第几个周几)，例如在周字段上设置”6#3”表示在每月的第三个周六.注意如果指定”#5”,正好第五周没有周六，则不会触发该配置(用在母亲节和父亲节再合适不过了) ；小提示：’L’和 ‘W’可以一组合使用。如果在日字段上设置”LW”,则表示在本月的最后一个工作日触发；周字段的设置，若使用英文字母是不区分大小写的，即MON与mon相同。
 * */