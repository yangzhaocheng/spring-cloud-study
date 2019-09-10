package com.opera.micro.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.opera.micro.consumer.model.User;
import com.opera.micro.consumer.service.UserService;


/**
 * Created by hanghang on 2019/9/9.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public List<User> queryById(@RequestParam("user_ids") List<Long> ids){
        return userService.queryUsers(ids);
    }

}
