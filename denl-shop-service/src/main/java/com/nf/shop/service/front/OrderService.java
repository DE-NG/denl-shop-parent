package com.nf.shop.service.front;

import com.nf.shop.entity.Order;
import com.nf.shop.vo.OrderVO;

import java.util.List;

/**
 * @Author:DENG-
 * @Date:2019/12/12 9:46
 */
public interface OrderService {
    List<OrderVO> getCustomerAllOrders(Integer id);

    String saveOrder(OrderVO orderVo);

    List<OrderVO> getDifferenceStatusOrders(Integer id,Integer status);

    boolean modifyOrderStatusByCustomerIdAndOrderId(Integer id,Integer orderId,Integer status);

    Order findOrderIdByOrderNoAndCustomerId(String orderNo,Integer id);

    Boolean modifyOrderStatusByCustomerIdAndOrderNo(Integer id, String out_trade_no);

    Boolean modifyOrderStatusByOrderNo(String out_trade_no);
}
