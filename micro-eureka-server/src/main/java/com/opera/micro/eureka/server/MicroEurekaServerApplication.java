package com.opera.micro.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by hanghang on 2019/9/9.
 */
@SpringBootApplication
@EnableEurekaServer
public class MicroEurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroEurekaServerApplication.class,args);
    }
}
