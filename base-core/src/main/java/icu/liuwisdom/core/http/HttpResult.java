package icu.liuwisdom.core.http;

import icu.liuwisdom.constant.ErrorCode;
import icu.liuwisdom.constant.SystemConstant;
import icu.liuwisdom.utils.DateUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 请求结果封装类
 *
 * @author ldb
 * @ClassName HttpResult.java
 * @Data 2022-02-19 15:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("请求结果封装类")
public class HttpResult<T> {
    @ApiModelProperty("响应码")
    private int code;

    @ApiModelProperty("响应消息")
    private String msg;

    @ApiModelProperty("响应数据")
    private T data;

    @ApiModelProperty("响应时间")
    @DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
    private LocalDateTime time;

    public static HttpResult<Boolean> error() {
        return error(ErrorCode.BUSINESS_ERROR, SystemConstant.ERROR_MSG);
    }

    public static HttpResult<Boolean> error(String msg) {
        return error(ErrorCode.BUSINESS_ERROR, msg);
    }

    public static HttpResult<Boolean> error(int code, String msg) {
        return new HttpResult(code, msg, false, LocalDateTime.now());
    }

    public static HttpResult<Boolean> ok(String msg) {
        return new HttpResult(HttpStatus.SC_OK, msg, true, LocalDateTime.now());
    }

    public static <D> HttpResult<D> ok(String msg, D data) {
        return new HttpResult<D>(HttpStatus.SC_OK, msg, data, LocalDateTime.now());
    }

    public static <D> HttpResult<D> ok(D data) {
        return new HttpResult<D>(HttpStatus.SC_OK, SystemConstant.SUCCESS_MSG, data, LocalDateTime.now());
    }

    public static HttpResult<Boolean> ok() {
        return ok(SystemConstant.SUCCESS_MSG);
    }
}
