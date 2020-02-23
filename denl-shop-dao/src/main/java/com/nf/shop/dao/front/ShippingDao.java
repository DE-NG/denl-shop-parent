package com.nf.shop.dao.front;

import com.nf.shop.entity.Shipping;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Author:DENG-
 * @Date:2019/12/13 8:46
 */
public interface ShippingDao {

    int insertShipping(Shipping shipping);

    List<Shipping> selectAllShippings(@Param("customerId") Integer customerId , @Param("status") Integer status);

    Shipping selectShippingByCustomerIdAndShippingId(@Param("customerId") Integer customerId,
                                                     @Param("shippingId") Integer shippingId);

    int updateByShipping(Shipping shipping);

    int deleteShippingByIdAndCustomerId(@Param("shippingId") Integer shippingId,
                                        @Param("customerId") Integer customerId,
                                        @Param("status") int status,
                                        @Param("updateTime") Date updateTime);
}
