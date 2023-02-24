package icu.liuwisdom.admin.config;

import icu.liuwisdom.utils.FileUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * 跨域配置
 *
 * @author ldb
 * @ClassName WebMvcConfigurer.java
 * @Data 2022-02-19 11:18
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 跨域规则
     *
     * @param registry
     * @author Ldb
     * @date 2022-02-19
     **/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 所有请求
        registry.addMapping("/**")
                // 所有源
                .allowedOrigins("*")
                // 所有方法
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                // 预检最大时间
                .maxAge(168000)
                // 可允许带的请求头参数
                .allowedHeaders("*")
                // 是否允许携带Cookie
                .allowCredentials(true);
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 代理外部资源
        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + FileUtils.getUploadPath());
        registry.addResourceHandler("/template/**").addResourceLocations("file:" + FileUtils.getTemplatePath());
        registry.addResourceHandler("/temp/**").addResourceLocations("file:" + FileUtils.getTempPath());
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
