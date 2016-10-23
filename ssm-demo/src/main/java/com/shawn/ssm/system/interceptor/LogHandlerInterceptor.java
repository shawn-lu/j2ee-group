/**
 * Project Name:ssm-demo
 * File Name:LogHandlerInterceptor.java
 * Package Name:com.shawn.ssm.system.interceptor
 * Date:2016-10-23下午4:53:28
 *
 */


package com.shawn.ssm.system.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * ClassName: LogHandlerInterceptor <br/>
 * Date: 2016-10-23 下午4:53:28 <br/>
 * Description: TODO 
 *
 * @author luxf
 * @version 
 * @see
 */
public class LogHandlerInterceptor implements HandlerInterceptor{

    private static final Logger LOGGER = LoggerFactory
            .getLogger(LogHandlerInterceptor.class);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        LOGGER.debug("SESSION={} pre handler={}", request.getSession().getId(), handler.toString());
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        LOGGER.debug("SESSION={} post handler={}", request.getSession().getId(), handler.toString());
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            String clazzName = handlerMethod.getBean().getClass()
                    .getSimpleName();
            String methodName = handlerMethod.getMethod().getName();
            LOGGER.debug(String.format(
                    ">>>> afterCompletion : [anonymous] execute class %s's method %s", clazzName, methodName));
        }

    }
}

