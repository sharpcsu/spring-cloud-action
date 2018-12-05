package com.csu.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by @author BG331145 杨威 on 2018/12/5 0005 - 21:36
 */
@RestController
public class HelloController {
    
    @RequestMapping("/local/hello")
    public String hello() {
        return "hello world Local";
    }
}
