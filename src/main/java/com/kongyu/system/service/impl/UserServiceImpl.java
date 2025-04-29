package com.kongyu.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kongyu.entity.dao.UserDao;
import com.kongyu.entity.vo.User;
import com.kongyu.system.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {
    //...

}
