package com.nf.shop.service.front;

import com.nf.shop.entity.Cart;
import com.nf.shop.vo.CartVO;

import java.util.List;

/**
 * @Author:DENG-
 * @Date:2019/12/11 10:44
 */
public interface CartService {
    List<Cart> findCustomerAllCarts(Integer customerId);

    Boolean saveToCart(CartVO cartVo);

    Boolean modifyCartStatus(Integer id);

    Boolean modifyCartStatusByCartIdAndCustomerId(Integer cartId, Integer id);

    Boolean modifyCartStatusByCartIdAndCustomerIds(Integer[] cartIds, Integer customerId);

    Boolean modifyNumAndPriceByCartIdAndCustomerIdAndStatus(Integer cartId, Integer productNum, Integer id);

    List<Cart> findCartByCartIdsAndCustomerId(Integer[] orderCartIds, Integer id);

    List<Cart> findRedirectCartByCartIdsAndCustomerId(Integer[] orderCartIds, Integer id);

    int redirectToCart(CartVO cartVo);
}
