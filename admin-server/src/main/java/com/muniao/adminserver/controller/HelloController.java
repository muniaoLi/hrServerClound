package com.muniao.adminserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class HelloController
{
    @RequestMapping("/hello")
    public String hello()
    {
        return "hello admin";
    }
}
