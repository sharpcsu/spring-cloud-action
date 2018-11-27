package com.csu.provider.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

/**
 * Create by @author BG331145 杨威 on 2018/11/25 0025 - 20:13
 */
@Slf4j
@RestController
public class ProviderController {
    
    @Resource
    private DiscoveryClient client;
    
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        ServiceInstance instance = client.getLocalServiceInstance();
        log.error("/hello,host:" + instance.getHost() + ",service_id:" + instance.getServiceId());
    
        return "hello world";
    }
}
