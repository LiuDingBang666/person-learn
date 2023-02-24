package icu.liuwisdom.start.config;

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
public class SwaggerConfig {

    @Resource
    SwaggerUtils swaggerUtils;

    @Bean
    public Docket createBaseRestApi(Environment environment) {
        //设置要显示的swagger环境
        boolean flag = environment.acceptsProfiles(Profiles.of("default", "dev", "pro"));
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("基础框架")
                .apiInfo(swaggerUtils.apiInfo())
                .enable(flag)
                .select().apis(RequestHandlerSelectors.basePackage("icu.liuwisdom.admin.controller"))
                //新增请求参数
                .build().globalOperationParameters(swaggerUtils.addRequestHeaderParameters("token", "令牌"));
    }

    @Bean
    public Docket createH4RestApi(Environment environment) {
        //设置要显示的swagger环境
        boolean flag = environment.acceptsProfiles(Profiles.of("default", "dev", "pro"));
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("移动端接口")
                .apiInfo(swaggerUtils.apiInfo())
                .enable(flag)
                .select().apis(RequestHandlerSelectors.basePackage("icu.liuwisdom.business.h5.controller"))
                //新增请求参数
                .build().globalOperationParameters(swaggerUtils.addRequestHeaderParameters("token", "令牌"));
    }


    @Bean
    public Docket createBackupRestApi(Environment environment) {
        //设置要显示的swagger环境
        boolean flag = environment.acceptsProfiles(Profiles.of("default", "dev", "pro"));
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("数据库备份接口")
                .apiInfo(swaggerUtils.apiInfo())
                .enable(flag)
                .select().apis(RequestHandlerSelectors.basePackage("icu.liuwisdom.backup"))
                .build();
    }


    @Bean
    public Docket createBusinessRestApi(Environment environment) {
        //设置要显示的swagger环境
        boolean flag = environment.acceptsProfiles(Profiles.of("default", "dev", "pro"));
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("业务接口")
                .apiInfo(swaggerUtils.apiInfo())
                .enable(flag)
                .select().apis(RequestHandlerSelectors.basePackage("icu.liuwisdom.business"))
                .build();
    }

    @Bean
    public Docket createRestOriginApi(Environment environment) {
        //设置要显示的swagger环境
        boolean flag = environment.acceptsProfiles(Profiles.of("default", "dev", "pro"));
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("外部请求接口")
                .apiInfo(swaggerUtils.apiInfo())
                .enable(flag)
                .select().apis(RequestHandlerSelectors.basePackage("icu.liuwisdom.request"))
                .build();
    }


    @Bean
    public Docket createEmailApi(Environment environment) {
        //设置要显示的swagger环境
        boolean flag = environment.acceptsProfiles(Profiles.of("default", "dev", "pro"));
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("邮箱接口")
                .apiInfo(swaggerUtils.apiInfo())
                .enable(flag)
                .select().apis(RequestHandlerSelectors.basePackage("icu.liuwisdom.email"))
                .build();
    }
}
