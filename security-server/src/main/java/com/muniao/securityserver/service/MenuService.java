package com.muniao.securityserver.service;

import com.muniao.securityserver.mapper.MenuMapper;
import com.muniao.securityserver.po.MenuPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@CacheConfig(cacheNames = "menus_cache")
public class MenuService
{
    @Autowired
    MenuMapper menuMapper;

    @Cacheable(key = "#root.methodName")
    public List<MenuPO> findAllMenu()
    {
        return menuMapper.findAllMenu();
    }
}
