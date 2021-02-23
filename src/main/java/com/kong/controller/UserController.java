package com.kong.controller;

import com.kong.service.IUserService;
import com.kong.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping("/test.action")
    @ResponseBody
    public String test(){
        return "{msg: 'hello word!!!'}";
    }

}
