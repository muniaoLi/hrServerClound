package com.muniao.zuulgateway.service;

import com.muniao.zuulgateway.bean.RespBean;
import com.muniao.zuulgateway.service.fallback.SecurityRemoteServiceFallback;
import com.muniao.zuulgateway.vo.MenuPO;
import com.muniao.zuulgateway.vo.UserPO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name= "security-server",
        fallback = SecurityRemoteServiceFallback.class)
public interface SecurityRemoteService
{

    @RequestMapping("/security/findAllMenu")
    RespBean<List<MenuPO>> findAllMenu();

    @RequestMapping("/security/findUserByName")
    RespBean<UserPO> findUserByName(@RequestBody String username);
}
