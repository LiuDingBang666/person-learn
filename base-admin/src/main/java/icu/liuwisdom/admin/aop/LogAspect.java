package icu.liuwisdom.admin.aop;

import com.alibaba.fastjson.JSON;
import icu.liuwisdom.admin.annotation.Log;
import icu.liuwisdom.admin.entity.SysLog;
import icu.liuwisdom.admin.entity.SysUser;
import icu.liuwisdom.admin.service.SysLogService;
import icu.liuwisdom.admin.service.SysLoginLogService;
import icu.liuwisdom.admin.utils.SecurityUtils;
import icu.liuwisdom.constant.SysConstants;
import icu.liuwisdom.core.http.HttpResult;
import icu.liuwisdom.enums.LogEnum;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 日志切面
 *
 * @author LDB
 * @version 1.0
 * @date 2022-07-23 12:02
 */
@Component
@Aspect
@Order(1)
@Slf4j
@SuppressWarnings("all")
public class LogAspect {

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Resource
    SysLogService sysLogService;

    @Resource
    SysLoginLogService sysLoginLogService;

    @Resource
    HttpSession session;

    /**
     * 注解日志
     *
     * @author LDB
     * @date 2022-07-23
     **/
    @Pointcut("@annotation(icu.liuwisdom.admin.annotation.Log)")
    public void annotationLogPoint() {
    }

    /**
     * 执行注解之前的操作
     *
     * @author LDB
     * @date 2022-07-23
     **/
    @Before("annotationLogPoint()")
    public void beforeAnnotationLog() {
        startTime.set(System.currentTimeMillis());
    }

    /**
     * 注解日志
     *
     * @param joinPoint 切入点
     * @param res       返回结果
     * @author LDB
     * @date 2022-07-23
     **/
    @AfterReturning(pointcut = "annotationLogPoint()", returning = "res")
    public void afterAnnotationLog(JoinPoint joinPoint, HttpResult res) {
        addLog(joinPoint, res);
    }

    /**
     * 所有控制器的日志
     *
     * @author LDB
     * @date 2022-07-23
     **/
    @Pointcut("execution(* icu.liuwisdom..*.controller..*.*(..))")
    public void logPoint() {
    }

    /**
     * 请求前设置时间
     *
     * @author LDB
     * @date 2022-07-23
     **/
    @Before("logPoint()")
    public void beforeLogPoint() {
        startTime.set(System.currentTimeMillis());
    }

    /**
     * 捕获异常信息
     *
     * @param joinPoint 切入方法
     * @param e         结果
     * @author LDB
     * @date 2022-07-23
     **/
    @AfterThrowing(pointcut = "logPoint()", throwing = "e")
    public void afterThrowingPoint(JoinPoint joinPoint, Throwable e) {
        addErrorLog(joinPoint, e);
    }

    /**
     * 新增异常日志
     *
     * @param joinPoint 切入点
     * @param e         执行结果
     * @author LDB
     * @date 2022-07-23
     **/
    private void addErrorLog(JoinPoint joinPoint, Throwable e) {
        val username = SecurityUtils.getLoginUserName();
        val userSession = (SysUser) session.getAttribute(SysConstants.USER_INFO);
        if (StringUtils.isEmpty(username) && Objects.isNull(userSession)) {
            return;
        }
        // 从请求容器中获取请求属性
        val requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从请求属性中获取到当前请求
        val httpServletRequest = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        val po = new SysLog();
        // 获取请求方法
        val signature = (MethodSignature) joinPoint.getSignature();
        val method = signature.getMethod();
        // 获取请求类
        val className = joinPoint.getTarget().getClass().getName();
        // 设置信息
        po.setMethod(className + "." + method.getName());
        po.setParams(getArgs(joinPoint));
        po.setUserName(StringUtils.isEmpty(username) ? userSession.getName() : username);
        po.setIp(httpServletRequest.getRemoteAddr());
        po.setTime(System.currentTimeMillis() - startTime.get());
        po.setResult(LogEnum.FAIL.getValue());
        po.setErrorInfo(stackTraceToString(e.getClass().getName(), e.getMessage(), e.getStackTrace()));
        // 获取注解信息
        val log = method.getAnnotation(Log.class);
        if (Objects.nonNull(log)) {
            po.setOperation(log.operation());
            po.setMemo(log.memo());
        }
        sysLogService.save(po);
    }


    /**
     * 新增普通日志信息
     *
     * @param joinPoint 切入点
     * @param result    执行结果
     * @author LDB
     * @date 2022-07-23
     **/
    private void addLog(JoinPoint joinPoint, HttpResult result) {
        val username = SecurityUtils.getLoginUserName();
        val userSession = (SysUser) session.getAttribute(SysConstants.USER_INFO);
        if (StringUtils.isEmpty(username) && Objects.isNull(userSession)) {
            return;
        }
        // 从请求容器中获取请求属性
        val requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从请求属性中获取到当前请求
        val httpServletRequest = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);

        val po = new SysLog();
        // 获取请求方法
        val signature = (MethodSignature) joinPoint.getSignature();
        val method = signature.getMethod();
        // 获取请求类
        val className = joinPoint.getTarget().getClass().getName();
        // 设置信息
        po.setMethod(className + "." + method.getName());
        po.setParams(getArgs(joinPoint));
        po.setResultInfo(JSON.toJSONString(result));
        po.setUserName(StringUtils.isEmpty(username) ? userSession.getName() : username);
        po.setIp(httpServletRequest.getRemoteAddr());
        po.setTime(System.currentTimeMillis() - startTime.get());
        po.setResult(LogEnum.SUCCESS.getValue());
        // 获取注解信息
        val log = method.getAnnotation(Log.class);
        if (Objects.nonNull(log)) {
            po.setOperation(log.operation());
            po.setMemo(log.memo());
        }
        sysLogService.save(po);
    }


    /**
     * 转换request 请求参数
     *
     * @param paramMap 参数map
     * @return java.util.Map<java.lang.String, java.lang.String>
     * @author LDB
     * @date 2022-07-23
     **/
    public Map<String, String> convertMap(Map<String, String[]> paramMap) {
        Map<String, String> rtnMap = new HashMap<>();
        for (String key : paramMap.keySet()) {
            rtnMap.put(key, paramMap.get(key)[0]);
        }
        return rtnMap;
    }

    /**
     * 获取请求参数
     *
     * @param point 请求方法
     * @return java.lang.String
     * @author LDB
     * @date 2022-07-23
     **/
    private String getArgs(JoinPoint point) {
        String[] parameterNames = ((MethodSignature) point.getSignature()).getParameterNames();
        if (parameterNames.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < 1; i++) {
            if (point.getArgs()[i] != null) {
                sb.append(parameterNames[i] + ":" + point.getArgs()[i].toString());
            }
        }
        sb.append("}");
        return sb.toString();
    }

    /**
     * 转换异常信息为字符串
     *
     * @param exceptionName    异常名
     * @param exceptionMessage 异常消息
     * @param elements         栈信息
     * @return java.lang.String
     * @author LDB
     * @date 2022-07-23
     **/
    public String stackTraceToString(String exceptionName, String exceptionMessage, StackTraceElement[] elements) {
        StringBuffer strbuff = new StringBuffer();
        for (StackTraceElement stet : elements) {
            strbuff.append(stet + "<br/>");
        }
        String message = exceptionName + ":" + exceptionMessage + "<br/>" + strbuff;
        return message;
    }
}
