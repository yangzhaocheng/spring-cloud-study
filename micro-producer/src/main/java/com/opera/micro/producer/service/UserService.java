package com.opera.micro.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opera.micro.producer.dao.mapper.UserMapper;
import com.opera.micro.producer.model.User;

/**
 * Created by hanghang on 2019/9/9.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User queryById(Long id){
        return  userMapper.selectByPrimaryKey(id);
    }
}
