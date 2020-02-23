package com.nf.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * 购物车类
 * @author DENG-
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cart {

    /*购物车主键id*/
    private Integer id;
    /*客户id*/
    private Integer customerId;
    /*商品对象*/
    private Product product;
    /*商品数量*/
    private Integer productNum;
    /*商品加入购物车的时间*/
    private Date createTime;
    /*商品总价*/
    private Double totalPrice;
    private Integer status;
}
