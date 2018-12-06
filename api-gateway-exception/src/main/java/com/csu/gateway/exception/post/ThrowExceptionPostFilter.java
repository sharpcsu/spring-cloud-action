package com.csu.gateway.exception.post;

import com.netflix.zuul.ZuulFilter;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * Create by @author BG331145 杨威 on 2018/12/5 0005 - 22:14
 */
@Slf4j
@Component
public class ThrowExceptionPostFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "post";
    }
    
    @Override
    public int filterOrder() {
        return 10;
    }
    
    @Override
    public boolean shouldFilter() {
        return true;
    }
    
    @Override
    public Object run() {
        doSomething();
        return null;
    }
    
    public void doSomething() {
        throw new RuntimeException("出现了一些错误 post");
    }
}
