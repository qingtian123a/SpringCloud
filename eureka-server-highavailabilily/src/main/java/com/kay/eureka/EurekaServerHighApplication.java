package com.kay.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author kay
 * @Data 2018/5/16 15:10
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerHighApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerHighApplication.class, args);
    }
}
