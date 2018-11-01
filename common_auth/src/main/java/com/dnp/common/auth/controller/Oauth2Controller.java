package com.dnp.common.auth.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 第3放接口，通过客户端id和密码获取授权码，然后在通过
 * @author 华仔
 * @date 2018/10/19 14:47
 */
@Api(description = "第3放授权")
@RestController
public class Oauth2Controller {

    @ApiOperation(value = "获取授权码", notes = "Test")
    @RequestMapping(value = "/getPermission", method = RequestMethod.GET)
    public String getOauth2Code(@RequestParam Integer userId) {
        return "getPermission OK!";
    }
}
