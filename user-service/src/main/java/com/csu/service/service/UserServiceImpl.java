package com.csu.service.service;

import org.apache.catalina.User;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import javax.annotation.Resource;

/**
 * Create by @author BG331145 杨威 on 2018/12/3 0003 - 21:59
 */
public class UserServiceImpl implements UserService {
    
    @Resource
    private RestTemplate restTemplate;
    
    @Override
    public User find(Long id) {
        return null;
    }
    
    @Override
    public List<User> findAll(List<Long> ids) {
        return null;
    }
}
