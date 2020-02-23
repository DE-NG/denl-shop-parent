package com.nf.shop.service.front.impl;

import com.nf.shop.dao.front.CustomerDao;
import com.nf.shop.entity.Customer;
import com.nf.shop.exception.CustomerNotFoundException;
import com.nf.shop.exception.LoginErrorException;
import com.nf.shop.service.front.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @Author:DENG-
 * @Date:2019/12/9 15:23
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public Customer login(String phone, String password) {
        Customer customer = customerDao.selectByPhoneAndPassword(phone,password,1);
        if (customer == null){
            throw new LoginErrorException("登录失败，手机号或者密码错误");
        }
        return customer;
    }

    /**
     * 根据手机号查找用户
     * @param phone
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    @Override
    public boolean findByPhone(String phone) {
        Customer customer = customerDao.selectByPhone(phone);
        if (customer == null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Customer register(Customer customer) {
        int rows = customerDao.insertCustomer(customer);
        if (rows > 0){
            return customer;
        }else {
            return null;
        }
    }

    /**
     * 根据ID查找用户
     * @param id
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    public Customer findCustomerById(int id) {
        Customer customer = customerDao.selectCustomerById(id);
        if (ObjectUtils.isEmpty(customer)){
            throw new CustomerNotFoundException("用户不存在");
        }
        return customer;
    }

    /**
     * 修改用户密码
     * @param customer
     * @return
     */
    @Override
    public boolean modifyCustomerPassword(Customer customer) {
        int rows = customerDao.updateCustomerPassword(customer);
        if (rows > 0 ){
            return true;
        }
        return false;
    }

    /**
     * 修改用户信息
     * @param customer
     * @return
     */
    @Override
    public boolean modifyCustomer(Customer customer) {
        int rows = customerDao.updateCustomer(customer);
        if (rows > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<Customer> findAllCustomer(int pageNum, int pageSize) {
        return customerDao.selectAllCustomer(pageNum, pageSize);
    }

    @Override
    public boolean modifyCustomerPhoneAndAddress(Customer customer) {
        return customerDao.updateCustomerPhoneAndAddress(customer) > 0 ?true : false;
    }

    @Override
    public boolean modifyCustomerStatus(int id) {
        return customerDao.updateCustomerStatus(id) > 0 ?true:false;
    }
}
