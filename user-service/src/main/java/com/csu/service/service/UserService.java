package com.csu.service.service;

import org.apache.catalina.User;

import java.util.List;

/**
 * Create by @author BG331145 杨威 on 2018/12/3 0003 - 21:57
 */
public interface UserService {
    
    User find(Long id);
    
    List<User> findAll(List<Long> ids);
}
