package com.nf.shop.service.front;

import com.nf.shop.entity.Shipping;
import com.nf.shop.vo.ShippingVO;

import java.util.List;

/**
 * @Author:DENG-
 * @Date:2019/12/13 8:53
 */
public interface ShippingService {
    int saveShipping(ShippingVO shippingVo, Integer customerId);

    List<Shipping> findCustomerAllShippings(Integer customerId);

    Shipping findShippingByCustomerIdAndShippingId(Integer customerId,Integer shippingId);

    Boolean modifyShipping(ShippingVO shippingVo,Integer customerId);

    Boolean removeShipping(Integer shippingId,Integer customerId);
}
