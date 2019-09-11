package com.opera.micro.consumer.dao.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import feign.Logger.Level;

/**
 * Created by hanghang on 2019/9/11.
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Level.FULL;
    }
}
