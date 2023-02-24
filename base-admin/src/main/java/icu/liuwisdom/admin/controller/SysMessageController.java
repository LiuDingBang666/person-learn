package icu.liuwisdom.admin.controller;


import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.entity.SysMessage;
import icu.liuwisdom.admin.message.inteface.AbstractMessagesTemplate;
import icu.liuwisdom.admin.query.SysMessageQuery;
import icu.liuwisdom.admin.service.SysMessageService;
import icu.liuwisdom.core.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.val;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("/sysMessage")
public class SysMessageController {
    @Resource
    SysMessageService sysMessageService;

    @Resource
    AbstractMessagesTemplate<SysMessage> sysMessageTemplate;


    @ApiOperation("新增")
    @PostMapping("/")
    public HttpResult<Boolean> add(@Validated @RequestBody SysMessage dto) {
        return HttpResult.ok(sysMessageService.save(dto));
    }

    @ApiOperation("发送消息测试")
    @PostMapping("/send")
    public HttpResult<AbstractMessagesTemplate> send() {
        // 消息发送类型枚举
        sysMessageTemplate.setMessage(new SysMessage("您有一条愿望被实现", "11233311", "1205asfdfs", "愿望实现"));
        sysMessageTemplate.sendMessage();
        return HttpResult.ok(sysMessageTemplate);
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

    @ApiOperation("修改")
    @PutMapping("/")
    public HttpResult<Boolean> update(@Validated @RequestBody SysMessage dto) {
        return HttpResult.ok(sysMessageService.updateById(dto));
    }

    @ApiOperation("分页")
    @PostMapping("/page")
    public HttpResult<PageInfo<SysMessage>> page(@RequestBody SysMessageQuery query) {
        val data = sysMessageService.pageData(query);
        return HttpResult.ok(data);
    }


    @ApiOperation("删除")
    @DeleteMapping("/{id}")
    public HttpResult<Boolean> delete(@PathVariable("id") String id) {
        val data = sysMessageService.removeById(id);
        return HttpResult.ok(data);
    }
}
