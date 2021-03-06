package com.kay.bustwo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author kay
 * @Data 2018/5/11 14:46
 */
@RefreshScope
@RestController
@RequestMapping(value = "test")
public class TestClientBusController {

    @Value("${foo}")
    String foo;

    @RequestMapping(value = "/hi")
    public String hi(){
        return foo;
    }
}
