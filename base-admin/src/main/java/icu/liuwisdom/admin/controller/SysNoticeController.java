package icu.liuwisdom.admin.controller;


import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.dto.SysNoticeDto;
import icu.liuwisdom.admin.entity.SysNotice;
import icu.liuwisdom.admin.query.SysNoticeQuery;
import icu.liuwisdom.admin.service.SysNoticeService;
import icu.liuwisdom.admin.vo.SysNoticeVo;
import icu.liuwisdom.core.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.val;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 通知表 前端控制器
 * </p>
 *
 * @author ldb
 * @since 2022-12-05
 */
@Api(tags = "系统通知")
@RestController
@RequestMapping("/sysNotice")
public class SysNoticeController {
    @Resource
    SysNoticeService sysNoticeService;


    @ApiOperation("新增")
    @PostMapping("/")
    public HttpResult<SysNotice> add(@Validated @RequestBody SysNoticeDto sysNotice) {
        sysNotice.setReadNum(0);
        val data = sysNoticeService.save(sysNotice);
        return HttpResult.ok(sysNotice);
    }

    @ApiOperation("发布")
    @PutMapping("/publish/{id}")
    public HttpResult<Boolean> publish(@PathVariable("id") String id) {
        val data = sysNoticeService.publish(id);
        return HttpResult.ok(data);
    }

    @ApiOperation("禁用")
    @PutMapping("/disable/{id}")
    public HttpResult<Boolean> disabled(@PathVariable("id") String id) {
        val data = sysNoticeService.disabled(id);
        return HttpResult.ok(data);
    }

    @ApiOperation("修改")
    @PutMapping("/")
    public HttpResult<SysNotice> update(@Validated @RequestBody SysNoticeDto sysNotice) {
        val data = sysNoticeService.updateById(sysNotice);
        return HttpResult.ok(sysNotice);
    }

    @ApiOperation("分页")
    @PostMapping("/page")
    public HttpResult<PageInfo<SysNoticeVo>> page(@RequestBody SysNoticeQuery query) {
        val data = sysNoticeService.multiListPage(query);
        return HttpResult.ok(data);
    }

    @ApiOperation("查询")
    @GetMapping("/{id}")
    public HttpResult<SysNoticeVo> get(@PathVariable("id") String id) {
        return HttpResult.ok(sysNoticeService.getById(id, false));
    }

    @ApiOperation("删除")
    @DeleteMapping("/{id}")
    public HttpResult<Boolean> delete(@PathVariable("id") String id) {
        val data = sysNoticeService.removeById(id);
        return HttpResult.ok(data);
    }
}
