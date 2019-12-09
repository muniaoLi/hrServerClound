package com.muniao.zuulgateway.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class UserPO implements Serializable
{
    private Integer id;
    private String username;
    private String password;
    private Boolean enabled;
    private Boolean locked;
    private List<RolePO> roles;
    private NationPO nation;
}
