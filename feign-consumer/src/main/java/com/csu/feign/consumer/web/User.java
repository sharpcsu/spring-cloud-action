package com.csu.feign.consumer.web;

import lombok.ToString;

/**
 * Create by @author BG331145 杨威 on 2018/12/4 0004 - 20:19
 */
@ToString
public class User {
    private String name;
    private Integer age;
    
    public User() {
    }
    
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    
}
