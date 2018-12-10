package com.csu.trace2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class SleuthTrace2Application {

    public static void main(String[] args) {
        SpringApplication.run(SleuthTrace2Application.class, args);
    }
    
    @RequestMapping(value = "trace-2", method = RequestMethod.GET)
    public String trace(HttpServletRequest request) {
        log.error("sharp =============call trace-2, TradeId={}, SpanId={}===========",
                request.getHeader("X-B3-TraceId"), request.getHeader("X-B3-SpanId"));
        
        return "Trace";
    }
}
