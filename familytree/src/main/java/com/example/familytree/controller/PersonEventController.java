package com.example.familytree.controller;

import com.example.familytree.config.ResponseResult;
import com.example.familytree.entity.PersonEvent;
import com.example.familytree.entity.PersonRelation;
import com.example.familytree.service.PersonEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonEventController {
    @Autowired
    private PersonEventService personEventService;

    //查
    @PostMapping("/personEventList")
    public ResponseResult personEventList(String id, Integer limit, Integer page){
        return personEventService.PersonEventList(id,limit,page);
    }

    //可视化
    @PostMapping("/personEventView")
    public ResponseResult personEventView(String id){
        return personEventService.PersonEventView(id);
    }

    //新增 更新
    //保存更新
    @PostMapping("/submitOrUpdatePersonEvent")
    public ResponseResult submitOrUpdate(@RequestBody PersonEvent personEvent){
        if (personEvent.getId() == null){
            return personEventService.insertPersonEvent(personEvent);
        }
        return personEventService.updatePersonEvent(personEvent);
    }

    //删
    @PostMapping("/delPersonEvent")
    public ResponseResult delPersonEvent(String id){
        return personEventService.delPersonEvent(id);
    }



}
