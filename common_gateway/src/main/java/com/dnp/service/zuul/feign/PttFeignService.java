package com.dnp.service.zuul.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 调用ptt服务
 *
 * @Author 华仔
 * @DATE 2018/10/18 10:40
 */
@FeignClient(name = "device", fallback = PttFeignProviderHystrix.class)
public interface PttFeignService {

    /**
     * @param name
     * @return
     */
    @GetMapping("/hello")
    String hello(@RequestParam(value = "name") String name);


    /**
     * 自定义Filter
     *
     * @param name
     * @return
     */
    @GetMapping("/hello/customFilter")
    String customFilter(@RequestParam(value = "name") String name);

}
