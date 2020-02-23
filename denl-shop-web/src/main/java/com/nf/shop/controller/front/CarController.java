package com.nf.shop.controller.front;

import com.nf.shop.entity.Cart;
import com.nf.shop.entity.Customer;
import com.nf.shop.service.front.CartService;
import com.nf.shop.vo.CartVO;
import com.nf.shop.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
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
 * @Date:2019/12/11 10:09
 */
@Controller
@RequestMapping("/front/cart")
@Slf4j
public class CarController {
    @Autowired
    private CartService cartService;
    /**
     *清空购物车后展示此界面
     * @return
     */
    @RequestMapping("/showEmptyCart")
    public String showEmptyCart() {
        return "emptyCart";
    }

    @RequestMapping("/myCarts")
    public String myCars(HttpSession session, Model model) {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer != null) {
            List<Cart> cartList = cartService.findCustomerAllCarts(customer.getId());
            model.addAttribute("cartList", cartList);
        }
        return "car";
    }

    @RequestMapping("/addToCart")
    @ResponseBody
    public ResponseVO addToCart(Integer id,Integer textBox,HttpSession session){
        Customer customer = (Customer) session.getAttribute("customer");
        if (ObjectUtils.isEmpty(customer)){
            return ResponseVO.newBuilder().code("400").msg("请先登录").build();
        }else {
            CartVO cartVo = new CartVO();
            cartVo.setCustomerId(customer.getId());
            cartVo.setProductId(id);
            cartVo.setProductNum(textBox);

            if (cartService.saveToCart(cartVo)){
                return ResponseVO.newBuilder().code("200").msg("添加成功").build();
            }else {
                return ResponseVO.newBuilder().code("500").msg("添加失败").build();
            }
        }
    }

    @RequestMapping("/clearAllProductFromCart")
    @ResponseBody
    public ResponseVO clearAllProductFromCart(HttpSession session){
        Customer customer = (Customer) session.getAttribute("customer");
        if (!ObjectUtils.isEmpty(customer)){
            if (cartService.modifyCartStatus(customer.getId())){
                return ResponseVO.newBuilder().code("200").msg("购物车已清空").build();
            }
        }else {
            return ResponseVO.newBuilder().code("400").msg("请先登录").build();
        }
        return ResponseVO.newBuilder().code("500").msg("清空购物车失败").build();
    }

    @RequestMapping("/removeOneProduct")
    @ResponseBody
    public ResponseVO removeOneProduct(Integer cartId,HttpSession session){
        Customer customer = (Customer) session.getAttribute("customer");
        if (!ObjectUtils.isEmpty(customer)){
            if (cartService.modifyCartStatusByCartIdAndCustomerId(cartId,customer.getId())){
                return ResponseVO.newBuilder().code("200").msg("删除成功").build();
            }
        }else {
            return ResponseVO.newBuilder().code("400").msg("请先登录").build();
        }
        return ResponseVO.newBuilder().code("500").msg("删除失败").build();
    }

    @RequestMapping("/removeMoreProductFromCart")
    @ResponseBody
    public ResponseVO removeMoreProductFromCart(Integer[] cartIds,HttpSession session){
        Customer customer = (Customer) session.getAttribute("customer");
        if (!ObjectUtils.isEmpty(customer)){
            if (cartService.modifyCartStatusByCartIdAndCustomerIds(cartIds,customer.getId())){
                return ResponseVO.newBuilder().code("200").msg("删除成功").build();
            }
        }else {
            return ResponseVO.newBuilder().code("400").msg("请先登录").build();
        }
        return ResponseVO.newBuilder().code("500").msg("删除失败").build();
    }

    @RequestMapping("/inputModifyProductNum")
    @ResponseBody
    public ResponseVO inputModifyProductNum(Integer cartId, Integer productNum, HttpSession session){
        Customer customer = (Customer) session.getAttribute("customer");
        if (!ObjectUtils.isEmpty(customer)){
            if (cartService.modifyNumAndPriceByCartIdAndCustomerIdAndStatus(cartId,productNum,customer.getId())){
                return ResponseVO.newBuilder().code("200").msg("修改成功").build();
            }
        }else {
            return ResponseVO.newBuilder().code("400").msg("请先登录").build();
        }
        return ResponseVO.newBuilder().code("500").msg("修改失败").build();

    }

    @RequestMapping("/addTempOrderItem")
    @ResponseBody
    public ResponseVO addTempOrderItem(Integer count, String price, Integer[] orderCartIds, HttpSession session){
        Customer customer = (Customer) session.getAttribute("customer");
        if (ObjectUtils.isEmpty(customer)) {
            return ResponseVO.newBuilder().code("400").msg("请先登录").data(null).build();
        }else {
            session.setAttribute("count",count);

            String[] strings = price.split("¥");

            double newPrice = Double.parseDouble(strings[1]);

            session.setAttribute("price",newPrice);
            session.setAttribute("orderCartIds",orderCartIds);
            return ResponseVO.newBuilder().code("200").msg("成功").data(session).build();
        }
    }
}
