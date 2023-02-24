package icu.liuwisdom.admin.controller;

import icu.liuwisdom.core.http.HttpResult;
import icu.liuwisdom.excel.ExcelUtils;
import icu.liuwisdom.excel.test.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author LDB
 * @version 1.0
 * @date 2023-02-16 9:37
 */
@RestController
@RequestMapping("/excel")
@Api(tags = "POI测试")
public class T {

    @ApiOperation("导出测试")
    @PostMapping("/export")
    public HttpResult export() {
        final Date date =new Date();
        date.setYear(1970);
        date.setMonth(1);
        date.setDate(1);
        date.setHours(17);
        date.setMinutes(41);
        date.setSeconds(26);
        final User user = User.builder()
                .name("刘定邦")
                .psw("刘定邦")
                .phone("18390864263")
                .birthday(new Date(2023, 01, 02))
                .age(21)
                .banlance(256.3)
                .year(2022)
                .gmtCreate(new Date()).
                isDeleted(true)
                .gmtTime(date)
                .build();
        final List<User> users = Collections.singletonList(user);
        final String path = ExcelUtils.getExportFile(users, "UserExport.xlsx");
        return HttpResult.ok(path);
    }

    @ApiOperation("导入测试")
    @PostMapping("/import")
    public HttpResult importExcel(@RequestParam("file") MultipartFile file) {
        final List<User> users = ExcelUtils.getImportData(file, User.class);
        // 3、消费数据
        return HttpResult.ok(users);
    }
}
