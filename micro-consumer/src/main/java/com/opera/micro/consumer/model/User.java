package com.opera.micro.consumer.model;

import java.io.Serializable;



import lombok.Data;

/**
 * Created by hanghang on 2019/9/9.
 */
@Data
public class User implements Serializable {


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
