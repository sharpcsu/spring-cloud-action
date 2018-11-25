package com.csu.eurekaclient.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import groovy.util.logging.Log4j;

/**
 * Create by @author BG331145 杨威 on 2018/11/25 0025 - 19:06
 */
@Log4j
@RestController
public class ClientController {
   
    @Resource
    private DiscoveryClient discoveryClient;
    
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String index() {
        ServiceInstance instance = discoveryClient.getLocalServiceInstance();
//        log.error("sharp ");
    
        return "hello world";
    }
}
