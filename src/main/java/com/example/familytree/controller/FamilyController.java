package com.example.familytree.controller;

import com.example.familytree.entity.EventType;
import com.example.familytree.entity.Family;
import com.example.familytree.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FamilyController {
    @Autowired
    private FamilyService familyService;

    //增
    @PostMapping("/insertFamily")
    public String insertFamily(Family family){
        return familyService.insertFamily(family);
    }
    //删
    @PostMapping("/delFamily")
    public String delFamily(String id){
        return familyService.delFamily(id);
    }
    //改
    @PostMapping("/updateFamily")
    public String updateFamily(Family family){
        return familyService.updateFamily(family);
    }
    //查
    @GetMapping("familyList")
    public List<Family> familyList(){
        return familyService.selectFamily();
    }
}
