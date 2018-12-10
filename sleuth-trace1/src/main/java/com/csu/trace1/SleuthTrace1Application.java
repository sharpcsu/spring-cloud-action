package com.csu.trace1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class SleuthTrace1Application {
    
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
    public static void main(String[] args) {
        SpringApplication.run(SleuthTrace1Application.class, args);
    }
    
    @RequestMapping(value = "trace-1", method = RequestMethod.GET)
    public String trade() {
        log.error("sharp ==========trace -1 ===========");
        return restTemplate().getForEntity("http://sleuth-trace2/trace-2", String.class).getBody();
    }
}
