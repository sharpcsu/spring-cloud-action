package com.csu.consumer.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import javax.annotation.Resource;

/**
 * 请求合并
 * Create by @author BG331145 杨威 on 2018/12/3 0003 - 22:03
 */
public class UserServiceCollapserImpl implements UserService {
    
    @Resource
    private RestTemplate restTemplate;
    
    @Override
    public User find(Long id) {
        return restTemplate.getForObject("http://USER-SERVICE/users{1}", User.class, id);
    }
    
    @Override
    public List<User> findAll(List<Long> ids) {
        return restTemplate.getForObject("http://USER-SERVICE/users?ids={1}", List.class, StringUtils.join(ids, ","));
    }
}
