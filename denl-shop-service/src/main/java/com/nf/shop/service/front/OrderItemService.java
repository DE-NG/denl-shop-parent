package com.nf.shop.service.front;

import com.nf.shop.entity.OrderItem;

import java.util.List;

/**
 * @Author:DENG-
 * @Date:2019/12/19 11:22
 */
public interface OrderItemService {

    List<OrderItem> findOrderItemsByOrderId(Integer id);
}
