package com.nf.shop.vo;

import com.nf.shop.entity.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author DENG-
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductVO {
    /*商品id*/
    private Integer id;
    /*商品名称*/
    private String name;
    /*商品价格*/
    private Double price;
    /*商品简介*/
    private String info;
    /*商品的图片*/
    private MultipartFile multipartFile;

    private String image;
    /*商品类型*/
    private Integer productTypeId;

    private Integer pageNum;

    public ProductVO(String name, Double price, String info, String image, Integer productTypeId) {
        this.name = name;
        this.price = price;
        this.info = info;
        this.image = image;
        this.productTypeId = productTypeId;
    }

    public ProductVO(String name, Double price, String info, Integer productTypeId) {
        this.name = name;
        this.price = price;
        this.info = info;
        this.productTypeId = productTypeId;
    }

    public ProductVO(Integer id, String name, Double price, String info, String image, Integer productTypeId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.info = info;
        this.image = image;
        this.productTypeId = productTypeId;
    }

    public ProductVO(Integer id, String name, Double price, String info, Integer productTypeId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.info = info;
        this.productTypeId = productTypeId;
    }
}
