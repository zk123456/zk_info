package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


/**
 * @author zk
 * @Date 11:36 2019/3/11
 */
//定义切面
@Aspect
/**
 * 假如有多个切面,按照设定好的优先级执行,数字越小,优先级越高
 */
@Order(1)
@Component
public class WebLogAop {

    private Logger logger = LoggerFactory.getLogger(WebLogAop.class);

    ThreadLocal<Long> time = new ThreadLocal<>();

    //方法的可见性(如public)--方法的返回值类型--方法所在类的全路径--方法名--方法参数--throws-patten?
    //定义切点
    @Pointcut("execution(public * com.chapter.HelloController.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        time.set(System.currentTimeMillis());
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "webLog()", returning = "ret")
    public void doAfter(Object ret) {
        logger.info("response = " + ret);
        logger.info("共消耗时间:" + (System.currentTimeMillis() - time.get()) + "ms");
    }
}
