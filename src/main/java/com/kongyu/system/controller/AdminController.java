package com.kongyu.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Luojun
 * @version v1.0.0
 * @since 2024/5/15
 */

@RestController
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/test.action")
    public String test() {
        return "{msg: 'hello word!!!'}";
    }

}
