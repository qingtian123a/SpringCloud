package com.kay.data.controller;

import com.kay.data.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author kay
 * @Data 2018/5/9 14:03
 */
@RestController
@RequestMapping(value = "test")
public class TestController {

    @Autowired
    TestService helloService;
    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        return helloService.hiService(name);
    }
}
