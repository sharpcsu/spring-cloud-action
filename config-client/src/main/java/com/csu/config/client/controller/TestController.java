package com.csu.config.client.controller;

import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Create by @author BG331145 杨威 on 2018/12/6 0006 - 19:25
 */
@RefreshScope
@RestController
public class TestController {
    
////    @Value("${from}")
//    private String from;
    
    @Resource
    private Environment environment;
    
    @RequestMapping("/from")
    public String getFrom() {
        return environment.toString();
    }
}
