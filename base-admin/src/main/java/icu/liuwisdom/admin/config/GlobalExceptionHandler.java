package icu.liuwisdom.admin.config;

import icu.liuwisdom.constant.ErrorCode;
import icu.liuwisdom.core.exception.BusinessException;
import icu.liuwisdom.core.http.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.time.format.DateTimeParseException;

/**
 * 全局异常捕获类
 *
 * @author ldb
 * @ClassName GlobalExceptionHandler.java
 * @Data 2021-09-278:48
 */
@Slf4j
@RestControllerAdvice
@SuppressWarnings("all")
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public HttpResult handle(RuntimeException e) {
        e.printStackTrace();
        return HttpResult.error("系统运行时异常");
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(value = AccessDeniedException.class)
    public HttpResult handle(AccessDeniedException e) {
        e.printStackTrace();
        return HttpResult.error(HttpStatus.FORBIDDEN.value(), "用户无权限");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RedisConnectionFailureException.class)
    public HttpResult handle(RedisConnectionFailureException e) {
        e.printStackTrace();
        return HttpResult.error("Redis连接异常");
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = DateTimeParseException.class)
    public HttpResult handle(DateTimeParseException e) {
        e.printStackTrace();
        return HttpResult.error("数据转换异常");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BadSqlGrammarException.class)
    public HttpResult handle(BadSqlGrammarException e) {
        e.printStackTrace();
        return HttpResult.error("SQL语句异常");
    }


    /**
     * 业务异常
     *
     * @param e
     * @return icu.liuwisdom.video.common.lang.Result
     * @author Ldb
     * @date 2021-10-09
     **/
    @ExceptionHandler(value = BusinessException.class)
    public HttpResult BusinessHandle(BusinessException e) {
        e.printStackTrace();
        return HttpResult.error(e.getCode(), e.getMessage());
    }

    /**
     * 表单数据填写异常处理
     *
     * @param e
     * @return icu.liuwisdom.video.common.lang.Result
     * @author Ldb
     * @date 2021-10-10
     **/
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public HttpResult validException(MethodArgumentNotValidException e) {
        e.printStackTrace();
        return HttpResult.error(ErrorCode.FORM_ERROR, "表单数据填写错误");
    }

    /**
     * 空指针异常
     *
     * @param e
     * @return icu.liuwisdom.video.common.lang.Result
     * @author Ldb
     * @date 2021-10-14
     **/
    @ExceptionHandler(value = NullPointerException.class)
    public HttpResult nullPointerException(NullPointerException e) {
        e.printStackTrace();
        return HttpResult.error("系统异常，请联系管理员");
    }

    /**
     * 数据库异常
     *
     * @param e
     * @return icu.liuwisdom.video.common.lang.Result
     * @author Ldb
     * @date 2021-10-18
     **/
    @ExceptionHandler(value = MyBatisSystemException.class)
    public HttpResult MyBatisSystemException(MyBatisSystemException e) {
        e.printStackTrace();
        return HttpResult.error("数据库异常，请联系管理员");
    }


    /**
     * 文件上传大小超出异常
     *
     * @param e
     * @return icu.liuwisdom.video.common.lang.Result
     * @author Ldb
     * @date 2021-10-23
     **/
    @ExceptionHandler(value = MaxUploadSizeExceededException.class)
    public HttpResult MyBatisSystemException(MaxUploadSizeExceededException e) {
        e.printStackTrace();
        return HttpResult.error("文件大小超出最大可上传大小");
    }
}
