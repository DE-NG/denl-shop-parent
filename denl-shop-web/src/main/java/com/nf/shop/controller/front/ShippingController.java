package com.nf.shop.controller.front;

import com.nf.shop.entity.Customer;
import com.nf.shop.entity.Shipping;
import com.nf.shop.exception.ShippingException;
import com.nf.shop.service.front.ShippingService;
import com.nf.shop.vo.ShippingVO;
import com.nf.shop.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author:DENG-
 * @Date:2019/12/12 16:05
 */
@Controller
@RequestMapping("/front/shipping")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    /**
     * 添加地址
     * @param shippingVo
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/saveShipping")
    @ResponseBody
    public ResponseVO saveShipping(ShippingVO shippingVo , HttpSession session, Model model){

        Customer customer = (Customer) session.getAttribute("customer");
        if (ObjectUtils.isEmpty(customer)) {
            return ResponseVO.newBuilder().code("400").msg("请先登录").build();
        }
        try {
            int shippingId = shippingService.saveShipping(shippingVo, customer.getId());
            model.addAttribute("shippingId", shippingId);
            return ResponseVO.newBuilder().code("200").msg("添加成功").build();
        } catch (ShippingException e) {
            return ResponseVO.newBuilder().code("500").msg(e.getMessage()).build();
        }
    }

    @RequestMapping("/findAllShippings")
    @ResponseBody
    public ResponseVO findAllShippings(HttpSession session,Model model){
        Customer customer = (Customer) session.getAttribute("customer");
        if (ObjectUtils.isEmpty(customer)) {
            return ResponseVO.newBuilder().code("400").msg("请先登录").build();
        }
        List<Shipping> shippingList = shippingService.findCustomerAllShippings(customer.getId());
        model.addAttribute("shippingList", shippingList);
        return ResponseVO.newBuilder().code("200").data(model).msg("成功").build();
    }

    /**
     * 将要修改的数据放入到修改框中
     * @param shippingId
     * @param session
     * @return
     */
    @RequestMapping("/showOneShipping")
    @ResponseBody
    public ResponseVO showOneShipping(Integer shippingId, HttpSession session){
        Customer customer = (Customer) session.getAttribute("customer");
        if (ObjectUtils.isEmpty(customer)) {
            return ResponseVO.newBuilder().code("400").msg("请先登录").build();
        }
        try {
            Shipping shipping = shippingService.findShippingByCustomerIdAndShippingId(customer.getId(),shippingId);
            return ResponseVO.newBuilder().code("200").msg("成功").data(shipping).build();
        }catch (ShippingException e){
            return ResponseVO.newBuilder().code("500").msg(e.getMessage()).build();
        }
    }

    @RequestMapping("/modifyShipping")
    @ResponseBody
    public ResponseVO modifyShipping(ShippingVO shippingVo, HttpSession session){
        Customer customer = (Customer) session.getAttribute("customer");
        if (ObjectUtils.isEmpty(customer)) {
            return ResponseVO.newBuilder().code("400").msg("请先登录").build();
        }
        if (shippingService.modifyShipping(shippingVo,customer.getId())){
            return ResponseVO.newBuilder().code("200").msg("修改成功").build();
        }
        return ResponseVO.newBuilder().code("500").msg("修改失败").build();
    }

    @RequestMapping("/removeShipping")
    @ResponseBody
    public ResponseVO removeShipping(Integer shippingId, HttpSession session){
        Customer customer = (Customer) session.getAttribute("customer");
        if (ObjectUtils.isEmpty(customer)) {
            return ResponseVO.newBuilder().code("400").msg("请先登录").build();
        }
        if (shippingService.removeShipping(shippingId,customer.getId())){
            return ResponseVO.newBuilder().code("200").msg("删除成功").build();
        }
        return ResponseVO.newBuilder().code("500").msg("删除失败").build();
    }

}
