package com.example.familytree.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.familytree.config.ResponseResult;

/**
* @author admin
* @description 针对表【user】的数据库操作Service
* @createDate 2023-06-28 14:19:28
*/
public interface UserService {
    public ResponseResult loginUser(String username, String password);

    public String registerUser(String username,String password);
}
