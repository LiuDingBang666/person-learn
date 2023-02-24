package icu.liuwisdom.business.h5.controller;


import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.query.SysNoticeQuery;
import icu.liuwisdom.admin.service.SysNoticeService;
import icu.liuwisdom.admin.vo.SysNoticeVo;
import icu.liuwisdom.core.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.val;
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
@RequestMapping("/h5/sysNotice")
public class H5SysNoticeController {
    @Resource
    SysNoticeService sysNoticeService;

    @ApiOperation("分页")
    @PostMapping("/page")
    public HttpResult<PageInfo<SysNoticeVo>> page(@RequestBody SysNoticeQuery query) {
        val data = sysNoticeService.page(query);
        return HttpResult.ok(data);
    }

    @ApiOperation("查询")
    @GetMapping("/{id}")
    public HttpResult<SysNoticeVo> get(@PathVariable("id") String id) {
        return HttpResult.ok(sysNoticeService.getById(id, true));
    }

}
