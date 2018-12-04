package com.csu.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import javax.annotation.Resource;

/**
 * 注解实现请求合并器
 * Create by @author BG331145 杨威 on 2018/12/3 0003 - 22:31
 */
public class UserServiceCollapserAnno {
    
    @Resource
    private RestTemplate restTemplate;
    
    @HystrixCollapser(batchMethod = "findAll", collapserProperties = {
            @HystrixProperty(name = "timeDelayInMilliseconds", value = "100")
    })
    public User find(Long id) {
        return null;
    }
    
    @HystrixCommand
    public List<User> findAll(List<Long> ids) {
        return restTemplate.getForObject("http://USER-SERVICE/users?ids={1}", List.class, StringUtils.join(ids, ","));
    }
}
