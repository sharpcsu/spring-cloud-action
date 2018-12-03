package com.csu.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Create by @author BG331145 杨威 on 2018/11/27 0027 - 22:08
 */
@Service
public class ConsumerService {
    
    @Autowired
    private RestTemplate restTemplate;
    
    @HystrixCommand(fallbackMethod = "helloFallback") //指定回调方法
    public String helloService() {
        return restTemplate.getForEntity("http://EUREKA-PROVIDER/hello", String.class).getBody();
    }
    
    /**
     * 回调方法
     */
    public String helloFallback() {
        return "error";
    }
}
