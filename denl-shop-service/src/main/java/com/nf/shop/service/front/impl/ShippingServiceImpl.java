package com.nf.shop.service.front.impl;

import com.nf.shop.dao.front.ShippingDao;
import com.nf.shop.entity.Shipping;
import com.nf.shop.exception.ShippingException;
import com.nf.shop.service.front.ShippingService;
import com.nf.shop.vo.ShippingVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author:DENG-
 * @Date:2019/12/13 8:55
 */
@Service
public class ShippingServiceImpl implements ShippingService {
    @Autowired
    private ShippingDao shippingDao;

    @Override
    public int saveShipping(ShippingVO shippingVo, Integer customerId) {
        Shipping shipping = new Shipping();

        BeanUtils.copyProperties(shippingVo,shipping);
        //设置客户id
        shipping.setCustomerId(customerId);
        //创建时间
        shipping.setCreateTime(new Date());
        //更新时间，开始默认和创建时间一致
        shipping.setUpdateTime(new Date());
        shipping.setStatus(1);
        int rows = shippingDao.insertShipping(shipping);
        if(rows >= 1){
            return shipping.getId();
        }
        throw new ShippingException("收货地址添加失败");
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Shipping> findCustomerAllShippings(Integer customerId) {
        List<Shipping> shippingList = shippingDao.selectAllShippings(customerId,1);
        if (shippingList.size() == 0) {
            return null;
        }
        return shippingList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Shipping findShippingByCustomerIdAndShippingId(Integer customerId, Integer shippingId) {
        Shipping shipping = shippingDao.selectShippingByCustomerIdAndShippingId(customerId, shippingId);
        if (shipping == null) {
            throw new ShippingException("该地址不存在");
        }
        return shipping;
    }

    @Override
    public Boolean modifyShipping(ShippingVO shippingVo, Integer customerId) {
        Shipping shipping = shippingDao.selectShippingByCustomerIdAndShippingId(customerId, shippingVo.getId());
        if (shipping == null) {
            //TODO:这里可以设计抛出有一个异常
            throw new ShippingException("改地址信息不存在");
        }
        //属性拷贝
        BeanUtils.copyProperties(shippingVo,shipping);
        //更新更新时间
        shipping.setUpdateTime(new Date());
        int rows = shippingDao.updateByShipping(shipping);
        if (rows > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean removeShipping(Integer shippingId, Integer customerId) {
        //删除时间也要更新一下
        Date updateTime = new Date();
        int rows = shippingDao.deleteShippingByIdAndCustomerId(shippingId, customerId, 0,updateTime);
        if (rows >= 1) {
            return true;
        }
        return false;
    }
}
