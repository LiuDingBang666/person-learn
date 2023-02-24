package icu.liuwisdom.gencode.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import icu.liuwisdom.utils.SwaggerUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;

/**
 * swagger配置
 *
 * @author ldb
 * @ClassName SwaggerConfig.java
 * @Data 2022-02-18 11:18
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
public class GenSwaggerConfig {
    @Resource
    SwaggerUtils swaggerUtils;

    @Bean
    public Docket createGenRestApi(Environment environment) {
        //设置要显示的swagger环境
        boolean flag = environment.acceptsProfiles(Profiles.of("default", "dev", "pro"));
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("代码生成接口")
                .apiInfo(swaggerUtils.apiInfo())
                .enable(flag)
                .select().apis(RequestHandlerSelectors.basePackage("icu.liuwisdom.gencode"))
                .build();
    }
}
