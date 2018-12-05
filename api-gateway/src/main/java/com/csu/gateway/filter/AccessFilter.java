package com.csu.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

/**
 * 自定义过滤器
 * Create by @author BG331145 杨威 on 2018/12/5 0005 - 21:29
 */
@Slf4j
public class AccessFilter extends ZuulFilter {
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
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        
        log.error("sharp send {} request to {}", request.getMethod(), request.getRequestURL().toString());
    
        String accessToken = request.getParameter("accessToken");
    
        if (Objects.isNull(accessToken)) {
            log.error("sharp access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
    
        log.error("sharp access token ok");
        return null;
    }
}
