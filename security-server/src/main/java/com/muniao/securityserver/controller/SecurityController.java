package com.muniao.securityserver.controller;

import com.muniao.securityserver.bean.RespBean;
import com.muniao.securityserver.po.MenuPO;
import com.muniao.securityserver.po.UserPO;
import com.muniao.securityserver.service.MenuService;
import com.muniao.securityserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/security")
public class SecurityController
{
    @Autowired
    MenuService menuService;

    @RequestMapping("/findAllMenu")
    public RespBean<List<MenuPO>> findAllMenu()
    {
        List<MenuPO> allMenus = menuService.findAllMenu();

        return RespBean.ok("success", allMenus);
    }

    @Autowired
    UserService userService;

    @RequestMapping("/findUserByName")
    public RespBean<UserPO> findUserByName(@RequestBody String username)
    {
        UserPO user = userService.findUserByName(username);
        return RespBean.ok("success", user);
    }
}
