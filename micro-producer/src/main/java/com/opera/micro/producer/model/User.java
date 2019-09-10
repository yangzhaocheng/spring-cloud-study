package com.opera.micro.producer.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Created by hanghang on 2019/9/9.
 */
@Table(name = "user")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    // 密码
    private String password;

    // 姓名
    private String name;


    // 性别，1男性，2女性
    private String gender;

    // 电话号码
    private String phoneNumber;

    // 国家
    private String country;

    // 语言
    private String language;

    // 备注
    private String remark;
}
