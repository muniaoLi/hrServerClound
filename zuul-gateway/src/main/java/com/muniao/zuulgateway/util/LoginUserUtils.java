package com.muniao.zuulgateway.util;

import com.muniao.zuulgateway.bean.User;
import org.springframework.security.core.context.SecurityContextHolder;


public class LoginUserUtils
{
    public static User getCurrentUser()
    {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
