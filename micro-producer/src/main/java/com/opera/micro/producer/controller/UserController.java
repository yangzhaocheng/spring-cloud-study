package com.opera.micro.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opera.micro.producer.model.User;
import com.opera.micro.producer.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by hanghang on 2019/9/9.
 */
@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        User user = userService.queryById(id);
        stopWatch.stop();
        log.info("invoke user service cost {} ms", stopWatch.getTotalTimeMillis());
        return user;
    }

}
