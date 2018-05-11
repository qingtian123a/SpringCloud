package com.kay.data.service;

import com.kay.data.hystric.ITestFeignHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author kay
 * @Data 2018/5/9 14:25
 */
@FeignClient(value = "service-provider", fallback = ITestFeignHystric.class)
public interface ITestFeign {

    @RequestMapping(value = "/test/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
