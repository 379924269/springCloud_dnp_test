package com.dnp.common.auth.controller;

import com.dnp.common.auth.client.AuthServiceClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.provider.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 授权客户端的操作，集体操作表（123456）
 *
 * @author 华仔
 * @date 2018/10/19 14:47
 */
@Api(value = "ClientRegisterController", description = "授权客户端的操作")
@RestController
public class ClientRegisterController {
    @Autowired
    @Qualifier(value = "clientDetailsService")
    private ClientDetailsService clientDetailsService;

    @Autowired
    private ClientRegistrationService clientRegistrationService;

    @ApiOperation(value = "添加客戶端", notes = "Test")
    @RequestMapping(value = "/addClientDetails", method = RequestMethod.GET)
    public void addClientDetails(ClientDetails clientDetails) throws ClientAlreadyExistsException {
        clientRegistrationService.addClientDetails(clientDetails);
    }

    @ApiOperation(value = "修改客戶端", notes = "Test")
    @RequestMapping(value = "/updateClientDetails", method = RequestMethod.GET)
    public void updateClientDetails(ClientDetails clientDetails) throws NoSuchClientException {
        clientRegistrationService.updateClientDetails(clientDetails);
    }

    @ApiOperation(value = "修改客戶端密碼", notes = "Test")
    @RequestMapping(value = "/updateClientSecret", method = RequestMethod.GET)
    public void updateClientSecret(String clientId, String secret) throws NoSuchClientException {
        clientRegistrationService.updateClientSecret(clientId, secret);

    }

    @ApiOperation(value = "刪除客戶端", notes = "Test")
    @RequestMapping(value = "/removeClientDetails", method = RequestMethod.GET)
    public void removeClientDetails(String clientId) throws NoSuchClientException {
        clientRegistrationService.removeClientDetails(clientId);
    }

    @ApiOperation(value = "获取所有客户端", notes = "Test")
    @RequestMapping(value = "/listClientDetails", method = RequestMethod.GET)
    public List<ClientDetails> listClientDetails() {
        return clientRegistrationService.listClientDetails();
    }

}
