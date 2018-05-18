package com.kay.feign.hystric;

import com.kay.feign.service.ITestFeign;
import org.springframework.stereotype.Component;

/**
 * @Author kay
 * @Data 2018/5/10 16:31
 */
@Component
public class ITestFeignHystric implements ITestFeign {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name;
    }
}
