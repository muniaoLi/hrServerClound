package com.muniao.userserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class HelloController
{
    @RequestMapping("/hello")
    public String hello()
    {
        return "hello user";
    }
}
