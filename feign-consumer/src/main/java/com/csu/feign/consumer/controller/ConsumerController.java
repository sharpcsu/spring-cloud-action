package com.csu.feign.consumer.controller;

import com.csu.feign.consumer.service.HelloService;
import com.csu.feign.consumer.web.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Create by @author BG331145 杨威 on 2018/12/4 0004 - 20:16
 */
@RestController
public class ConsumerController {
    
    @Resource
    private HelloService helloService;
    
    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.hello();
    }
    
    @RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
    public String helloConsumer2() {
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello("didi")).append("\n");
        sb.append(helloService.hello("didi", 30)).append("\n");
        sb.append(helloService.hello(new User("didi", 30))).append("\n");
        
        return sb.toString();
    }
    
    
    
}
