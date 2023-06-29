package com.example.familytree.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.familytree.entity.FamilyPerson;
import com.example.familytree.entity.PersonView;
import com.example.familytree.service.FamilyPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController("/api/family")
public class BaseControler {
    @Autowired
    private FamilyPersonService familyPersonService;

    //可视化图所需数据 传入参数是对应家族的id
    @GetMapping("/getHierarchyList")
    public List<PersonView> getHierarchyList(@RequestParam int familyId){
            return familyPersonService.getHierarchyList(familyId);
    }
}
