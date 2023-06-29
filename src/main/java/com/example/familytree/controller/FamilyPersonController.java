package com.example.familytree.controller;

import com.example.familytree.entity.Family;
import com.example.familytree.entity.FamilyPerson;
import com.example.familytree.service.FamilyPersonService;
import com.example.familytree.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping("/updateFamilyPerson")
    public String updateFamilyPerson(FamilyPerson familyPerson){
        return familyPersonService.updateFamilyPerson(familyPerson);
    }
    //查
    @GetMapping("/familyPersonList")
    public List<FamilyPerson> familyPersonList(){
        return familyPersonService.selectFamilyPerson();
    }
}
