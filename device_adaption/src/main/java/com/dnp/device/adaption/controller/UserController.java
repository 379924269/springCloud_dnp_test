package com.dnp.device.adaption.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 *
 * @author wanghaobin
 * @create 2017-06-08 11:51
 */
@Api(description = "操作redis")
@RestController
@RequestMapping("hello")
public class UserController {
    @Autowired
private DiscoveryClient discoveryClient;

    @ApiOperation(value = "hellow测试方法", notes = "Test")
    @GetMapping("")
    public String getUserInfo() throws Exception {
        return "hello huazai";
    }
}
