package com.kay.configure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author kay
 * @Data 2018/5/11 10:25
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigureServerApplication {
    public static void main(String[] args){

        SpringApplication.run(ConfigureServerApplication.class,args);
    }
}
