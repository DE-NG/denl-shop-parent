package com.nf.shop.controller.front;

import com.nf.shop.entity.Customer;
import com.nf.shop.vo.CustomerEditVO;
import com.nf.shop.service.front.CustomerService;
import com.nf.shop.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @Author:DENG-
 * @Date:2019/12/9 15:08
 */
@Controller
@RequestMapping("/front/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 用户登录
     * @param phone
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("loginByAccount")
    @ResponseBody
    public ResponseVO loginByAccount(String phone, String password, HttpSession session){
        Customer customer=null;
        try {
            customer=customerService.login(phone,password);
            customer.setPassword(null);
            session.setAttribute("customer",customer);
            return ResponseVO.newBuilder().code("200").msg("登录成功").data(customer).build();
        }catch (Exception e){
            return ResponseVO.newBuilder().code("500").msg("登录失败").data(null).build();
        }
    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    @ResponseBody
    public ResponseVO logout(HttpSession session){
        session.invalidate();
        return ResponseVO.newBuilder().msg("成功").code("200").data(null).build();
    }

    /**
     * 验证手机号是否被注册
     * @param phone
     * @return
     */
    @RequestMapping("/checkPhone")
    @ResponseBody
    public ResponseVO checkPhone(String phone){
        boolean flag = customerService.findByPhone(phone);
        if (flag){
            return ResponseVO.newBuilder().code("200").msg("该手机号可用").data(null).build();
        }else {
            return ResponseVO.newBuilder().code("500").msg("改手机号已经被注册").build();
        }
    }

    @RequestMapping("/register")
    @ResponseBody
    public ResponseVO register(String loginName,String password,String address,String phone,int verifyCode,HttpSession session){
        try {
            //System.out.println("loginName = " + loginName);
            Customer customer = new Customer(loginName,password,phone,address,1,new Date());
            int sendVerifyCode = (int) session.getAttribute("sendVerifyCode");
            if (verifyCode == sendVerifyCode){
                Customer customer1 = customerService.register(customer);
                if (customer1 != null){
                    customer1.setPassword(null);
                    session.setAttribute("customer",customer1);
                    return ResponseVO.newBuilder().code("200").msg("注册成功").data(customer1).build();
                }
            }
            return ResponseVO.newBuilder().code("500").msg("注册失败").build();
        }catch (Exception e){
            return ResponseVO.newBuilder().code("500").msg("注册失败").build();
        }
    }

    @RequestMapping("/customerCenter")
    public String customerCenter(HttpSession session, Model model){
        Customer customer = (Customer) session.getAttribute("customer");
        if (ObjectUtils.isEmpty(customer)){
            return "main";
        }

        Customer customer1 = customerService.findCustomerById(customer.getId());
        customer1.setPassword(null);
        model.addAttribute("user",customer1);
        return "center";
    }

    @RequestMapping("/editCustomerView")
    public String editCustomerView(HttpSession session,Model model){
        Customer customer = (Customer) session.getAttribute("customer");
        if (ObjectUtils.isEmpty(customer)){
            return "main";
        }

        Customer customer1 = customerService.findCustomerById(customer.getId());
        customer1.setPassword(null);
        model.addAttribute("user",customer1);
        return "editView";
    }

    @RequestMapping("/editCustomer")
    @ResponseBody
    public ResponseVO editCustomer(CustomerEditVO customerVO, HttpSession session) {
        Customer customer =null;
        if(customerVO.getMultipartFile()==null){
             customer = new Customer(customerVO.getLoginName(),customerVO.getPhone(),customerVO.getAddress(),customerVO.getCustomerId());

            if (customerService.modifyCustomer(customer)){
                session.setAttribute("customer",customer);
                return ResponseVO.newBuilder().code("200").msg("修改成功").build();
            }else {
                return ResponseVO.newBuilder().code("500").msg("修改失败").build();
            }
        }
        Customer user = (Customer) session.getAttribute("customer");
        if (ObjectUtils.isEmpty(user)){
            return ResponseVO.newBuilder().code("400").msg("请先登录").build();
        }
        String filePath = "E:\\IdeaProjects\\denl-shop-parent\\denl-shop-web\\src\\main\\resources\\static\\images";
        String originalFilename = customerVO.getMultipartFile().getOriginalFilename();
        String path = filePath + File.separator + originalFilename;
        File file = new File(path);
        String newFile = "/static/images/" + originalFilename;
        customer = new Customer(newFile,customerVO.getLoginName(),customerVO.getPhone(),customerVO.getAddress(),customerVO.getCustomerId());
        try {
            customerVO.getMultipartFile().transferTo(file);
            customerService.modifyCustomer(customer);
            session.setAttribute("customer",customer);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseVO.newBuilder().code("500").msg("修改失败").build();
        }

        return ResponseVO.newBuilder().code("200").msg("修改成功").build();
    }


    /**
     * 修改密码
     * @param password
     * @param newpassword
     * @param session
     * @return
     */
    @RequestMapping("/modifyPassword")
    @ResponseBody
    public ResponseVO modifyPassword(String password,String newpassword,HttpSession session){

        Customer customer = (Customer) session.getAttribute("customer");
        Customer customer1 = customerService.findCustomerById(customer.getId());
        if (password.equals(customer1.getPassword())) {

            try {
                customer.setPassword(newpassword);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseVO.newBuilder().code("500").msg("修改密码失败").build();
            }

            if (customerService.modifyCustomerPassword(customer)) {
                session.invalidate();
                customer.setPassword(null);
                return ResponseVO.newBuilder().code("200").msg("修改密码成功，请重新登录").data(customer).build();
            } else {
                customer.setPassword(newpassword);
                session.setAttribute("customer", customer);
                return ResponseVO.newBuilder().code("500").msg("修改密码失败").build();
            }
        }else {
            return ResponseVO.newBuilder().code("500").msg("原始密码不正确").build();
        }
    }
}
