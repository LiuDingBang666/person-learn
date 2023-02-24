package icu.liuwisdom.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程执行工具类
 * 1、线程池配置随时可控制
 * 2、提高执行速度
 *
 * @author LDB
 * @version 1.0
 * @date 2023-02-06 9:49
 */
public class ExecutorUtil {

    public static void test() {
        final long start = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 9000000; i++) {
            list.add(i);
        }
        final long end = System.currentTimeMillis();
        System.out.println(list.size());
        System.out.println((end - start) / 1000 + " s");
    }

    public static void run(Runnable task) {
        final ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 1000, 2000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1000), Executors.defaultThreadFactory());
        poolExecutor.execute(task);
        poolExecutor.shutdown();
    }


    public static void main(String[] args) {
//        ExecutorUtil.test();
        ExecutorUtil.run(ExecutorUtil::test);
    }
}
