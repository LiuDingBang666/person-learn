package icu.liuwisdom.test.service;

import org.springframework.stereotype.Service;

/**
 * @author LDB
 * @version 1.0
 * @date 2023-02-19 23:06
 */
public class TestService implements icu.liuwisdom.test.service.Service {

    @Override
    public void run() {
        System.out.println("工人开始干活了...");
    }
}
