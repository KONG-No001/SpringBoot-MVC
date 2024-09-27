package com.kong.system.controller;

import com.kong.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping("/test.action")
    public String test() {
        return "{msg: 'hello word!!!'}";
    }

    @RequestMapping("/get/{id}")
    public Object getUserById(@PathVariable(name = "id") Integer id) {
        return userService.getById(id);
    }

}
