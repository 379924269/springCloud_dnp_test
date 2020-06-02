package com.dnp.common.auth.controller;

import com.dnp.common.auth.config.RedisStringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 华仔
 * @date 2018/10/19 14:47
 */
@Api(value = "OptRedisController", description = "操作redis")
@RestController
public class OptRedisController {

    @Autowired
    private RedisStringUtils redisStringUtils;

    @ApiOperation(value = "module模块,Test方法", notes = "Test")
    @RequestMapping(value = "/setKey", method = RequestMethod.GET)
    public String setKey(@RequestParam String key, @RequestParam String value) {
        // redis操作
        redisStringUtils.setKey(key, value);
        return "setKey OK!";
    }

    @ApiOperation(value = "module模块,Test方法", notes = "Test")
    @RequestMapping(value = "/getKey", method = RequestMethod.GET)
    public String getKey(@RequestParam String key) {
        // redis操作
        String value = redisStringUtils.getValue(key);

        return value;
    }

}
