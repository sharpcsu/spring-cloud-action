package com.csu.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

import javax.annotation.Resource;

/**
 * 注解方式实现Hystrix命令
 * Create by @author BG331145 杨威 on 2018/12/3 0003 - 21:39
 */
public class UserServiceHystrixCommand {
    
    @Resource
    private RestTemplate restTemplate;
    
    @HystrixCommand
    public User getUserById(Long id) {
        return restTemplate.getForObject("http://EUREKA-PROVIDER/users/{1}", User.class, id);
    }
    
}
