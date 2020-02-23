package com.nf.shop.service.back.impl;

import com.nf.shop.dao.back.SystemUserDao;
import com.nf.shop.entity.SystemUser;
import com.nf.shop.service.back.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:DENG-
 * @Date:2019/12/29 20:46
 */
@Service
public class SystemUserServiceImpl implements SystemUserService {
    @Autowired
    private SystemUserDao systemUserDao;

    @Override
    public SystemUser findSystemUserByLoginNameAndPassword(String loginName, String password) {
        return systemUserDao.selectSystemUserByLoginNameAndPassword(loginName,password,1);
    }
}
