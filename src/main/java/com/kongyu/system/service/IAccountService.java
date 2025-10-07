package com.kongyu.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kongyu.entity.vo.Account;

public interface IAccountService extends IService<Account> {

    /**
     * 根据用户名查询
     *
     * @param username 用户名
     * @return 查询的账户，未查询到则返回null
     */
    Account getByUserName(String username);
    //...

}
