package icu.liuwisdom.request.util;

import com.alibaba.fastjson.JSON;
import com.github.kevinsawicki.http.HttpRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Http请求工具
 *
 * @author LDB
 * @version 1.0
 * @date 2022-07-25 15:10
 */
@Slf4j
@Component
public class HttpRequestUtil {

    /**
     * 获取最后请求到的数据
     *
     * @param request 请求后的结果
     * @param c       指定类类型
     * @return T
     * @author LDB
     * @date 2022-07-25
     **/
    public static <T> T getRequestResult(HttpRequest request, Class<T> c) {
        log.info(request.url().toString());
        if (!request.ok()) {
            log.error(request.message());
        }
        return JSON.parseObject(request.body(), c);
    }

    /**
     * post表单提交数据
     *
     * @author LDB
     * @date 2022-07-25 15:47
     * @version 1.0
     */
    public static HttpRequest postForm(String url, Map<String, Object> params) {
        HttpRequest request = HttpRequest.post(url).form(params);
        if (!request.created()) {
            log.error(request.message());
        }
        return request;
    }

}
