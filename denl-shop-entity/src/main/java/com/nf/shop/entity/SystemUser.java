package com.nf.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author:DENG-
 * @Date:2019/12/29 20:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemUser {
    /*主键id*/
    private Integer id;
    /*登录名*/
    private String loginName;
    /*登录密码*/
    private String password;
    /*手机号*/
    private String phone;
    /*用户邮箱*/
    private String email;
    /*是否禁用 0 表示禁用 1 表示 启用*/
    private Integer isValid;
    /*用户创建时间*/
    private Date createDate;
    /*角色*//*这里也直接可以放 角色id*/
    private Role role;
}
