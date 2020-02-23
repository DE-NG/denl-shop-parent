package com.nf.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author: DENG-
 * Description: 商品实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable{

    /*商品id*/
    private Integer id;
    /*商品名称*/
    private String name;
    /*商品价格*/
    private Double price;
    /*商品简介*/
    private String info;
    /*商品的图片*/
    private String image;
    /*商品类型*/
    private ProductType productType;

    public Product(String name, Double price, String info, String image, ProductType productType) {
        this.name = name;
        this.price = price;
        this.info = info;
        this.image = image;
        this.productType = productType;
    }
}
