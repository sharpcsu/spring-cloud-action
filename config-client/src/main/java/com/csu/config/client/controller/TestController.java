package com.csu.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by @author BG331145 杨威 on 2018/12/6 0006 - 19:25
 */
//@RefreshScope
@RestController
public class TestController {
    
//    @Value("${from}")
//    private String from;
    
    @RequestMapping("/from")
    public String getFrom() {
//        return this.from;
        return "sharp";
    }
}
