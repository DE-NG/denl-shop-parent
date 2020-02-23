package com.nf.shop.controller.back;

import com.nf.shop.entity.SystemUser;
import com.nf.shop.service.back.SystemUserService;
import com.nf.shop.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author:DENG-
 * @Date:2019/12/26 10:57
 */
@Controller
@RequestMapping("/back/sysuser")
public class SystemUserController {

    @Autowired
    private SystemUserService systemUserService;

    @RequestMapping("/login")
    public String main(){
        return "backlogin";
    }

    @RequestMapping("/doLogin")
    public String doLogin(String loginName, String password, HttpSession session, Model model){
        try {
            SystemUser systemUser = systemUserService.findSystemUserByLoginNameAndPassword(loginName,password);
            systemUser.setPassword(null);
            session.setAttribute("systemUser",systemUser);
            return "backmain";
        }catch (Exception e){
            return "backlogin";
        }
    }

    @RequestMapping("/logout")
    @ResponseBody
    public ResponseVO logout(HttpSession session){
        session.invalidate();
        return ResponseVO.newBuilder().code("200").msg("退出成功").build();
    }
}
