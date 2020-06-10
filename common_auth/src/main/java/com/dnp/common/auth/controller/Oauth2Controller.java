package com.dnp.common.auth.controller;

import com.alibaba.fastjson.JSON;
import com.dnp.common.auth.util.RestTempleteUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * description:认证服务相关接口
 *
 * @author: 华仔
 * @date: 2020/6/5
 */
@Api(value = "Oauth2Controller", description = "认证服务相关接口")
@RestController
public class Oauth2Controller {
    @Autowired
    private ClientDetailsService clientDetailsService;

    @ApiOperation(value = "获取客户端详情")
    @RequestMapping(value = "/getClientInfo", method = RequestMethod.POST)
    public Object getClientInfo(@RequestParam String clientId) {
        return clientDetailsService.loadClientByClientId(clientId);
    }

    @ApiOperation(value = "密码模式获取token")
    @RequestMapping(value = "/getToken", method = RequestMethod.POST)
    public String getToken(HttpServletRequest request,
                           @RequestParam(defaultValue = "admin") String username,
                           @RequestParam(defaultValue = "123456") String password,
                           @RequestParam(defaultValue = "client") String client_id,
                           @RequestParam(defaultValue = "123456") String client_secret) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", username);
        params.add("password", password);
        params.add("grant_type", "password");
        params.add("client_id", client_id);
        params.add("client_secret", client_secret);

        String baseUrl = request.getRequestURL().substring(0, request.getRequestURL().length() - 9) + "/oauth/token";
        return new RestTempleteUtil().sendPost(baseUrl, params);
    }
}
