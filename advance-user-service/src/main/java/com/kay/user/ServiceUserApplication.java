package com.kay.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author kay
 * @Data 2018/5/17 15:12
 */
@SpringBootApplication
@EnableEurekaClient
public class ServiceUserApplication {

    public static void main(String[] args){
        SpringApplication.run(ServiceUserApplication.class,args);
    }
}
