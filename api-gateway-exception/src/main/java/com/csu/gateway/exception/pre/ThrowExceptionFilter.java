package com.csu.gateway.exception.pre;

import com.netflix.zuul.ZuulFilter;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * pre类型的过滤器抛出一个异常
 * Create by @author BG331145 杨威 on 2018/12/5 0005 - 21:50
 */
@Slf4j
@Component
public class ThrowExceptionFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }
    
    @Override
    public int filterOrder() {
        return 0;
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
    
    private void doSomething() {
        throw new RuntimeException("出现了一些错误");
    }
}
