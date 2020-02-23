package com.nf.shop.config;

/**
 * @Author:DENG-
 * @Date:2019/12/19 21:01
 */
public class AliPayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101600702697";
    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCEzXuq4QP1V7keTivhdDBf2PKKZRr2kqwuOCVvzzBkW5uzlYZ4HQsCa5amY2Lw++qVUZ2b4uAedglEM9p0AO3hQm01RpEoD0PsNW7eoTdJslb13jvyXUzceZzjiARzTeRTAg29PCAzpVxSbs6jGIkMZ4cEt+JVs6rT/40+/TUA1crMfWOH6vGRUkEzkBvc9bPvr7S097jtlsLRMyz8IpONQLY17BpYvw9DdmiyIaCzR6O/3i2pMpF+Ch2DuuJDPn7jTh9BZwoRnLCkPbWyp3WZdIIFFPPk6AdOX2312iz8lJ5dH8HNEPqH4058KGZZ7OxuF0rOBQDC1SAZYshYEdIjAgMBAAECggEAMtywHIYJihGK6Lxvue1SCaOBYNfQN9d88ka2r9feZNFhFKqT0bTt3oNuM1OlNT6GXaHghy+hPoleiyyA4iTo9nkGcn0QYxNVpEXirIl6L1OKUqhGtVBee6JoIAycB70xUUlcEbnRa3ZNoZSmt3hSJNoRsBDtMn2ZU5BwfEtl3Wd2+0HrZlg6DK1mhggljoMAVR3keUNHLIfJCbHT6KhXSFhDxUH60syoelhFO5z+4Y+Pa9ni6i4VLRKAD8X8ARl0AO30H0Q4yxqPAzSXaQSeUfb1LLqrl5lM+fNk6IQmKkuwIalXssAXMvOrbKykJVwK9BKxqlgWr0TYKt67bUVCgQKBgQC8bSc6CYCD85GCId+1zv6chR9AOsU74Gtu+1gHJOVo8mCpirZa3y7CBGc0j9/YwETilib8klHKZd+HvPCQ02Zs+eQhmw5oMOVDdv2RoKbISR58maJXD1zgmnBu1UplghpGuxXfVaJ24zDIhGp47C6O4fMQoef+XMlYSB345Ui/8QKBgQC0bbAXil99mW8evlBd/Y8nKaJEWIBn66+IsWUwGKI4gnu6nGIC/FKf1ElX6e9Ds2I1hX691nMfWLXQIjHxvKZJXwLi9MuD+wl88ndk1tjTRPDQJGwKg333y05ulcKVrm8jpOEdYE1TmC8slBMaU1idbx5Az8WxljDpUIZ4Q/wHUwKBgDqvGCd4LCFsa2YHHMBn7l5bC4eahjEGzQ7sktbuw9AypK5I+FBG8C4W5vm00XeVMh8Luqqw+2442ixRSO8iF+Va0pUw0ITcrZqcZY7EZQ090JPn2WqZ60g8cUXjgd8pbPuYatB6wDWcvmXE79AnZryzXFtSwYkz5rVrCIKrDkRRAoGAS6yBoa3wlP4oY+2QSYuSYeuNWjsASBXKvnsgpIaAa1EW0dLLLNNlWBGyXUQJjQyMkUQXP0nVaP1M7CmbZvcnizhlPolLXmSIuzX6q3mM4TdWBQZxpgs2ZxqHH8yCG0NY68s4e5irdfcrOfg09uKkFQvI1YgPM4d5pjGW5JQm/W8CgYA1AZjYP2EbCDZaTMl9BTMGyXIDk+/oANZVbl3xEsdubonTOTS40RkvCbdD7VAjIJXGWKodds80yqerJf1LyKSBVzDzDsXTFZUCqbfKHji7YuJxs0ZH2vP7c0D1uGdip7MOCEXw67e843UJcz/IcRPHln8MUchuBKRqaahIfGHmug==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAswHNCnmRQDi9DNnzI5eKip2HbUF88jRlHf+RLJSsP9+l6laI8bnZ/M+dMwT8f6KvEIrP+uUWXgE5TBl70C8IFPQyuhuzwtimmGbr3LQNDYJr7u4McJlYXTKhj2b1Arvl1l71f5ry2pk6R6106s4E0ErZSfU3LgQDjqw62MzK6SKwgYfkIVxpojMkuOZ57sREdteaKLYsZ2Le2gIqZ1XSpLlq8THq/dgNr1lIitsXUCv5/ljm6Q8pYDs8gLLeacIv/x/5rLUkEUGrdyWHXquaJl/UEuYMldjP3Lb/XPAQyW6wDZ2Vubn+G5MvwxsNSh18Uuvfh4qphYLynidAwZB7BwIDAQAB";

    /***
     *功能描述: 服务器异步通知页面路径  需 http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    //public static String notify_url = "http://xiaomo.mynatapp.cc/front/pay/aliPayNotifyNotice";

    //部署服务器上，注意修改地址：
    public static String notify_url = "http://localhost:8070/front/pay/aliPayNotifyNotice";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    //public static String return_url = "https://xiaomo.mynatapp.cc/front/pay/aliPayReturnNotice";
    //部署服务器上注意修改地址
    public static String return_url = "http://localhost:8070/front/pay/aliPayReturnNotice";


    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
}
