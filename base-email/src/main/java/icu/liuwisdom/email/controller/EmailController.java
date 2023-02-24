package icu.liuwisdom.email.controller;


import icu.liuwisdom.core.http.HttpResult;
import icu.liuwisdom.email.dto.EmailDto;
import icu.liuwisdom.email.service.impl.EmailServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * <p>
 * 邮箱服务
 * </p>
 *
 * @author ldb
 * @since 2022-12-12
 */
@Api(tags = "邮箱服务")
@RestController
@RequestMapping("/h5/email")
public class EmailController {
    @Resource
    EmailServiceImpl service;

    @ApiOperation("发送简单邮箱")
    @PostMapping(value = "/simple/")
    public HttpResult simple(@RequestBody @Validated EmailDto dto) {
        service.sendSimpleEmail(dto);
        return HttpResult.ok("发送简单邮箱成功");
    }

    @ApiOperation("发送普通邮箱")
    @PostMapping(value = "/mime/")
    public HttpResult file(@RequestBody @Validated EmailDto dto) {
        service.sendMimeEmail(dto);
        return HttpResult.ok("发送普通邮箱成功");
    }


}
