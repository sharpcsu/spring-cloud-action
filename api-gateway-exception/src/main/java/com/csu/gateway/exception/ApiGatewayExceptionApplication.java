package com.csu.gateway.exception;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringCloudApplication
public class ApiGatewayExceptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayExceptionApplication.class, args);
    }
    
    @Bean
    public DefaultErrorAttributes errorAttributes() {
        return new DidiErrorAttributes();
    }
}
