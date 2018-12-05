package com.csu.feign.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Create by @author BG331145 杨威 on 2018/12/4 0004 - 20:39
 */
@FeignClient(value = "HELLO-SERVICE")
public interface RefactorHelloService extends com.service.api.service.HelloService {
}
