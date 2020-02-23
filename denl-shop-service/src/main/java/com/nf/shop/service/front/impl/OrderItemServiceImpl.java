package com.nf.shop.service.front.impl;

import com.nf.shop.dao.front.OrderItemDao;
import com.nf.shop.entity.OrderItem;
import com.nf.shop.service.front.OrderItemService;
import com.nf.shop.service.front.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @Author:DENG-
 * @Date:2019/12/19 11:26
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemDao orderItemDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<OrderItem> findOrderItemsByOrderId(Integer id) {
        List<OrderItem> orderItems = orderItemDao.selectOrderItemsByOrderId(id);
        return orderItems;
    }
}
