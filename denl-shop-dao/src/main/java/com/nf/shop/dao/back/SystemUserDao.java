package com.nf.shop.dao.back;

import com.nf.shop.entity.SystemUser;
import org.apache.ibatis.annotations.Param;

/**
 * @Author:DENG-
 * @Date:2019/12/29 20:38
 */
public interface SystemUserDao {
        SystemUser selectSystemUserByLoginNameAndPassword(@Param("loginName") String loginName,
                                                          @Param("password") String password,
                                                          @Param("isValid") int isValid);
}
