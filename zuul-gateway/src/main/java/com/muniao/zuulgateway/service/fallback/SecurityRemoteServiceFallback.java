package com.muniao.zuulgateway.service.fallback;

import com.muniao.zuulgateway.bean.RespBean;
import com.muniao.zuulgateway.service.SecurityRemoteService;
import com.muniao.zuulgateway.vo.MenuPO;
import com.muniao.zuulgateway.vo.UserPO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SecurityRemoteServiceFallback implements SecurityRemoteService
{
    @Override
    public RespBean<List<MenuPO>> findAllMenu()
    {
        return RespBean.error("安全服务中断，security-server:findAllMenu 调用失败！");
    }

    @Override
    public RespBean<UserPO> findUserByName(String username)
    {
        return RespBean.error("安全服务中断，security-server:findUserByName 调用失败！");
    }
}
