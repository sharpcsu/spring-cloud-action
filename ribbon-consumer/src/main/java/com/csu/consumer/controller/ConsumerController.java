package com.csu.consumer.controller;

import com.csu.consumer.service.ConsumerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by @author BG331145 杨威 on 2018/11/25 0025 - 20:27
 */
@RestController
public class ConsumerController {
    
    @Autowired
    private ConsumerService consumerService;
    
    
    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String ribbonConsumer() {
        return consumerService.helloService();
    }
}
