package com.csu.consumer.service;

import com.netflix.hystrix.HystrixCommand;

import java.util.List;

import static com.netflix.hystrix.HystrixCommandGroupKey.Factory.asKey;

/**
 * 批量请求命令
 * Create by @author BG331145 杨威 on 2018/12/3 0003 - 22:09
 */
public class UserBatchCommand extends HystrixCommand<List<User>> {
    
    private UserService userService;
    private List<Long> userIds;
    
    public UserBatchCommand(UserService userService, List<Long> userIds) {
        super(Setter.withGroupKey(asKey("userServiceCommand")));
        this.userService = userService;
        this.userIds = userIds;
    }
    
    @Override
    protected List<User> run() throws Exception {
        return userService.findAll(userIds);
    }
}
