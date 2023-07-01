package com.example.familytree.controller;

import com.example.familytree.config.ResponseResult;
import com.example.familytree.entity.Family;
import com.example.familytree.entity.FamilyPerson;
import com.example.familytree.service.FamilyPersonService;
import com.example.familytree.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FamilyPersonController {
    @Autowired
    private FamilyPersonService familyPersonService;

    //增
    @PostMapping("/insertFamilyPerson")
    public String insertFamilyPerson(FamilyPerson familyPerson){
        return familyPersonService.insertFamilyPerson(familyPerson);
    }
    //删
    @PostMapping("/delFamilyPerson")
    public String delFamilyPerson(String id){
        return familyPersonService.delFamilyPerson(id);
    }
    //改
    @PostMapping("/submitOrUpdateFamilyPerson")
    public ResponseResult updateFamilyPerson(@RequestBody FamilyPerson familyPerson){
        if (familyPerson.getId() == null){
            familyPersonService.insertFamilyPerson(familyPerson);
        }else{
            familyPersonService.updateFamilyPerson(familyPerson);
        }
        return ResponseResult.success(null);
    }
    //查
    @PostMapping("/familyPersonList")
    public ResponseResult familyPersonList(Integer limit,Integer page,String id){
        return familyPersonService.selectFamilyPerson(limit,page,id);
    }

    //不分页查询全部
    @PostMapping("familyPersonListAll")
    public ResponseResult familyPersonListAll(){
        return familyPersonService.selectFamilyPersonAll();
    }
}
