package com.csu.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import lombok.extern.slf4j.Slf4j;

/**
 * Create by @author BG331145 杨威 on 2018/12/9 0009 - 21:07
 */
@Slf4j
@EnableBinding(Sink.class)
public class SinkReceiver {
    
    @StreamListener(Sink.INPUT)
    public void receiver(Object payload) {
        log.error("sharp Received：" + payload);
    }
}
