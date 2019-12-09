package com.muniao.zuulgateway.service;

import com.muniao.zuulgateway.bean.RespBean;
import com.muniao.zuulgateway.bean.User;
import com.muniao.zuulgateway.vo.UserPO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService
{
    @Autowired
    SecurityRemoteService securityRemoteService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        RespBean<UserPO> respBean = securityRemoteService.findUserByName(username);
        UserPO po = respBean.getObj();
        User user = new User();
        BeanUtils.copyProperties(po,user);
        System.out.println(user);
        return user;
    }
}
