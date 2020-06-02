package com.dnp.common.auth.client.hystrix;


import com.dnp.common.auth.client.AuthServiceClient;
import org.springframework.stereotype.Component;

/**
 * Created by fangzhipeng on 2017/5/31.
 */
@Component
public class AuthServiceHystrix implements AuthServiceClient {
    @Override
    public Object getToken(String authorization, String type, String username, String password) {
        return null;
    }
}
