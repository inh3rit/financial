package org.inh3rit.financial.common;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: ytxu3
 * @Date: 17:17 2019-09-17
 */
@Component
@Configurable("customConfiguration")
public class CustomConfiguration {

    @Value("${test.test}")
    private String test;

    public String getTest() {
        return test;
    }
}
