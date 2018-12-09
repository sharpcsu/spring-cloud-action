package com.csu.rabbitmq.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Create by @author BG331145 杨威 on 2018/12/7 0007 - 20:46
 */
@Component
@RabbitListener(queues = "hello")
public class Receiver {
    
    @RabbitHandler
    public void process(String hello) {
        System.out.println("sharp Receiver " + hello);
    }
}
