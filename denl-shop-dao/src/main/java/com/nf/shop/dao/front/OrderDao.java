package com.nf.shop.dao.front;

import com.nf.shop.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author:DENG-
 * @Date:2019/12/12 9:33
 */
public interface OrderDao {
    int insertOrder(Order order);

    List<Order> selectAllOrderByCustomerId(@Param("customerId") Integer id);

    List<Order> selectOrdersByCustomerIdAndStatus(@Param("customerId")Integer id,@Param("status")Integer status);

    int updateOrderStatusByCustomerIdAndOrderId(@Param("customerId")Integer id,@Param("orderId")Integer orderId,@Param("status")Integer status);

    Order selectOrderIdByOrderNoAndCustomerId(@Param("orderNo") String orderNo, @Param("customerId") Integer id);

    int updateOrderStatusByCustomerIdAndOrderNo(@Param("customerId") Integer id,
                                                @Param("orderNumber") String out_trade_no,
                                                @Param("status") Integer status);

    int updateOrderStatusByOrderNo(@Param("orderNumber") String out_trade_no,
                                   @Param("status") Integer status);
}
