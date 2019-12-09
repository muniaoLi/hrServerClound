package com.muniao.securityserver.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class RolePO implements Serializable
{
    private Integer id;

    private String name;

    private String nameZh;

}
