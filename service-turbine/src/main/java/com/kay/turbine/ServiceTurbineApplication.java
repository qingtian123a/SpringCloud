package com.kay.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @Author kay
 * @Data 2018/5/17 13:58
 */
@SpringBootApplication
@EnableTurbine //开启turbine，@EnableTurbine注解包含了@EnableDiscoveryClient注解，即开启了注册服务。
public class ServiceTurbineApplication {

    public static void main(String[] args){
        SpringApplication.run(ServiceTurbineApplication.class,args);
    }
}
