package com.nf.shop.controller.front;

import com.nf.shop.service.front.SendSmsService;
import com.nf.shop.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Random;

/**
 * @Author:DENG-
 * @Date:2019/12/10 11:02
 */
@Controller
@RequestMapping("/front/sms")
public class SmsController {
    @Autowired
    private SendSmsService sendSmsService;

    @RequestMapping("/sendVerifyCode")
    @ResponseBody
    public ResponseVO sendVerifyCode(String phone , HttpSession session){
        try {
            //System.out.println("phone = " + phone);
            //生成 6 位随机验证码
            Random random = new Random();
            int smsCode = random.nextInt(899999) + 100000;
            sendSmsService.sendSms(phone,smsCode);
            session.setAttribute("sendVerifyCode",smsCode);
            return ResponseVO.newBuilder().code("200").msg("验证码发送成功").data(null).build();
        }catch (Exception e){
            return ResponseVO.newBuilder().code("500").msg("验证码发送失败").build();
        }

    }
}
