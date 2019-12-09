package com.muniao.zuulgateway.config;

import com.muniao.zuulgateway.service.MenuService;
import com.muniao.zuulgateway.vo.MenuPO;
import com.muniao.zuulgateway.vo.RolePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

@Component
public class CustomMetadataSource implements FilterInvocationSecurityMetadataSource
{
    @Autowired
    MenuService menuService;
    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o)
    {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        List<MenuPO> allMenu = menuService.findAllMenu();
        for (MenuPO menu : allMenu)
        {
            if (antPathMatcher.match(menu.getPattern(), requestUrl)
                    && menu.getRoles().size() > 0)
            {
                List<RolePO> roles = menu.getRoles();
                int size = roles.size();
                String[] values = new String[size];
                for (int i = 0; i < size; i++)
                {
                    values[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(values);
            }
        }
        //没有匹配上的资源，都是登录访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes()
    {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass)
    {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
