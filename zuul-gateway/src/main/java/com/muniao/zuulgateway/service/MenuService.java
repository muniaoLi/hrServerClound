package com.muniao.zuulgateway.service;

import com.muniao.zuulgateway.bean.RespBean;
import com.muniao.zuulgateway.vo.MenuPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "menus_cache")
public class MenuService
{
    @Autowired
    SecurityRemoteService securityRemoteService;

    @Cacheable(key = "#root.methodName")
    public List<MenuPO> findAllMenu(){
        RespBean<List<MenuPO>> respBean = securityRemoteService.findAllMenu();
        //TODO
        List<MenuPO> menus = respBean.getObj();
        System.out.println(menus);
        return menus;
    }
}
