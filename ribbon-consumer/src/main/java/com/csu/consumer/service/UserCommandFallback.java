package com.csu.consumer.service;

import com.netflix.hystrix.HystrixCommand;

import org.springframework.web.client.RestTemplate;

/**
 * 定义服务降级
 * Create by @author BG331145 杨威 on 2018/12/3 0003 - 21:46
 */
public class UserCommandFallback extends HystrixCommand<User> {
    
    private RestTemplate restTemplate;
    private Long id;
    
    public UserCommandFallback(Setter setter, RestTemplate restTemplate, Long id) {
        super(setter);
        this.restTemplate = restTemplate;
        this.id = id;
    }
    
    @Override
    protected User run() throws Exception {
        return restTemplate.getForObject("http://EUREKA-PROVIDER/users/{1}", User.class, id);
    }
    
    @Override
    protected User getFallback() {
        return new User();
    }
}
