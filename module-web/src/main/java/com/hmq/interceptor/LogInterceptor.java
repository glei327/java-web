package com.hmq.interceptor;

import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 日志拦截器组件，在输出日志中加上sessionId
 *
 */
public class LogInterceptor implements HandlerInterceptor {
    /**
     * 会话ID
     */
    private final static String SESSION_KEY = "sessionId";

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // 删除SessionId
        MDC.remove(SESSION_KEY);
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        // 设置SessionId
        //String token = UUID.randomUUID().toString().replace("-", "");
        MDC.put(SESSION_KEY, "----------");
        return true;
    }
}