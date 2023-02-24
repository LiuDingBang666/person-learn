package icu.liuwisdom.utils;

import org.springframework.stereotype.Component;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ldb
 * @ClassName SwaggerUtils.java
 * @Data 2022-05-18 17:13
 */
@Component
public class SwaggerUtils {

    /**
     * 配置swagger基本信息
     *
     * @param
     * @return springfox.documentation.service.ApiInfo
     * @author Ldb
     * @date 2022-02-18
     **/
    public  ApiInfo apiInfo() {
        Contact contact = new Contact("刘定邦", "icu.liuwisdom", "2993442750@qq.com");
        return new ApiInfo(
                "权限管理系统-API",
                "基础框架",
                "1.0",
                "icu.liuwisdom",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

    /**
     * 新增请求头参数
     *
     * @param name        名称
     * @param description 参数
     * @return java.util.List<springfox.documentation.service.Parameter>
     * @author Ldb
     * @date 2022-05-18
     **/
    public List<Parameter> addRequestHeaderParameters(String name, String description) {
        // 添加请求参数，我们这里把token作为请求头部参数传入后端
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        List<Parameter> parameters = new ArrayList<Parameter>();
        parameterBuilder.name(name)
                .description(description)
                .modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        parameters.add(parameterBuilder.build());
        return parameters;
    }
}
