package com.opera.micro.consumer.dao.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
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

    public List<User> queryUserByIds(List<Long> ids) {
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();
        List<User> users = new ArrayList<>();
        List<ServiceInstance> instances = discoveryClient.getInstances("user-service-producer");
        ServiceInstance instance= instances.size() > 0 ? instances.get(0) : null;
        if (instance == null) {
            return Collections.emptyList();
        }
        String baseUrl = "http://" + instance.getHost() + ":" + instance.getPort() + "/api/user/";
        ids.forEach(id -> {
            users.add(restTemplate.getForObject(baseUrl+id, User.class));
//            // 每次间隔500毫秒
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        });
        stopWatch.stop();
        log.info("query time cost{} ms",stopWatch.getTotalTimeMillis());
        return users;
    }
}