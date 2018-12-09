package com.csu.rabbitmq.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Create by @author BG331145 杨威 on 2018/12/7 0007 - 20:48
 */
@Configuration
public class RabbitConfig {
    
    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }
}
