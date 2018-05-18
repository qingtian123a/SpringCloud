package com.kay.feign.configure;

import feign.Logger;
import feign.codec.Encoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;

/**
 * @Author kay
 * @Data 2018/5/18 13:58
 */
public class FeignClientConfig {

    @Bean
    public Logger.Level getFeignLoggerLevel() {
        return Logger.Level.FULL ;
    }

//    //上传图片编码
//    @Autowired
//    private ObjectFactory<HttpMessageConverters> messageConverters;
//
//    @Bean
//    public Encoder feignFormEncoder() {
//        return new SpringFormEncoder(new SpringEncoder(messageConverters));
//    }
}
