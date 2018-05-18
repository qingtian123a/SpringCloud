package com.kay.zipkin;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import zipkin.server.EnableZipkinServer;
import zipkin.storage.mysql.MySQLStorage;

import javax.sql.DataSource;


/**
 * @Author kay
 * @Data 2018/5/15 15:54
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class ServerZipkinApplication {

    public static void main(String[] args){
        SpringApplication.run(ServerZipkinApplication.class,args);
    }

    @Bean
    public MySQLStorage mySQLStorage(DataSource datasource) {
        return MySQLStorage.builder().datasource(datasource).executor(Runnable::run).build();
    }
}
