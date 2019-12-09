package com.muniao.zuulgateway.controller;

import com.muniao.zuulgateway.bean.RespBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController
{
    @RequestMapping("/login_p")
    public RespBean login()
    {
        return RespBean.error("尚未登录，请登录!");
    }
}
