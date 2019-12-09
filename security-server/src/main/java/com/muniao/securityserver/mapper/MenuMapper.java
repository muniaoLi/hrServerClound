package com.muniao.securityserver.mapper;

import com.muniao.securityserver.po.MenuPO;

import java.util.List;

public interface MenuMapper
{

    List<MenuPO> findAllMenu();
}
