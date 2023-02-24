package icu.liuwisdom.admin.config;

import icu.liuwisdom.admin.security.JwtAuthenticationFilter;
import icu.liuwisdom.admin.security.JwtAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

import javax.annotation.Resource;

/**
 * Spring Security安全配置
 *
 * @author ldb
 * @date
 */
@Configuration
// 开启Spring Security
@EnableWebSecurity
/**
 * 开启权限注解，如：@PreAuthorize注解
 * @author LDB
 * @date 2022-07-23 22:29
 * @version 1.0
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 用户认证信息
     */
    @Resource
    private UserDetailsService userDetailsService;

    /**
     * 用户认证管理配置
     *
     * @param auth 认证管理
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 使用自定义身份验证
        auth.authenticationProvider(new JwtAuthenticationProvider(userDetailsService));
    }

    /**
     * 自定义登录相关配置
     *
     * @param http http安全
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 禁用 csrf, 由于使用的是JWT，我们这里不需要csrf
        http.cors().and().csrf().disable()
                .authorizeRequests()
                // 跨域预检请求
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                // 放行前端资源
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/excel/**").permitAll()
                // 放行德鲁伊SQL监控（druid）
                .antMatchers("/druid/**").permitAll()
                .antMatchers("/menu/**").permitAll()
                // 放行首页和登录以及注册页面
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/phone/login").permitAll()
                .antMatchers("/getValidCode").permitAll()
                // 放行备份接口
                .antMatchers("/backup/**").permitAll()
                // 放行文件上传下载接口
                .antMatchers("/upload/**").permitAll().antMatchers("/file/**").permitAll()
                // 放行请求接口
                .antMatchers("/request/**").permitAll()
                // 放行swagger资源
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/doc.html").permitAll()
                .antMatchers("/swagger-resources/**")
                .permitAll().antMatchers("/v2/api-docs")
                .permitAll().antMatchers("/webjars/springfox-swagger-ui/**").permitAll()
                // 放行验证码
                .antMatchers("/captcha.jpg**").permitAll()
                // 放行服务监控
                .antMatchers("/actuator/**").permitAll()
                // 其他所有请求需要身份认证
                .anyRequest().authenticated();
        // 退出登录处理器
        http.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());
        // 设置token验证拦截器，传入认证信息和用户密码认证过滤器
        http.addFilterBefore(new JwtAuthenticationFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

}