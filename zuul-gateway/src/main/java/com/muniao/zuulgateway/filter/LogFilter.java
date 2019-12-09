package com.muniao.zuulgateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

@Slf4j
public class LogFilter extends ZuulFilter
{
    @Override
    public String filterType()
    {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder()
    {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter()
    {
        return true;
    }

    @Override
    public Object run() throws ZuulException
    {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        //访问路径
        String url = request.getRequestURL().toString();
        log.info("url:"+url);

        System.out.println("sessionId:"+request.getSession().getId());
        return null;
    }
}
