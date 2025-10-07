package com.kongyu.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kongyu.entity.mapper.AccountMapper;
import com.kongyu.entity.vo.Account;
import com.kongyu.system.service.IAccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

    @Override
    public Account getByUserName(String username) {
        return getOne(lambdaQuery().eq(Account::getUsername, username).getWrapper());
    }

    //...

}
