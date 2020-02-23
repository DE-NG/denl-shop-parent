package com.nf.shop.service.front;


import com.nf.shop.dao.front.SendSmsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendSmsService {

	@Autowired
	SendSmsDao dao = new SendSmsDao();
	
	public void sendSms(String phone,Integer code) {
		 dao.sendSms(phone,code);
	}
}
