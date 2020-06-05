package com.dnp.common.auth.token;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * @author huazai
 * @description token的各种测试
 * @date 2020/4/29
 */
@Slf4j
public class TokenTest {
    @Test
    public void getInfoWithToken() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        headers.set("Authorization", "bearer 9fa671c0-fb94-4f32-af42-79a9d6e9b699");
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8082/oauth2/client/getContactInfo", requestEntity, String.class);
        String getAuthorizeCode = response.getBody();
        log.info("getAuthorizeCode => {}", getAuthorizeCode);
    }

    @Test
    public void encrpty() {
        BCryptPasswordEncoder xx = new BCryptPasswordEncoder();
        xx.encode("123456");
        log.info(xx.encode("123456"));
    }


    /**
     * description: 密码模式
     */
    @Test
    public void passwordModeTest() {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", "admin");
        params.add("password", "123456");
        params.add("grant_type", "password");
        params.add("client_id", "client");
        params.add("client_secret", "123456");

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, null);
        try {
            ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:5555/oauth2/oauth/token",requestEntity,String.class);
            Integer statusCode = response.getStatusCodeValue();
            System.out.println("statusCode = " + statusCode);

            String responseBody = response.getBody();

            log.info("responseBody => {}", responseBody);
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        }
    }
}
