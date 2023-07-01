package com.example.familytree.controller;

import com.example.familytree.config.ResponseResult;
import com.example.familytree.entity.EventType;
import com.example.familytree.entity.Family;
import com.example.familytree.service.FamilyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class FamilyController {
    @Autowired
    private FamilyService familyService;


    //删
    @PostMapping("/delFamily")
    public ResponseResult delFamily(String id){
        return familyService.delFamily(id);
    }

    //查
    @PostMapping("familyList")
    public ResponseResult familyList(String id,Integer limit,Integer page){
        return familyService.selectFamily(id,limit,page);
    }
    //插入或者更改的函数 如果不存在则更改。
    @PostMapping("/submitOrUpdateFamily")
    public ResponseResult submitOrUpdate(@RequestBody Family family){
         if (family.getId() == null){
             return familyService.insertFamily(family);
         }
        return familyService.updateFamily(family);
    }
}
