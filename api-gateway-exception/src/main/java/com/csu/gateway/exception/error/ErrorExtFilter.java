package com.csu.gateway.exception.error;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.stereotype.Component;

/**
 * Create by @author BG331145 杨威 on 2018/12/5 0005 - 22:02
 */
@Component
public class ErrorExtFilter extends SendErrorFilter {
    
    @Override
    public String filterType() {
        return "error";
    }
    
    @Override
    public int filterOrder() {
        return 30; //大于ErrorFilter的值
    }
    
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        ZuulFilter failedFilter = (ZuulFilter) ctx.get("failed.filter");
        if (failedFilter != null && failedFilter.filterType().equals("post")) {
            return true;
        }
        
        return false;
    }
}
