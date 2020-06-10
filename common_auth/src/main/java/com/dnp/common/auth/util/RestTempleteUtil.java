package com.dnp.common.auth.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * @author huazai
 * @description restTemplete发送http请求
 * @date 2020/6/5
 */
public class RestTempleteUtil {

    public String sendPost(String requestUrl, MultiValueMap<String, String> requestParam) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestParam, null);
            ResponseEntity<String> response = restTemplate.postForEntity(requestUrl, requestEntity, String.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            return e.getResponseBodyAsString();
        }
    }
}
