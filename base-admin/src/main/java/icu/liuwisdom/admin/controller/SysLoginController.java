package icu.liuwisdom.admin.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import icu.liuwisdom.admin.annotation.Log;
import icu.liuwisdom.admin.dto.LoginBean;
import icu.liuwisdom.admin.entity.SysUser;
import icu.liuwisdom.admin.security.JwtAuthenticatioToken;
import icu.liuwisdom.admin.service.SysLoginLogService;
import icu.liuwisdom.admin.service.SysUserService;
import icu.liuwisdom.admin.utils.SecurityUtils;
import icu.liuwisdom.admin.vo.SysUserVo;
import icu.liuwisdom.core.http.HttpResult;
import icu.liuwisdom.utils.IOUtils;
import icu.liuwisdom.utils.PasswordUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 登录控制器
 *
 * @author ldb
 * @ClassName SysLoginController.java
 * @Data 2022-02-21 15:20
 */
@Api(tags = "登录控制器")
@RequestMapping("/")
@RestController
public class SysLoginController {
    @Resource
    private Producer producer;

    @Resource
    private SysUserService sysUserService;

    @Resource
    private SysLoginLogService sysLoginLogService;

    @Resource
    private AuthenticationManager authenticationManager;

    @ApiOperation(value = "获取图形验证码", produces = "image/jpeg")
    @GetMapping("/captcha.jpg")
    public void captcha(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        // 生成文字验证码
        String text = producer.createText();
        // 生成图片验证码
        BufferedImage image = producer.createImage(text);
        // 保存到验证码到 session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    /**
     * 登录接口
     */
    @ApiOperation("验证码登录")
    @Log(operation = "登录")
    @PostMapping(value = "/login")
    public HttpResult login(@RequestBody LoginBean loginBean, HttpServletRequest request) {
        String username = loginBean.getAccount();
        String password = loginBean.getPassword();
        String captcha = loginBean.getCaptcha();
        // 从session中获取之前保存的验证码跟前台传来的验证码进行匹配
        if (StringUtils.isNotEmpty(loginBean.getCaptcha())) {
            Object kaptcha = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
            if (kaptcha == null) {
                return HttpResult.error("验证码已失效");
            }
            if (!captcha.equals(kaptcha)) {
                return HttpResult.error("验证码不正确");
            }
        }
        // 用户信息
        SysUser user = sysUserService.findByName(username);
        // 账号不存在、密码错误
        if (null == user) {
            sysLoginLogService.add(loginBean, "账号不存在", request);
            return HttpResult.error("账号不存在");
        }
        if (!PasswordUtils.matches(user.getSalt(), password, user.getPassword())) {
            sysLoginLogService.add(loginBean, "密码不正确", request);
            return HttpResult.error("密码不正确");
        }
        // 账号锁定
        if (user.getStatus() == 0) {
            sysLoginLogService.add(loginBean, "账号已被锁定,请联系管理员", request);
            return HttpResult.error("账号已被锁定,请联系管理员");
        }
        // 系统登录认证
        JwtAuthenticatioToken token = SecurityUtils.login(request, username, password, authenticationManager);
        sysLoginLogService.add(loginBean, "登录成功", request);
        return HttpResult.ok("登录成功", token);
    }

    @ApiOperation("手机验证码登录(系统没有自动注册)")
    @Log(operation = "手机验证码登录")
    @PostMapping(value = "/phone/login")
    public HttpResult<JwtAuthenticatioToken> phoneCodeLogin(@RequestParam(value = "phone") String phone, @RequestParam(value = "code") String code, HttpServletRequest request) {
        JwtAuthenticatioToken data = sysUserService.phoneCodeLogin(phone, code, authenticationManager, request);
        return HttpResult.ok("登录成功", data);
    }

    @ApiOperation("获取手机验证码")
    @Log(operation = "获取手机验证码")
    @GetMapping(value = "/getValidCode")
    public HttpResult<Boolean> getValidCode(@RequestParam(value = "phone") String phone) {
        Boolean res = sysUserService.getValidCode(phone);
        return HttpResult.ok("获取验证码成功", res);
    }


    /**
     * 注册接口
     */
    @ApiOperation("注册")
    @Log(operation = "注册")
    @PostMapping(value = "/register")
    public HttpResult register(@RequestBody SysUserVo registerBean, HttpServletRequest request) throws IOException {
        String username = registerBean.getName();
        String password = registerBean.getPassword();
        String captcha = registerBean.getCaptcha();
        // 用户信息
        SysUser user = sysUserService.findByName(username);
        // 账号不存在、密码错误
        if (user != null) {
            return HttpResult.error("该用户名已存在，请更换");
        }
        // 新增用户信息
        SysUser save = sysUserService.save(registerBean);
        // 系统登录认证
        JwtAuthenticatioToken token = SecurityUtils.login(request, username, password, authenticationManager);
        return HttpResult.ok("注册成功", token);
    }
}
