package icu.liuwisdom.business.h5.controller;


import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.entity.SysMessage;
import icu.liuwisdom.admin.query.SysMessageQuery;
import icu.liuwisdom.admin.service.SysMessageService;
import icu.liuwisdom.admin.utils.UserUtils;
import icu.liuwisdom.core.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.val;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 消息表 前端控制器
 * </p>
 *
 * @author ldb
 * @since 2022-12-05
 */
@Api(tags = "系统消息")
@RestController
@RequestMapping("/h5/sysMessage")
public class H5SysMessageController {
    @Resource
    SysMessageService sysMessageService;


    @ApiOperation("分页查询我的消息")
    @PostMapping("/page")
    public HttpResult<PageInfo<SysMessage>> page(@RequestBody SysMessageQuery query) {
        query.setFkUserId(UserUtils.getUser().getId());
        val data = sysMessageService.pageData(query);
        return HttpResult.ok(data);
    }


    @ApiOperation("已读")
    @PutMapping("/read/{id}")
    public HttpResult<Boolean> read(@PathVariable("id") String id) {
        val data = sysMessageService.read(id);
        return HttpResult.ok(data);
    }

    @ApiOperation("已处理")
    @PutMapping("/handed/{id}")
    public HttpResult<Boolean> handed(@PathVariable("id") String id) {
        val data = sysMessageService.handed(id);
        return HttpResult.ok(data);
    }

    @ApiOperation("查询")
    @GetMapping("/{id}")
    public HttpResult<SysMessage> get(@PathVariable("id") String id) {
        return HttpResult.ok(sysMessageService.getById(id));
    }

}
