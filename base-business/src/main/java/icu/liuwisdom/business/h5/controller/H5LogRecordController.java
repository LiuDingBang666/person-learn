package icu.liuwisdom.business.h5.controller;


import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.utils.UserUtils;
import icu.liuwisdom.business.entity.LogRecord;
import icu.liuwisdom.business.query.LogRecordQuery;
import icu.liuwisdom.business.service.LogRecordService;
import icu.liuwisdom.business.vo.LogRecordVo;
import icu.liuwisdom.core.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * <p>
 * 日志记录表 前端控制器
 * </p>
 *
 * @author ldb
 * @since 2022-12-12
 */
@Api(tags = "日志记录")
@RestController
@RequestMapping("/h5/logRecord")
public class H5LogRecordController {

    @Resource
    LogRecordService service;


    @ApiOperation("新增")
    @PostMapping(value = "/")
    public HttpResult<Boolean> add(@RequestBody @Validated LogRecord record) {
        record.setFkUserId(UserUtils.getUser().getId());
        return HttpResult.ok("新增成功", service.save(record));
    }

    @ApiOperation("修改")
    @PutMapping(value = "/")
    public HttpResult<Boolean> update(@RequestBody @Validated LogRecord record) {
        record.setFkUserId(UserUtils.getUser().getId());
        return HttpResult.ok("修改成功", service.updateById(record));
    }

    @ApiOperation("删除")
    @DeleteMapping(value = "/{id}")
    public HttpResult<Boolean> delete(@PathVariable("id") String records) {
        return HttpResult.ok("删除成功", service.removeById(records));
    }

    @ApiOperation("根据id查询")
    @GetMapping(value = "/{id}")
    public HttpResult<LogRecordVo> get(@PathVariable("id") String id) {
        return HttpResult.ok("根据id查询成功", service.getById(id));
    }


    @ApiOperation("分页查询我的日志")
    @PostMapping(value = "/page")
    public HttpResult<PageInfo<LogRecord>> page(@RequestBody LogRecordQuery query) {
        query.setFkUserId(UserUtils.getUser().getId());
        return HttpResult.ok("分页查询我的日志成功", service.page(query));
    }

    @ApiOperation("分页查询公开日志")
    @PostMapping(value = "/page/public")
    public HttpResult<PageInfo<LogRecord>> pagePublic(@RequestBody LogRecordQuery query) {
        query.setIsPublic(1);
        return HttpResult.ok("分页查询公开日志成功", service.page(query));
    }

}
