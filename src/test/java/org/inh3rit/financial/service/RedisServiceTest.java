package org.inh3rit.financial.service;

import org.inh3rit.financial.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:
 * @Author: ytxu3
 * @Date: 14:51 2019-09-20
 */
public class RedisServiceTest extends BaseTest {

    @Autowired
    private RedisService redisService;

    @Test
    public void set() {
        redisService.set("test_1_key", "test_1_value");
    }

    @Test
    public void hset() {
    }

    @Test
    public void testSet() {
    }

    @Test
    public void get() {
    }

    @Test
    public void getStudent() {
    }
}
