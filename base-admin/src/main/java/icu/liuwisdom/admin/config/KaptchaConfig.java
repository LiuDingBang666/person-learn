package icu.liuwisdom.admin.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.security.krb5.KrbException;

import java.util.Properties;

/**
 * 验证码配置
 *
 * @author ldb
 * @ClassName KaptchaConfig.java
 * @Data 2022-02-21 15:15
 */
@Configuration
public class KaptchaConfig {
    @Bean
    public DefaultKaptcha producer() throws KrbException {
        Properties properties = new Properties();
        properties.put("kaptcha.border", "no");
        properties.put("kaptcha.textproducer.font.color", "black");
        properties.put("kaptcha.textproducer.char.space", "5");
        Config config = new Config(properties);
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
