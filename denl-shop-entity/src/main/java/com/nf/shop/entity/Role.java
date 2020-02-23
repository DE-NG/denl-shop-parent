package com.nf.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:DENG-
 * @Date:2019/12/29 20:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    /*角色id*/
    private Integer id;
    /*角色名称*/
    private String roleName;
}
