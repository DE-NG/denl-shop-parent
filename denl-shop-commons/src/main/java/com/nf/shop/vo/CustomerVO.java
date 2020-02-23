package com.nf.shop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: 客户 vo类
 * @author DENG-
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerVO {

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

}
