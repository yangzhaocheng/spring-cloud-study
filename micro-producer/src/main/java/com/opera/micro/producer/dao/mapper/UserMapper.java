package com.opera.micro.producer.dao.mapper;

import org.springframework.stereotype.Repository;

import com.opera.micro.producer.model.User;

import tk.mybatis.mapper.common.Mapper;

/**
 * Created by hanghang on 2019/9/9.
 */
@Repository
@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {
}
