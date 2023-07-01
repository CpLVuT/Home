package com.example.familytree.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.familytree.config.ResponseResult;
import com.example.familytree.entity.EventType;
import com.example.familytree.entity.Family;

import java.util.List;

/**
* @author admin
* @description 针对表【family】的数据库操作Service
* @createDate 2023-06-28 14:19:11
*/
public interface FamilyService {
    public ResponseResult insertFamily(Family family);
    //删
    public ResponseResult delFamily(String id);
    //改
    public ResponseResult updateFamily(Family family);
    //查
    public ResponseResult selectFamily(String id,Integer limit,Integer page);

}
