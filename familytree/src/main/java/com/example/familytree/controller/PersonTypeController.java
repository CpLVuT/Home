package com.example.familytree.controller;

import com.example.familytree.config.ResponseResult;
import com.example.familytree.mapper.PersonTypeMapper;
import com.example.familytree.service.PersonRelationService;
import com.example.familytree.service.PersonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonTypeController {

    @Autowired
    private PersonTypeService personTypeService;

    //查
    @PostMapping("/personTypeList")
    public ResponseResult personTypeList(String id, Integer limit, Integer page){
        return personTypeService.personTypeList(id,limit,page);
    }

    //不分页查全部
    @PostMapping("/personTypeListAll")
    public ResponseResult personTypeListAll(){
        return personTypeService.personTypeListAll();
    }
}
