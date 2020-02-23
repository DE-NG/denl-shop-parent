package com.nf.shop.service.front;

import com.nf.shop.entity.Customer;

import java.util.List;

/**
 * @Author:DENG-
 * @Date:2019/12/9 15:22
 */
public interface CustomerService {
    Customer login(String phone, String password);

    boolean findByPhone(String phone);

    Customer register(Customer customer);

    Customer findCustomerById(int id);

    boolean modifyCustomerPassword(Customer customer);

    boolean modifyCustomer(Customer customer);

    List<Customer> findAllCustomer(int pageNum,int pageSize);

    boolean modifyCustomerPhoneAndAddress(Customer customer);

    boolean modifyCustomerStatus(int id);
}
