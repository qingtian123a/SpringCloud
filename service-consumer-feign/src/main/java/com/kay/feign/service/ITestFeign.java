package com.kay.feign.service;

import com.kay.feign.configure.FeignClientConfig;
import com.kay.feign.hystric.ITestFeignHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author kay
 * @Data 2018/5/9 14:25
 */
@FeignClient(value = "service-provider", fallback = ITestFeignHystric.class)                                  //configuration = FeignClientConfig.class
public interface ITestFeign {

    @RequestMapping(value = "/test/hi",method = RequestMethod.GET)                                             //consumes = MediaType.APPLICATION_JSON
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
