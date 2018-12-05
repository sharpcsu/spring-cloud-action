package com.csu.feign.consumer.service;

import com.csu.feign.consumer.web.User;

import org.springframework.stereotype.Service;

/**
 * Create by @author BG331145 杨威 on 2018/12/5 0005 - 20:42
 */
@Service
public class HelloServiceFallback implements HelloService {
    @Override
    public String hello() {
        return "error";
    }
    
    @Override
    public String hello(String name) {
        return "error：" + name;
    }
    
    @Override
    public String hello(String name, Integer age) {
        return "error：name = " + name + "；age = " + age;
    }
    
    @Override
    public String hello(User user) {
        return "error：" + user.toString();
    }
}
