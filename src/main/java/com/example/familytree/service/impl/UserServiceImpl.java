package com.example.familytree.service.impl;



import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.familytree.config.ResponseResult;
import com.example.familytree.entity.User;
import com.example.familytree.mapper.UserMapper;
import com.example.familytree.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Wrapper;

/**
* @author admin
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-06-28 14:19:28
*/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;


    @Override
    public ResponseResult loginUser(String username, String password) {
        User user = userMapper.selectOne(Wrappers.lambdaQuery(User.class).eq(User::getUsername,username).eq(User::getPassword,password));
        if (user == null){
            return ResponseResult.fail("账户或密码错误");
        }
        return ResponseResult.success(null,"登录成功");
    }

    @Override
    public String registerUser(String username, String password) {
        User user = userMapper.selectOne(Wrappers.lambdaQuery(User.class).eq(User::getUsername,username));
        if (user != null){
            return "用户名已注册!";
        }
        user.setUsername(username);
        user.setPassword(password);
        userMapper.insert(user);
        return "注册成功";
    }
}




