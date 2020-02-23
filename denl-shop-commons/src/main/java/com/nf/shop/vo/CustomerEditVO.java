package com.nf.shop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


/**
 * @Author:DENG-
 * @Date:2019/12/18 10:22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEditVO {

    private Integer customerId;

    private String loginName;
    //*用户手机号*/
    private String phone;
    /*用户地址*/
    private String address;
    /*用户头像*/
    private MultipartFile multipartFile;

    private String oldImages;

}
