package com.example.familytree.service.impl;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.familytree.config.ResponseResult;
import com.example.familytree.entity.FamilyPerson;
import com.example.familytree.entity.PersonView;
import com.example.familytree.mapper.FamilyPersonMapper;
import com.example.familytree.service.FamilyPersonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author admin
* @description 针对表【family_person】的数据库操作Service实现
* @createDate 2023-06-28 14:19:17
*/
@Service
public class FamilyPersonServiceImpl implements FamilyPersonService {
    @Resource
    private FamilyPersonMapper familyPersonMapper;
    @Override
    public List<PersonView> getHierarchyList(int familyId) {
        // 根据家族ID获取全部人员
        List<FamilyPerson> allPersonList = familyPersonMapper.selectList(Wrappers.lambdaQuery(FamilyPerson.class).eq(FamilyPerson::getFamilyId, familyId));

        // 找到根节点，即ID最小人员为根节点
        FamilyPerson rootPerson = allPersonList.stream().min(Comparator.comparing(FamilyPerson::getId)).orElse(null);
        //创建根list
        List<PersonView> rootPersonList = new ArrayList<>();
        if (rootPerson != null) {
            // 获取同级人员列表
            List<FamilyPerson> siblingList = familyPersonMapper.getTongjiPersonList(rootPerson.getId());

            //同级人员添加到根list
            for (FamilyPerson person : siblingList){
                PersonView personView = new PersonView();
                personView.setFamilyPerson(person);
                rootPersonList.add(personView);
            }

            // 构建根节点的PersonView对象
            PersonView rootPersonView = new PersonView();
            rootPersonView.setFamilyPerson(rootPerson);
            rootPersonView.setChildren(new ArrayList<>());

            rootPersonList.add(rootPersonView);

            // 递归构建层级列表，从根节点开始
            buildHierarchy(rootPersonList);

        }

        return rootPersonList;
    }

    @Override
    public String insertFamilyPerson(FamilyPerson familyPerson) {
        if (familyPerson.getSex().equals("男")){
            familyPerson.setSex("M");
        }else{
            familyPerson.setSex("F");
        }
        familyPerson.setIsDel("0");
        familyPersonMapper.insert(familyPerson);
        return "新增成功";
    }

    @Override
    public String delFamilyPerson(String id) {
        familyPersonMapper.deleteById(id);
        return "删除成功";
    }

    @Override
    public String updateFamilyPerson(FamilyPerson familyPerson) {
        familyPersonMapper.updateById(familyPerson);
        return "更新成功";
    }

    @Override
    public ResponseResult selectFamilyPerson(Integer limit,Integer page,String id) {
        Page<FamilyPerson> page1 = new Page<>(page,limit);
        familyPersonMapper.selectPage(page1,Wrappers.lambdaQuery(FamilyPerson.class).eq(!StringUtils.isBlank(id),FamilyPerson::getId,id));
        //转换下性别
        page1.getRecords().stream().map(e -> {
           if (e.getSex().equals("M")){
               e.setSex("男");
           }else{
               e.setSex("女");
           }
           return e;
        }).collect(Collectors.toList());
        return ResponseResult.success(page1);
    }

    private void buildHierarchy(List<PersonView> rootPeronViewList) {
        for (PersonView parentView:rootPeronViewList) {
            //根据父级id获取子级list
            List<FamilyPerson> childList = familyPersonMapper.getZijiPersonList(parentView.getFamilyPerson().getId());
            //转换为View
            List<PersonView> childViewList = new ArrayList<>();
            for (FamilyPerson child : childList){
                PersonView view = new PersonView();
                view.setFamilyPerson(child);
                childViewList.add(view);
            }
           for(PersonView child :childViewList){
               //构建同级
               List<FamilyPerson> tongjiList = familyPersonMapper.getTongjiPersonList(child.getFamilyPerson().getId());
               List<PersonView> zijiList = new ArrayList<>();
               zijiList.add(child);
               for (FamilyPerson ziji : tongjiList){
                   PersonView personView = new PersonView();
                   personView.setFamilyPerson(ziji);
                   zijiList.add(personView);
               }
               parentView.setChildren(zijiList);
                buildHierarchy(zijiList);
           }
           parentView.setChildren(childViewList);
        }
    }

}




