package com.kay.data.controller;

import com.kay.data.service.ITestFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author kay
 * @Data 2018/5/9 14:37
 */
@RestController
@RequestMapping(value="test")
public class TestController {

    @Autowired
    ITestFeign iTestFeign;
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return iTestFeign.sayHiFromClientOne(name);
    }
}
