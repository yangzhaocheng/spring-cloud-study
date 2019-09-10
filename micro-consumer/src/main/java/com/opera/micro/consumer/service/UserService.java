package com.opera.micro.consumer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opera.micro.consumer.dao.rest.UserDao;
import com.opera.micro.consumer.model.User;

/**
 * Created by hanghang on 2019/9/9.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> queryUsers(List<Long> ids) {
        return userDao.queryUserByIds(ids);
    }
}
