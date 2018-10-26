package com.dnp.service.zuul.feign;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 熔断处理
 *@Author 华仔
 *@DATE 2018/10/18 10:39
 */
@Component
public class PttFeignProviderHystrix implements PttFeignService {

    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "Hello World! fail";
    }

    @Override
    public String customFilter(@RequestParam(value = "name") String name) {
        return "Custom Filter fail";
    }

}