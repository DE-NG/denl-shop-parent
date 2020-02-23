package com.nf.shop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: 收货地址vo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingVO {
    /*id*/
    private Integer id;
    /*收货人姓名*/
    private String receiverName;
    /*收货人的手机号码*/
    private String receiverMobile;
    /*省份名称*/
    private String receiverProvince;
    /*城市名称*/
    private String receiverCity;
    /*区 县*/
    private String receiverDistrict;
    /*详细地址内容*/
    private String addressDetail;
}
