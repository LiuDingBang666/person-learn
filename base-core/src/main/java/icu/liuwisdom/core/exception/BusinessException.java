package icu.liuwisdom.core.exception;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 业务异常类
 *
 * @author ldb
 * @ClassName BusinessException.java
 * @Data 2022-02-21 13:57
 */
@ApiModel("业务异常类")
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("异常消息")
    private String msg;

    @ApiModelProperty("异常状态码")
    private int code = 500;

    public BusinessException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BusinessException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public BusinessException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public BusinessException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
