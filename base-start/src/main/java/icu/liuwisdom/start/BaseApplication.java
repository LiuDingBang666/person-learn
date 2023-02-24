package icu.liuwisdom.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"icu.liuwisdom"})
@MapperScan(basePackages = {"icu.liuwisdom.admin.mapper",
        "icu.liuwisdom.business.mapper",
        "icu.liuwisdom.business.mall.mapper",
        "icu.liuwisdom.request.gaode.mapper"})
public class BaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }

}

