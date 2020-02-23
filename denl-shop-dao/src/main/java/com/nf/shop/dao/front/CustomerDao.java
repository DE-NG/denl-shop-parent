package com.nf.shop.dao.front;

import com.nf.shop.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author:DENG-
 * @Date:2019/12/9 15:15
 */
public interface CustomerDao {

    Customer selectByPhoneAndPassword(@Param("phone")String phone,
                                      @Param("password") String password,
                                      @Param("isValid") Integer isValid);

    Customer selectByPhone(String phone);

    int insertCustomer(Customer customer);

    Customer selectCustomerById(int id);

    int updateCustomerPassword(Customer customer);

    int updateCustomer(Customer customer);

    List<Customer> selectAllCustomer(@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);

    int updateCustomerPhoneAndAddress(Customer customer);

    int updateCustomerStatus(int id);
}
