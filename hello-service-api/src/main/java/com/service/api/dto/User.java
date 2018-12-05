package com.service.api.dto;

/**
 * Create by @author BG331145 杨威 on 2018/12/4 0004 - 20:34
 */
public class User {
    private String name;
    private Integer age;
    
    public User() {
    }
    
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
}
