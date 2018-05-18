package com.kay.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * @Author kay
 * @Data 2018/5/15 15:54
 */
@SpringBootApplication
@EnableZipkinServer
public class ServerZipkinApplication {

    public static void main(String[] args){
        SpringApplication.run(ServerZipkinApplication.class,args);
    }
}
