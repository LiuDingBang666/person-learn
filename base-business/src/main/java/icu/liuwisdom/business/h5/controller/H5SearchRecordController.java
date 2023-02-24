package icu.liuwisdom.business.h5.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.entity.SearchRecord;
import icu.liuwisdom.admin.service.SearchRecordService;
import icu.liuwisdom.admin.utils.UserUtils;
import icu.liuwisdom.business.entity.HomeSearch;
import icu.liuwisdom.business.query.HomeSearchQuery;
import icu.liuwisdom.business.service.HomeSearchService;
import icu.liuwisdom.core.http.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 搜索记录表 前端控制器
 * </p>
 *
 * @author ldb
 * @since 2022-12-11
 */
@Api(tags = "搜索记录表")
@RestController
@RequestMapping("/h5/searchRecord")
public class H5SearchRecordController {
    @Resource
    SearchRecordService searchRecordService;

    @Resource
    HomeSearchService searchService;

    @ApiOperation("新增")
    @PostMapping(value = "/")
    public HttpResult<Boolean> add(@RequestBody SearchRecord record) {
        record.setFkUserId(UserUtils.getUser().getId());
        return HttpResult.ok("新增成功", searchRecordService.save(record));
    }

    @ApiOperation("删除")
    @DeleteMapping(value = "/{id}")
    public HttpResult<Boolean> delete(@PathVariable("id") String id) {
        return HttpResult.ok("删除成功", searchRecordService.removeById(id));
    }

    @ApiOperation("分页查询搜索信息")
    @PostMapping(value = "/page")
    public HttpResult<PageInfo<HomeSearch>> page(@RequestBody HomeSearchQuery
                                                         query) {
        return HttpResult.ok("分页查询搜索信息成功", searchService.page(query));
    }

    @ApiOperation("清空")
    @GetMapping("/clean")
    public HttpResult<Boolean> clean() {
        return HttpResult.ok(searchRecordService.clean(UserUtils.getUser().getId()));
    }

    @PostMapping(value = "/all")
    @ApiOperation("查询所有历史记录")
    public HttpResult<List<SearchRecord>> findPage() {
        return HttpResult.ok("分页成功", searchRecordService.list(
                new LambdaQueryWrapper<SearchRecord>()
                        .eq(SearchRecord::getFkUserId, UserUtils.getUser().getId())));
    }
}
