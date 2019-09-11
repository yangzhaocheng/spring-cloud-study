package com.opera.micro.consumer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import com.opera.micro.consumer.dao.client.UserFeignClient;
import com.opera.micro.consumer.dao.rest.UserRestClient;
import com.opera.micro.consumer.model.User;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by hanghang on 2019/9/9.
 */
@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRestClient userRestClient;
    @Autowired
    private UserFeignClient userFeignClient;

    public List<User> queryUsers(List<Long> ids) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<User> users = new ArrayList<>();
        ids.forEach(id -> {
            if (id % 2 == 0) {
                users.add(userRestClient.queryUserById(id));
            } else {
                Long start=System.currentTimeMillis();
                users.add(userFeignClient.queryUserById(id));
                Long end=System.currentTimeMillis();
                log.info("query id {} cost time {} ms", id,end-start);
            }
        });
        stopWatch.stop();
        log.info("query all time cost {} ms", stopWatch.getTotalTimeMillis());
        return users;
    }
}
