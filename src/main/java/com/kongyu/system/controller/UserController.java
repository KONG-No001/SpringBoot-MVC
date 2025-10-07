package com.kongyu.system.controller;

import com.kongyu.core.common.model.ResponseCode;
import com.kongyu.core.common.model.Result;
import com.kongyu.system.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IAccountService userService;

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
