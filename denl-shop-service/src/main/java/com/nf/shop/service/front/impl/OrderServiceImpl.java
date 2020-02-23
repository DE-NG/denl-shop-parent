package com.nf.shop.service.front.impl;

import com.nf.shop.dao.front.OrderDao;
import com.nf.shop.dao.front.OrderItemDao;
import com.nf.shop.entity.Order;
import com.nf.shop.entity.OrderItem;
import com.nf.shop.service.front.OrderService;
import com.nf.shop.vo.OrderVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:DENG-
 * @Date:2019/12/12 9:47
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderItemDao orderItemDao;

    @Override
    public List<OrderVO> getCustomerAllOrders(Integer id) {
        //先获取该用户的所有订单id
        List<Order> orderList = orderDao.selectAllOrderByCustomerId(id);

        List<OrderVO> orderVoList = new ArrayList<>();
        //循环遍历出每个订单对应的明细，每个封装到OrderVo中，最终返回一个orderVo的集合
        for(Order order :orderList){
            //通过订单id 查询出该笔订单的明细
            OrderVO orderVo = new OrderVO();
            List<OrderItem> orderItemList = orderItemDao.selectOrderItemsByOrderId(order.getId());
            BeanUtils.copyProperties(order,orderVo);
            orderVo.setOrderItemList(orderItemList);
            orderVoList.add(orderVo);
        }
        return orderVoList;
    }

    @Override
    public String saveOrder(OrderVO orderVo) {
        //保存订单
        Order order = new Order();
        BeanUtils.copyProperties(orderVo, order);
        //将订单写入数据库
        int row = orderDao.insertOrder(order);
        //将订单明细插入到数据库中
        List<OrderItem> orderItemList = orderVo.getOrderItemList();
        List<OrderItem> newOrderItemList = new ArrayList<>();

        if (row >= 1) {
            for (OrderItem orderItem : orderItemList) {
                //int rows = orderItemDao.insertOrderItem(orderItem);
                //都属于同一个订单
                orderItem.setOrder(order);
                newOrderItemList.add(orderItem);
            }
        }
        //插入订单明细
        int rows = orderItemDao.insertOrderItemByOrderItems(newOrderItemList);

        if (rows >= 1) {
            return order.getOrderNumber();
        }
        return null;
    }

    @Override
    public List<OrderVO> getDifferenceStatusOrders(Integer id, Integer status) {
        //根据用户Id和订单状态查询所有的订单
        List<Order> orders = orderDao.selectOrdersByCustomerIdAndStatus(id,status);

        List<OrderVO> orderVoList = new ArrayList<>();

        for (Order order : orders) {
            OrderVO orderVo = new OrderVO();
            Integer orderId = order.getId();
            List<OrderItem> orderItems = orderItemDao.selectOrderItemsByOrderId(orderId);
            BeanUtils.copyProperties(order,orderVo);
            orderVo.setOrderItemList(orderItems);
            orderVoList.add(orderVo);
        }
        return orderVoList;
    }

    @Override
    public boolean modifyOrderStatusByCustomerIdAndOrderId(Integer id, Integer orderId, Integer status) {
        int rows = orderDao.updateOrderStatusByCustomerIdAndOrderId(id,orderId,status);
        if (rows > 0){
            return true;
        }
        return false;
    }

    @Override
    public Order findOrderIdByOrderNoAndCustomerId(String orderNo, Integer id) {
        Order order = orderDao.selectOrderIdByOrderNoAndCustomerId(orderNo, id);
        if (ObjectUtils.isEmpty(order)) {
            return null;
        }
        return order;
    }

    @Override
    public Boolean modifyOrderStatusByCustomerIdAndOrderNo(Integer id, String out_trade_no) {
        int rows = orderDao.updateOrderStatusByCustomerIdAndOrderNo(id,out_trade_no,1);
        if (rows > 0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean modifyOrderStatusByOrderNo(String out_trade_no) {
        int rows = orderDao.updateOrderStatusByOrderNo(out_trade_no,1);
        if (rows > 0){
            return true;
        }
        return false;
    }
}
