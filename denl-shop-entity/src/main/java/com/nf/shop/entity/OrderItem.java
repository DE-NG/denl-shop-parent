package com.nf.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:DENG-
 * @Date:2019/12/12 9:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    /*订单类目id*/
    private Integer id;
    /*商品数量*/
    private Integer num;
    /*商品小计*/
    private Double price;
    /*商品对象*/
    private Product product;
    /*所属于哪个订单，订单对象*/
    private Order order;
}
