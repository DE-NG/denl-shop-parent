package com.nf.shop.vo;

import com.nf.shop.entity.Order;
import com.nf.shop.entity.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author:DENG-
 * @Date:2019/12/12 9:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO extends Order {
    /*订单中包含的类目*/
    private List<OrderItem> orderItemList;
}
