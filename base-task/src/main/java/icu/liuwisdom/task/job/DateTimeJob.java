package icu.liuwisdom.task.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;

/**
 * 日期工作任务
 *
 * @author ldb
 * @ClassName DateTimeJob.java
 * @Data 2022-03-01 10:27
 */
public class DateTimeJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // 获取jobDetail中关联的数据
        String msg = jobExecutionContext.getJobDetail().getJobDataMap().get("msg").toString();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(System.currentTimeMillis()));
        System.out.println(msg);
    }
}
