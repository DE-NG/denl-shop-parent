package com.nf.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author:DENG-
 * @Date:2019/12/9 15:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    /*主键id*/
    private Integer id;
    /*用户登录账户名*/
    private String loginName;
    /*用户密码*/
    private String password;
    //*用户手机号*/
    private String phone;
    /*用户地址*/
    private String address;
    /*用户状态*/
    private Integer isValid;
    /*用户注册时间*/
    private Date registDate;
    /*用户头像*/
    private String images;

    public Customer(String loginName, String password, String phone, String address, Integer isValid, Date registDate,String images) {
        this.loginName = loginName;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.isValid = isValid;
        this.registDate = registDate;
        this.images = images;
    }

    public Customer(String loginName, String password, String phone, String address, Integer isValid, Date registDate) {
        this.loginName = loginName;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.isValid = isValid;
        this.registDate = registDate;
    }

    public Customer(String images,String loginName, String phone, String address,Integer id) {
        this.id = id;
        this.loginName = loginName;
        this.phone = phone;
        this.address = address;
        this.images = images;
    }

    public Customer(String loginName, String phone, String address, Integer customerId) {
        this.loginName=loginName;
        this.phone=phone;
        this.address=address;
        this.id=customerId;
    }

    public Customer(Integer id, String phone, String address) {
        this.id = id;
        this.phone = phone;
        this.address = address;
    }
}
