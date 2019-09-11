package com.opera.micro.consumer.dao.client;

import org.springframework.stereotype.Component;

import com.opera.micro.consumer.model.User;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by hanghang on 2019/9/11.
 */
@Slf4j
@Component
public class UserFeignClientFallback implements UserFeignClient {
    @Override
    public User queryUserById(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("用户信息查询出现异常");
        log.info("invoke feign client fail,query user by id {} ", id);
        return user;
    }
}
