package com.example.familytree.service.impl;



import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.familytree.config.ResponseResult;
import com.example.familytree.entity.Family;
import com.example.familytree.entity.PersonRelation;
import com.example.familytree.entity.PersonRelationView;
import com.example.familytree.mapper.FamilyPersonMapper;
import com.example.familytree.mapper.PersonRelationMapper;
import com.example.familytree.mapper.PersonTypeMapper;
import com.example.familytree.service.PersonRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author admin
* @description 针对表【person_relation】的数据库操作Service实现
* @createDate 2023-06-28 14:19:22
*/
@Service
public class PersonRelationServiceImpl implements PersonRelationService {
    @Resource
    private PersonRelationMapper personRelationMapper;
    @Resource
    private FamilyPersonMapper familyPersonMapper;
    @Resource
    private PersonTypeMapper personTypeMapper;

    @Override
    public ResponseResult personRelationList(String id, Integer limit, Integer page) {
        Page<PersonRelation> page1 = new Page<>(page,limit);
        personRelationMapper.selectPage(page1, Wrappers.lambdaQuery(PersonRelation.class).eq(!StringUtils.isBlank(id),PersonRelation::getId,id));
        //根据id转换name
        List<PersonRelationView> relationViews = page1.getRecords().stream().map(e -> {
            PersonRelationView view = new PersonRelationView();
            String person1Name = familyPersonMapper.selectById(e.getPersonId1()).getName();
            String person2Name = familyPersonMapper.selectById(e.getPersonId2()).getName();
            String personTypeName = personTypeMapper.selectById(e.getPersonTypeId()).getName();
            view.setId(e.getId());
            view.setPersonName1(person1Name);
            view.setPersonName2(person2Name);
            view.setPersonTypeName(personTypeName);
            view.setPersonId1(e.getPersonId1());
            view.setPersonId2(e.getPersonId2());
            view.setPersonTypeId(e.getPersonTypeId());
            view.setIsDel(e.getIsDel());
            return view;
        }).collect(Collectors.toList());
        Page<PersonRelationView> page2 = new Page<>(page,limit);
        page2.setCurrent(page1.getCurrent());
        page2.setTotal(page1.getTotal());
        page2.setSize(page1.getSize());
        page2.setRecords(relationViews);
        return ResponseResult.success(page2);
    }

    @Override
    public ResponseResult insertPersonRelation(PersonRelation personRelation) {
        personRelation.setIsDel("0");
        personRelationMapper.insert(personRelation);
        return ResponseResult.success("");
    }

    @Override
    public ResponseResult updatePersonRelation(PersonRelation personRelation) {
        personRelationMapper.updateById(personRelation);
        return ResponseResult.success("");
    }
}




