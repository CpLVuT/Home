package com.example.familytree.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.familytree.config.ResponseResult;

/**
* @author admin
* @description 针对表【person_type】的数据库操作Service
* @createDate 2023-06-28 14:19:25
*/
public interface PersonTypeService {
    ResponseResult personTypeList(String id, Integer limit, Integer page);

    ResponseResult personTypeListAll();

}
