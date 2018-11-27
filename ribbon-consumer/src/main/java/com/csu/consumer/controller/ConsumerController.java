package com.csu.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Create by @author BG331145 杨威 on 2018/11/25 0025 - 20:27
 */
@RestController
public class ConsumerController {
    
    @Autowired
    private RestTemplate restTemplate;
    
    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String ribbonConsumer() {
        ResponseEntity<String> entity = restTemplate.getForEntity("http://EUREKA-PROVIDER/hello", String.class);
        return entity.getBody();
    }
}
