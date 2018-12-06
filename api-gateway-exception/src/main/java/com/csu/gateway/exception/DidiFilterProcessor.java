package com.csu.gateway.exception;

import com.netflix.zuul.FilterProcessor;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * 拦截处理器
 * Create by @author BG331145 杨威 on 2018/12/5 0005 - 22:09
 */
public class DidiFilterProcessor extends FilterProcessor {
    @Override
    public Object processZuulFilter(ZuulFilter filter) throws ZuulException {
        try {
            return super.processZuulFilter(filter);
        } catch (ZuulException e) {
            RequestContext ctx = RequestContext.getCurrentContext();
            ctx.set("failed.exception", e);
            ctx.set("failed.filter", filter);
            throw e;
        }
    }
}
