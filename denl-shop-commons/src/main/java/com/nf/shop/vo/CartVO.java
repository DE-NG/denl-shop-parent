package com.nf.shop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author DENG-
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartVO {

    /*购物车主键id*/
    private Integer id;
    /*客户id*/
    private Integer customerId;
    /*商品的id*/
    private Integer productId;
    /*商品数量*/
    private Integer productNum;
    /*商品总价*/
    private Double totalPrice;
}
