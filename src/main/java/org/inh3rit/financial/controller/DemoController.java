package org.inh3rit.financial.controller;

import org.inh3rit.financial.model.ESModel;
import org.inh3rit.financial.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @Description:
 * @Author: ytxu3
 * @Date: 9:52 2019-09-21
 */
@RestController
@RequestMapping("demo")
public class DemoController {

    private static Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "test")
    public String test(ESModel esModel) {
        try {
            demoService.index(esModel);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return "SUCCESS";
    }
}
