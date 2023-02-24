package icu.liuwisdom.request.gaode.controller;


import com.github.kevinsawicki.http.HttpRequest;
import icu.liuwisdom.core.http.HttpResult;
import icu.liuwisdom.request.gaode.common.GaoDeApi;
import icu.liuwisdom.request.gaode.query.DistrictQuery;
import icu.liuwisdom.request.gaode.service.DistrictService;
import icu.liuwisdom.request.gaode.vo.DistrictsVo;
import icu.liuwisdom.request.util.HttpRequestUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.val;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 省份区域信息表 前端控制器
 * </p>
 *
 * @author ldb
 * @since 2022-07-25
 */
@RestController
@Api(tags = "省份区域信息")
@RequestMapping("request/district")
public class DistrictController {
    @Resource
    DistrictService districtService;

    @ApiOperation("请求省市区数据")
    @GetMapping("/")
    public HttpResult get() {
        val city = GaoDeApi.keywords;
        for (String c : city) {
            DistrictsVo vo = HttpRequestUtil.getRequestResult(HttpRequest.get(GaoDeApi.URL + "keywords=" + c), DistrictsVo.class);
            districtService.insert(vo);
        }
        return HttpResult.ok("获取省市区数据成功");
    }

    @ApiOperation("获取省市区")
    @PostMapping("/tree")
    public HttpResult post(@RequestBody DistrictQuery query) {
        return HttpResult.ok("获取省市区成功", districtService.tree(query));
    }
}
