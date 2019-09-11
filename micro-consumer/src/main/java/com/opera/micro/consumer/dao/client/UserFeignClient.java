package com.opera.micro.consumer.dao.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.opera.micro.consumer.model.User;

/**
 * Created by hanghang on 2019/9/11.
 */
@FeignClient(value = "user-service-producer", fallback = UserFeignClientFallback.class, configuration = FeignConfig.class)
public interface UserFeignClient {
    @GetMapping("/api/user/{id}")
    User queryUserById(@PathVariable("id") Long id);
}
