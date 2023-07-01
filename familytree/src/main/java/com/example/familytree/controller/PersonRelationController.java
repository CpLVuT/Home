package com.example.familytree.controller;

import com.example.familytree.config.ResponseResult;
import com.example.familytree.entity.Family;
import com.example.familytree.entity.PersonRelation;
import com.example.familytree.service.PersonRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonRelationController {
    @Autowired
    private PersonRelationService personRelationService;

    //查
    @PostMapping("/personRelationList")
    public ResponseResult personRelationList(String id, Integer limit, Integer page){
        return personRelationService.personRelationList(id,limit,page);
    }
    //保存更新
    @PostMapping("/submitOrUpdatePersonRelation")
    public ResponseResult submitOrUpdate(@RequestBody PersonRelation personRelation){
        if (personRelation.getId() == null){
            return personRelationService.insertPersonRelation(personRelation);
        }
        return personRelationService.updatePersonRelation(personRelation);
    }
}
