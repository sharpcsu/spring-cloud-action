package com.csu.consumer.service;

import com.netflix.hystrix.HystrixCollapser;
import com.netflix.hystrix.HystrixCollapserKey;
import com.netflix.hystrix.HystrixCollapserProperties;
import com.netflix.hystrix.HystrixCommand;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 实现请求合并器
 * Create by @author BG331145 杨威 on 2018/12/3 0003 - 22:13
 */
public class UserCollapseCommand extends HystrixCollapser<List<User>, User, Long> {
    
    private UserService userService;
    private Long userId;
    
    public UserCollapseCommand(UserService userService, Long userId) {
        super(Setter.withCollapserKey(HystrixCollapserKey.Factory.asKey("userCollapseCommand")).andCollapserPropertiesDefaults(
                HystrixCollapserProperties.Setter().withTimerDelayInMilliseconds(1000)));
        this.userService = userService;
        this.userId = userId;
    }
    
    /**
     * 获取请求参数
     */
    @Override
    public Long getRequestArgument() {
        return userId;
    }
    
    /**
     * 合并请求产生批量命令的具体实现方法
     */
    @Override
    protected HystrixCommand<List<User>> createCommand(Collection<CollapsedRequest<User, Long>> collapsedRequests) {
        List<Long> userIds = new ArrayList<>(collapsedRequests.size());
        userIds.addAll(collapsedRequests.stream().map(CollapsedRequest::getArgument).collect(Collectors.toList()));
        return new UserBatchCommand(userService, userIds);
    }
    
    /**
     * 批量命令结果返回后的处理
     */
    @Override
    protected void mapResponseToRequests(List<User> batchResponse, Collection<CollapsedRequest<User, Long>> collapsedRequests) {
        int count = 0;
        for (CollapsedRequest<User, Long> collapsedRequest : collapsedRequests) {
            User user = batchResponse.get(count++);
            collapsedRequest.setResponse(user);
        }
    }
}
