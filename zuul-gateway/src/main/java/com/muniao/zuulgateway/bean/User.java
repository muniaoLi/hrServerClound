package com.muniao.zuulgateway.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.muniao.zuulgateway.vo.NationPO;
import com.muniao.zuulgateway.vo.RolePO;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class User implements UserDetails, Serializable
{
    private Integer id;
    private String username;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private Boolean enabled;
    @JsonIgnore
    private Boolean locked;
    private List<RolePO> roles;
    private NationPO nation;

    //该登录用的角色
    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (RolePO role : roles)
            authorities.add(new SimpleGrantedAuthority(role.getName()));

        return authorities;
    }

    @JsonIgnore
    //当前账号是否未过期
    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @JsonIgnore
    //当前账号是否未锁定
    @Override
    public boolean isAccountNonLocked()
    {
        return !locked;
    }

    @JsonIgnore
    //当前密码是否未过期
    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @JsonIgnore
    //当前账号是否可用
    @Override
    public boolean isEnabled()
    {
        return enabled;
    }
}
