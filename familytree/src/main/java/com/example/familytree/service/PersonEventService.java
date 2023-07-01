package com.example.familytree.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.familytree.config.ResponseResult;
import com.example.familytree.entity.PersonEvent;

/**
* @author admin
* @description 针对表【person_event】的数据库操作Service
* @createDate 2023-06-28 14:19:20
*/
public interface PersonEventService {
    ResponseResult PersonEventList(String id, Integer limit, Integer page);

    ResponseResult insertPersonEvent(PersonEvent personEvent);

    ResponseResult updatePersonEvent(PersonEvent personEvent);

    ResponseResult delPersonEvent(String id);

    ResponseResult PersonEventView(String id);
}
