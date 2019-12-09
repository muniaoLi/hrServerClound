package com.muniao.securityserver.service;

import com.muniao.securityserver.mapper.UserMapper;
import com.muniao.securityserver.po.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService
{
    @Autowired
    UserMapper userMapper;

    public UserPO findUserByName(String username)
    {
        return userMapper.findUserByName(username);
    }
}
