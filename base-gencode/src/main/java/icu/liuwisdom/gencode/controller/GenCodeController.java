package icu.liuwisdom.gencode.controller;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import icu.liuwisdom.core.http.HttpResult;
import icu.liuwisdom.gencode.config.GenConfig;
import icu.liuwisdom.gencode.service.GenCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 代码生成控制层
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-18 14:42
 */
@Api(tags = "代码生成服务")
@RestController("/gen")
public class GenCodeController {
    @Resource
    GenCodeService service;

    @ApiOperation("生成代码")
    @PostMapping("/")
    public HttpResult<Boolean> genCode(@Validated @RequestBody GenConfig config) {
        return HttpResult.ok("代码生成成功", service.gen(config));
    }

    @ApiOperation("测试连接数据库")
    @PostMapping("/connection")
    public HttpResult<Boolean> connection(@RequestBody GenConfig config) {
        return HttpResult.ok("测试连接数据库成功", service.connection(config));
    }

    @ApiOperation("获取数据源所有表信息")
    @PostMapping("/tables")
    public HttpResult<List<TableInfo>> tables(@RequestBody GenConfig config) {
        return HttpResult.ok("获取数据源所有表信息成功", service.tables(config));
    }
}
