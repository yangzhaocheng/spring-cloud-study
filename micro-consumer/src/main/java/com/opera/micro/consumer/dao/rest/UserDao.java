package com.opera.micro.consumer.dao.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.opera.micro.consumer.model.User;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by hanghang on 2019/9/9.
 */
@Repository
@Slf4j
public class UserDao {
    @Autowired
    private DiscoveryClient discoveryClient;//Eureka客户端，可以获取服务实例
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "queryUserByIdFallback")
    public User queryUserById(Long id) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        String baseUrl = "http://user-service-producer/api/user/";
        User user = restTemplate.getForObject(baseUrl + id, User.class);
        stopWatch.stop();
        log.info("query id {} cost time {} ms", id, stopWatch.getTotalTimeMillis());
        return user;
    }

    public User queryUserByIdFallback(Long id) {
        log.info("invoke query user by id {}", id);
        User user = new User();
        user.setId(id);
        user.setName("用户信息查询出现异常");
        return user;
    }
}
