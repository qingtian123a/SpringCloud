package com.kay.bustwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author kay
 * @Data 2018/5/14 13:23
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientBusTwoApplication {

    public static void main(String[] args){

        SpringApplication.run(ConfigClientBusTwoApplication.class,args);
    }

}
