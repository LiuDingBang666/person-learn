package icu.liuwisdom.request.gaode.common;

import java.util.Arrays;
import java.util.List;

/**
 * 高德API
 *
 * @author LDB
 * @version 1.0
 * @date 2022-07-25 15:52
 */

public interface GaoDeApi {
    /**
     * 接口地址前缀
     *
     * @author LDB
     * @date 2022-07-25 15:53
     * @version 1.0
     */
    String URL = "https://restapi.amap.com/v3/config/district?key=" + GaoDeApi.KEY + "&subdistrict=3&extensions=base&";

    /**
     * 请求key
     *
     * @author LDB
     * @date 2022-07-25 15:55
     * @version 1.0
     */

    String KEY = "ef7a817cfd8d2b4e62873daf64021d2c";

    /**
     * 省份关键字列表
     *
     * @author LDB
     * @date 2022-07-25 22:20
     * @version 1.0
     */
    List<String> keywords = Arrays.asList(new String[]{"河北省", "山西省", "辽宁省", "吉林省", "黑龙江省", "江苏省", "浙江省", "安徽省", "福建省", "江西省", "山东省", "河南省", "湖北省", "湖南省", "广东省", "海南省", "四川省", "贵州省", "云南省", "陕西省", "甘肃省", "青海省", "台湾省", "内蒙古自治区", "广西壮族自治区", "西藏自治区", "宁夏回族自治区", "新疆维吾尔自治区", "北京市", "天津市", "上海市", "重庆市", "香港特别行政区", "澳门特别行政区"});
}
