package com.kay.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author kay
 * @Data 2018/5/17 15:15
 */
@RestController
@RequestMapping("/uesr")
public class UserController {
    @GetMapping("/hi")
    public String hi(){
        return "I'm kay";
    }
}
