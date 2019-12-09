package com.muniao.securityserver.mapper;

import com.muniao.securityserver.po.UserPO;
import org.springframework.data.repository.query.Param;

public interface UserMapper
{
    UserPO findUserByName( @Param("username")String username);
}
