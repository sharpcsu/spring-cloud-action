package com.csu.gateway;

import com.csu.gateway.filter.AccessFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Spring Cloud Zuul API网关服务
 * @author 杨威
 */
@EnableZuulProxy
@SpringCloudApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
    
    /**
     * 启动过滤器
     */
    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}
