package icu.liuwisdom.message.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringApplicationStart
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-08 11:40
 */
@SpringBootApplication(scanBasePackages = {"icu.liuwisdom"})
public class SpringApplicationStart {
    public static void main(String[] args) {
        SpringApplication.run(SpringApplicationStart.class, args);
    }
}
