package com.nf.shop.service.back;

import com.nf.shop.entity.SystemUser;

/**
 * @Author:DENG-
 * @Date:2019/12/29 20:45
 */
public interface SystemUserService {
    SystemUser findSystemUserByLoginNameAndPassword(String loginName, String password);
}
