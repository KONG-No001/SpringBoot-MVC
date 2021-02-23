package com.kong.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kong.dao.UserDao;
import com.kong.service.IUserService;
import com.kong.vo.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {
    //...

}
