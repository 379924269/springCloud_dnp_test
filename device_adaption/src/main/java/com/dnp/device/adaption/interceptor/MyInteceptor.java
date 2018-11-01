package com.dnp.device.adaption.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * @author 华仔
 * @date 2018/4/23 11:25
 */
public class MyInteceptor implements HandlerInterceptor {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        showMethodLog(request);
    }

    //拦截器处理日志，参考地址（https://blog.csdn.net/u011521890/a   rticle/details/74990338）
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //OperateLogUtil.logHandler(request, response, handler, ex);
    }

    /**
     * <p> 用来显示请求方法和请求参数的
     *
     * @param request
     */
    private void showMethodLog(HttpServletRequest request) {
        String requestUriString = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url = requestUriString.substring(contextPath.length());
        StringBuffer bfParams = new StringBuffer();
        @SuppressWarnings("unchecked")
        Enumeration<String> paraNames = request.getParameterNames();
        String key;
        String value;
        while (paraNames.hasMoreElements()) {
            key = paraNames.nextElement();
            value = request.getParameter(key);
            bfParams.append(key).append("=").append(value).append("&");
        }
        if (StringUtils.isEmpty(bfParams)) {
            bfParams.append(request.getQueryString());
        }

        String strMessage = String.format("[方法]:%s,[参数]:%s", url, bfParams.toString());
        LoggerFactory.getLogger(MyInteceptor.class).info(strMessage);
    }
}
