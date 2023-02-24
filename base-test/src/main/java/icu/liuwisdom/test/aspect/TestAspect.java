package icu.liuwisdom.test.aspect;

import org.springframework.stereotype.Service;

/**
 * @author LDB
 * @version 1.0
 * @date 2023-02-19 23:07
 */

public class TestAspect {
    public void start() {
        System.out.println("代理开始....");
    }

    public void stop() {
        System.out.println("代理结束....");
    }
}
