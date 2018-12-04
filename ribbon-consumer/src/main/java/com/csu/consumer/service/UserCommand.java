package com.csu.consumer.service;

import com.netflix.hystrix.HystrixCommand;

import org.springframework.web.client.RestTemplate;

/**
 * 创建请求命令
 * Create by @author BG331145 杨威 on 2018/12/3 0003 - 21:32
 */
public class UserCommand extends HystrixCommand<User> {
    
    private RestTemplate restTemplate;
    private Long id;
    
    public UserCommand(Setter setter, RestTemplate restTemplate, Long id) {
        super(setter);
        this.restTemplate = restTemplate;
        this.id = id;
    }
    
    @Override
    protected User run() throws Exception {
        return restTemplate.getForObject("http://EUREKA-PROVIDER/users{1}", User.class, id);
    }
}
