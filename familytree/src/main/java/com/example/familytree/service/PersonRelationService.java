package com.example.familytree.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.familytree.config.ResponseResult;
import com.example.familytree.entity.PersonRelation;

/**
* @author admin
* @description 针对表【person_relation】的数据库操作Service
* @createDate 2023-06-28 14:19:22
*/
public interface PersonRelationService {
    ResponseResult personRelationList(String id, Integer limit, Integer page);

    ResponseResult insertPersonRelation(PersonRelation personRelation);

    ResponseResult updatePersonRelation(PersonRelation personRelation);

}
