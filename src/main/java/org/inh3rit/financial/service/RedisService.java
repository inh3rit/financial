package org.inh3rit.financial.service;

import org.inh3rit.financial.model.ESModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: ytxu3
 * @Date: 14:48 2019-09-20
 */
@Service
public class RedisService {

    //操作字符串的template，StringRedisTemplate是RedisTemplate的一个子集
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // RedisTemplate，可以进行所有的操作
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public void hset(String key, String hk, String hv) {
        stringRedisTemplate.opsForHash().put(key, hk, hv);
    }

    public void set(ESModel s) {
        redisTemplate.opsForValue().set(s.getId(), s);
    }

    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    public ESModel getStudent(String key) {
        return (ESModel) redisTemplate.opsForValue().get(key);
    }
}
