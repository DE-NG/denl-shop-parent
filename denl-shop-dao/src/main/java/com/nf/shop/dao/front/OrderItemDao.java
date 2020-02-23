package com.nf.shop.dao.front;

import com.nf.shop.entity.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author:DENG-
 * @Date:2019/12/12 9:36
 */
public interface OrderItemDao {
    List<OrderItem> selectOrderItemsByOrderId(Integer orderId);

    int insertOrderItemByOrderItems(@Param("orderItemList") List<OrderItem> orderItemList);
}
