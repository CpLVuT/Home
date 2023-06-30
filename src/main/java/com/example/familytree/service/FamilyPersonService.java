package com.example.familytree.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.familytree.config.ResponseResult;
import com.example.familytree.entity.EventType;
import com.example.familytree.entity.FamilyPerson;
import com.example.familytree.entity.PersonView;

import java.util.List;

/**
* @author admin
* @description 针对表【family_person】的数据库操作Service
* @createDate 2023-06-28 14:19:17
*/
public interface FamilyPersonService {
    public List<PersonView> getHierarchyList(int familyId);

    //增
    public String insertFamilyPerson(FamilyPerson familyPerson);
    //删
    public String delFamilyPerson(String id);
    //改
    public String updateFamilyPerson(FamilyPerson familyPerson);
    //查
    public ResponseResult selectFamilyPerson(Integer limit,Integer page,String id);
}
