package com.qdc.demoeurekafegin.controller;

import com.qdc.demoeurekafegin.service.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class UserController {

    @Autowired
    private UserClient userClient;
    @RequestMapping(value = "/hi")
    public String hello(){
        return userClient.hello();
    }

    @RequestMapping(value = "/sayHi")
    public String hello(@RequestParam(value = "sleep_seconds")
                                int slepp_seconds){
        return userClient.hello(slepp_seconds);
    }
}
