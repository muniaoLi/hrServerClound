package com.muniao.securityserver;

import com.muniao.securityserver.mapper.MenuMapper;
import com.muniao.securityserver.po.MenuPO;
import com.muniao.securityserver.po.UserPO;
import com.muniao.securityserver.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = SecurityServerApplication.class)
class SecurityServerApplicationTests
{
    @Autowired
    MenuMapper menuMapper;

    @Test
    void test1()
    {
        List<MenuPO> list =  menuMapper.findAllMenu();
        System.out.println(list);
    }

    @Autowired
    UserService userService;
    @Test
    void test2()
    {
        UserPO userPO = userService.findUserByName("lixp");
        System.out.println(userPO);
    }

}
