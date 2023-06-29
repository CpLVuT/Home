package com.example.familytree.controller;


import com.example.familytree.config.ResponseResult;
import com.example.familytree.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //登录接口
    @PostMapping("/login")
    public ResponseResult login(@RequestParam(value = "username") String username,@RequestParam(value = "password") String password){
        return userService.loginUser(username,password);
    }

    //注册
    @PostMapping("/register")
    public String register(String username,String password){
        return userService.registerUser(username,password);
    }
}
