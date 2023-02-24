package icu.liuwisdom.test;

import icu.liuwisdom.test.proxy.JdkProxy;
import icu.liuwisdom.test.service.Service;
import icu.liuwisdom.test.service.TestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LDB
 * @version 1.0
 * @date 2023-02-19 23:04
 */
@SpringBootApplication
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}

@RestController
@RequestMapping("/")
class test {

    @GetMapping("/jdk")
    public void testJdk() {
        JdkProxy jdkProxy = new JdkProxy();
        Service service= new TestService();
        Service o = (Service)jdkProxy.create(service);
        o.run();
    }
}
