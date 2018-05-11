package com.kay.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author kay
 * @Data 2018/5/9 14:04
 */
@Service
public class TestService {

    @Autowired
    RestTemplate restTemplate;

    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-PROVIDER/test/hi?name="+name,String.class);
    }
}
