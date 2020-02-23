package com.nf.shop.exception;

import java.security.MessageDigest;
import java.util.UUID;

/**
 * Description: 通用工具类 uuid sign
 * @author DENG-
 */
public class CommonUtils {

    /**
     *功能描述: 生成uuid,作为一笔订单流水，也用作 nonce_str
     * @Param [] 
     * @return java.lang.String
     */
    public static String generateUUID(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "")
                .toUpperCase().substring(0, 32);
        return uuid;
    }

    
    /**
     *功能描述: md5 生成工具类
     * @Param [data] 待处理数据
     * @return java.lang.String md5 结果
     */
    public static String MD5(String data) throws Exception{
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] digest = md5.digest(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : digest) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString().toUpperCase();
    }

}
