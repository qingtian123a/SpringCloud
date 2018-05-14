package com.kay.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @Author kay
 * @Data 2018/5/14 13:23
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientBusApplication {

    public static void main(String[] args){

        SpringApplication.run(ConfigClientBusApplication.class,args);
    }

    /**
     * 问题解决方法.
     * spring boot could not resolve placeholder in string value .
     * @return
     */
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
//        PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
//        c.setIgnoreUnresolvablePlaceholders(true);
//        return c;
//    }
}
