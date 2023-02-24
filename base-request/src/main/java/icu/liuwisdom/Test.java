package icu.liuwisdom;

import com.alibaba.fastjson.JSON;
import com.github.kevinsawicki.http.HttpRequest;
import icu.liuwisdom.request.gaode.common.GaoDeApi;
import icu.liuwisdom.request.gaode.vo.DistrictsVo;
import icu.liuwisdom.request.jh.area.Area;
import icu.liuwisdom.request.jh.area.AreaResult;
import icu.liuwisdom.request.jh.common.JuHeApi;
import icu.liuwisdom.request.util.HttpRequestUtil;

import java.util.List;

/**
 * 请求测试类
 *
 * @author LDB
 * @version 1.0
 * @date 2022-07-25 15:59
 */

public class Test {
    public static void main(String[] args) {
        DistrictsVo vo = HttpRequestUtil.getRequestResult(HttpRequest.get(GaoDeApi.URL + "keywords=" + "中华人民共和国"), DistrictsVo.class);
        System.out.println(JSON.toJSONString(vo));
    }


    /**
     * 聚合测试
     *
     * @author LDB
     * @date 2022-07-25
     **/
    public static void juheTest() {
        AreaResult requestResult = HttpRequestUtil
                .getRequestResult(HttpRequest.get(JuHeApi.URL + "?key=" + JuHeApi.KEY + "&fid=320000"), AreaResult.class);
        List<Area> result = requestResult.getResult();
        for (Area area : result) {
            System.out.println(area);
        }
    }
}
