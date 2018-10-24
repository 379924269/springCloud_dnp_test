package com.dnp.common.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * 操作redis
 *
 * @Author 华仔
 * @DATE 2018/10/19 14:42
 */
@Component
public class RedisStringUtils {

    @Autowired
    private StringRedisTemplate template;

    public void setKey(String key, String value) {
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key, value);
    }

    public String getValue(String key) {
        ValueOperations<String, String> ops = template.opsForValue();
        return ops.get(key);
    }

}
