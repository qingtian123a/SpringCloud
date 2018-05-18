package com.kay.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.EnableZipkinServer;

/**
 * @Author kay
 * @Data 2018/5/18 12:50
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class ServerZipkinElkApplication {

    public static void main(String[] args){
        SpringApplication.run(ServerZipkinElkApplication.class,args);
    }
}
