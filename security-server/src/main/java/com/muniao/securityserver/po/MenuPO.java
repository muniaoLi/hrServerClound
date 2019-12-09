package com.muniao.securityserver.po;

import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data
public class MenuPO implements Serializable
{
    private Integer id;
    private String pattern;
    private List<RolePO> roles;

}
