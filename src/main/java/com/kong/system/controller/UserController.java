package com.kong.system.controller;

import com.kong.core.common.model.ResponseCode;
import com.kong.core.common.model.Result;
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
    public Result<String> test() {
        return Result.success("Hello World");
    }

    @RequestMapping("/get/{id}")
    public Object getUserById(@PathVariable(name = "id") Integer id) {
        return userService.getById(id);
    }

    @RequestMapping("/demo")
    public ResponseCode demo(){
        return ResponseCode.CREATED;
    }

}
