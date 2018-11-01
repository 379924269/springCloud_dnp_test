package com.dnp.device.adaption.config;

import com.dnp.device.adaption.interceptor.MyInteceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 配置alibaba的监控
 *
 * @author huazai
 * @Date 2017/8/10
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    private Logger logger = LoggerFactory.getLogger(getClass());


    //添加自己的拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInteceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
