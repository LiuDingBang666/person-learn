package icu.liuwisdom.admin.controller;


import com.github.pagehelper.PageInfo;
import icu.liuwisdom.admin.annotation.Log;
import icu.liuwisdom.admin.dto.FileDelete;
import icu.liuwisdom.admin.entity.SysFileUpload;
import icu.liuwisdom.admin.query.SysFileUploadQuery;
import icu.liuwisdom.admin.service.SysFileUploadService;
import icu.liuwisdom.core.http.HttpResult;
import icu.liuwisdom.utils.FileUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

/**
 * <p>
 * 系统文件上传表 前端控制器
 * </p>
 *
 * @author ldb
 * @since 2022-05-21
 */
@RestController
@RequestMapping("/file")
@Api(tags = "文件服务")
public class SysFileUploadController {
    @Resource
    SysFileUploadService sysFileUploadService;

    @ApiOperation("单文件上传")
    @Log(operation = "单文件上传")
    @PostMapping("/fileUpload")
    public HttpResult<SysFileUpload> fileUpload(MultipartFile file) {
        return HttpResult.ok("文件上传成功", sysFileUploadService.fileUpload(file));
    }

    @ApiOperation("多文件上传")
    @Log(operation = "多文件上传")
    @PostMapping("/multipartFileUpload")
    public HttpResult<List<SysFileUpload>> multipartFileUpload(List<MultipartFile> file) {
        return HttpResult.ok("文件上传成功", sysFileUploadService.multipartFileUpload(file));
    }

    @ApiOperation(value = "文件下载")
    @GetMapping("/download/{url}")
    public void fileDownload(
            @PathVariable("url") String url, HttpServletResponse response) {
        sysFileUploadService.fileDown(url, response);
    }

    @ApiOperation("文件删除(id)")
    @DeleteMapping("/delete/{id}")
    public HttpResult<Boolean> fileDelete(
            @PathVariable("id") String id) {
        sysFileUploadService.fileDelete(id);
        return HttpResult.ok("文件删除成功");
    }

    @ApiOperation("文件删除(url)")
    @PostMapping("/delete/url")
    public HttpResult<Boolean> fileDeleteByUrl(
            @RequestBody @Validated FileDelete dto) {
        FileUtils.deleteFile(new File(dto.getUrl()));
        return HttpResult.ok("文件删除成功");
    }

    @ApiOperation("根据id查询文件信息")
    @GetMapping("/{id}")
    public HttpResult<SysFileUpload> get(
            @PathVariable("id") String id) {
        SysFileUpload data = sysFileUploadService.getById(id);
        return HttpResult.ok("根据id查询文件信息成功", data);
    }

    @ApiOperation("根据id删除文件信息")
    @DeleteMapping("/{id}")
    public HttpResult<Boolean> delete(
            @PathVariable("id") String id) {
        return HttpResult.ok("根据id删除文件信息成功", sysFileUploadService.fileDelete(id));
    }

    @ApiOperation("分页查询文件信息")
    @PostMapping("/page")
    public HttpResult<PageInfo<SysFileUpload>> page(
            @RequestBody SysFileUploadQuery query) {
        return HttpResult.ok("分页查询文件信息成功", sysFileUploadService.pageData(query));
    }
}
