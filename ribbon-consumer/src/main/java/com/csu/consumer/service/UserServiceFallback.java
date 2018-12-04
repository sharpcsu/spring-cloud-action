package com.csu.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 定义服务降级
 * Create by @author BG331145 杨威 on 2018/12/3 0003 - 21:46
 */
public class UserServiceFallback {
    
    @Resource
    private RestTemplate restTemplate;
    
    @HystrixCommand(fallbackMethod = "defaultUser")
    public User getUserById(Long id) {
        return restTemplate.getForObject("http://EUREKA-PROVIDER/users/{1}", User.class, id);
    }
    
    public User defaultUser() {
        return new User();
    }
}
