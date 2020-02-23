package com.nf.shop.dao.front;

import com.nf.shop.entity.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 购物车业务类
 * @Author:DENG-
 * @Date:2019/12/11 10:39
 */
public interface CartDao {
    List<Cart> selectAllCartByCustomerId(Integer customerId);

    Cart selectCartByCustomerIdAndProductId(@Param("customerId") Integer customerId, @Param("productId") Integer productId);

    Cart selectCartByCustomerIdAndCartId(@Param("customerId") Integer customerId,@Param("cartId") Integer cartId);

    int insertCart(Cart cart);

    int updateCartNumAndTotalPriceById(@Param("id") Integer id, @Param("productNum") Integer num,@Param("totalPrice") Double price);

    int updateCartStatusByCustomerId(@Param("customerId") Integer id,@Param("status") Integer status);

    int updateCartStatusByCartIdAndCustomerId(@Param("cartId") Integer cartId,
                                              @Param("customerId") Integer id,
                                              @Param("status")Integer status);

    int updateCartStatusByCartIdAndCustomerIds(@Param("cartIds") Integer[] cartIds,
                                               @Param("customerId") Integer customerId,
                                               @Param("status") Integer status);

    int updateProductNumAndPriceByCartIdAndCustomerIdAndStatus(@Param("cartId") Integer cartId,
                                                               @Param("productNum") Integer productNum,
                                                               @Param("customerId") Integer id,
                                                               @Param("status") int status,
                                                               @Param("totalPrice")Double totalPrice);

    List<Cart> selectCartByCartIdsAndCustomerId(@Param("cartIds") Integer[] orderCartIds,
                                                @Param("customerId") Integer id,
                                                @Param("status") int status);

    List<Cart> selectRedirectCartByCartIdsAndCustomerId(@Param("cartIds") Integer[] orderCartIds,
                                                        @Param("customerId") Integer id,
                                                        @Param("status") int status);

    Cart selectRedirectCartByCustomerIdAndProductId(@Param("customerId") Integer customerId,@Param("productId") Integer productId);

}
