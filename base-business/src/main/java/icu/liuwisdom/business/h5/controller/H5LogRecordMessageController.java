package icu.liuwisdom.business.h5.controller;


import icu.liuwisdom.business.entity.LogRecordMessage;
import icu.liuwisdom.business.service.LogRecordMessageService;
import icu.liuwisdom.core.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 日志留言回复表 前端控制器
 * </p>
 *
 * @author ldb
 * @since 2022-12-12
 */
@Api(tags = "日志留言回复表")
@RestController
@RequestMapping("/h5/logRecordMessage")
public class H5LogRecordMessageController {

    @Resource
    LogRecordMessageService service;

    @ApiOperation("新增")
    @PostMapping(value = "/")
    public HttpResult<Boolean> add(@RequestBody @Validated LogRecordMessage record) {
        return HttpResult.ok("新增成功", service.save(record));
    }

    @ApiOperation("删除")
    @DeleteMapping(value = "/{id}")
    public HttpResult<Boolean> delete(@PathVariable("id") String id) {
        return HttpResult.ok("删除成功", service.removeById(id));
    }
}
