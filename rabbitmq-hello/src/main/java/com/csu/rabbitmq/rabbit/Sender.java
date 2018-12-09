package com.csu.rabbitmq.rabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

import javax.annotation.Resource;

/**
 * Create by @author BG331145 杨威 on 2018/12/7 0007 - 20:42
 */
@Component
public class Sender {
    
    @Resource
    private AmqpTemplate rabbitTemplate;
    
    public void send() {
        String context = "Eden hello " + new Date();
        System.out.println("sharp  " + context);
        rabbitTemplate.convertAndSend("hello", context);
    }
}
