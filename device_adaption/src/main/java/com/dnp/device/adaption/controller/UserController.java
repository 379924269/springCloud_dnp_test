package com.dnp.device.adaption.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "hellow测试方法", notes = "Test")
    @GetMapping("")
    public String getUserInfo() throws Exception {
        return "hello huazai";
    }
}
