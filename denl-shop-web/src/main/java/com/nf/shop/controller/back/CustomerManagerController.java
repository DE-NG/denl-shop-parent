package com.nf.shop.controller.back;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.nf.shop.entity.Customer;
import com.nf.shop.service.front.CustomerService;
import com.nf.shop.vo.CustomerVO;
import com.nf.shop.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author DENG-
 */
@Controller
@RequestMapping("/back/customer")
public class CustomerManagerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/getAllCustomers")
    public String getAllCustomers(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                                  @RequestParam(value = "pageSize",required = false,defaultValue = "5")int pageSize,
                                  Model model){
        List<Customer> customers = customerService.findAllCustomer(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(customers);
        model.addAttribute("pageInfo",pageInfo);
        return "customerManager";
    }

    @RequestMapping("/showCustomer")
    @ResponseBody
    public ResponseVO showCustomer(int id){
        Customer customer = customerService.findCustomerById(id);
        return ResponseVO.newBuilder().code("200").msg("查询成功").data(customer).build();
    }

    @RequestMapping("/modifyCustomer")
    public String modifyCustomer(CustomerVO customerVO, Integer pageNum, Model model){
        Customer customer = new Customer(customerVO.getId(),customerVO.getPhone(),customerVO.getAddress());
        if (ObjectUtils.isEmpty(pageNum)) {
            pageNum = 1;
        }
        if (customerService.modifyCustomerPhoneAndAddress(customer)){
            model.addAttribute("successMsg","修改成功");
        }else{
            model.addAttribute("failMsg","修改失败");
        }
        return "forward:getAllCustomers?pageNum="+pageNum;
    }

    @RequestMapping("/modifyCustomerStatus")
    @ResponseBody
    public ResponseVO modifyCustomerStatus(int id){
        if (customerService.modifyCustomerStatus(id)){
            return ResponseVO.newBuilder().code("200").msg("状态修改成功").build();
        }else {
            return ResponseVO.newBuilder().code("500").msg("状态修改失败").build();
        }
    }
}
