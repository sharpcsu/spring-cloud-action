package com.csu.consumer.service;

import java.util.List;

/**
 * Create by @author BG331145 杨威 on 2018/12/3 0003 - 22:02
 */
public interface UserService {
    User find(Long id);
    
    List<User> findAll(List<Long> ids);
}
