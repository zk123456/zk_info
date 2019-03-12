package com.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Zhangk
 * @Date 18:17 2019/2/22
 * @Description
 */

/**
 * 全局异常,正常情况下这个类要放到扫描controller的包里面
 */
@ControllerAdvice
public class GloabalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception{
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", request.getRequestURL());
        mav.setViewName("error");
        /**
         * 异常处理既可以映射到html
         * 也可以返回具体的对象数据
         */
        return mav;
    }
}
