package com.opera.micro.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by hanghang on 2019/9/9.
 */
@SpringBootApplication
@EnableDiscoveryClient //开始EurekaClient功能
public class MicroProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroProducerApplication.class, args);
    }
}
