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
import java.util.*;
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
    public ResponseResult getHierarchyList(int familyId) {
        Map<String,Object> treeData = new HashMap<>();
        // 根据家族ID获取全部人员
        List<FamilyPerson> allPersonList = familyPersonMapper.selectList(Wrappers.lambdaQuery(FamilyPerson.class).eq(FamilyPerson::getFamilyId, familyId));

        // 找到根节点，即ID最小人员为根节点
        FamilyPerson rootPerson = allPersonList.stream().min(Comparator.comparing(FamilyPerson::getId)).orElse(null);
        treeData.put("name",rootPerson.getName());
        treeData.put("image_url",rootPerson.getAvatar());
        //创建根list
        List<PersonView> rootPersonList = new ArrayList<>();
        if (rootPerson != null) {
            // 获取顶层人员的妻子
            List<FamilyPerson> siblingList = familyPersonMapper.getTongjiPersonList(rootPerson.getId());
            Map<String,Object> meta = new HashMap<>();
            meta.put("name",siblingList.get(0).getName());
            meta.put("image_url",siblingList.get(0).getAvatar());
            //妻子添加到顶层Map
            treeData.put("mate",meta);
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
            //构建children
            List<HashMap> childrens = new ArrayList<>();
            treeData.put("children",childrens);
            // 递归构建层级列表，从根节点开始
            buildHierarchy(rootPersonList, (List<HashMap>) treeData.get("children"));

        }

        return ResponseResult.success(treeData);
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
        //TODO 删除时要判断关系表内是否存在该成员
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

    @Override
    public ResponseResult selectFamilyPersonAll() {
        List<FamilyPerson> familyPersonList = familyPersonMapper.selectList(Wrappers.lambdaQuery(FamilyPerson.class));
        return ResponseResult.success(familyPersonList);
    }

    private void buildHierarchy(List<PersonView> rootPeronViewList,List<HashMap> map) {
        for (PersonView parentView:rootPeronViewList) {
            //根据父级id获取子级list
            List<FamilyPerson> childList = familyPersonMapper.getZijiPersonList(parentView.getFamilyPerson().getId());
            //转换为View
            List<PersonView> childViewList = new ArrayList<>();
            for (FamilyPerson child : childList){
                PersonView view = new PersonView();
                view.setFamilyPerson(child);
                childViewList.add(view);
                //
                Map childMap = new HashMap();
                childMap.put("name",child.getName());
                childMap.put("image_url",child.getAvatar());
                List<FamilyPerson> tongjiList = familyPersonMapper.getTongjiPersonList(child.getId());
                if (tongjiList.size() > 0){
                    Map meta = new HashMap();
                    meta.put("name",tongjiList.get(0).getName());
                    meta.put("image_url",tongjiList.get(0).getAvatar());
                    childMap.put("mate",meta);
                }
                //构建子级
                List<HashMap> childrens = new ArrayList<>();
                childMap.put("children",childrens);
                //递归
                buildHierarchy(childViewList,childrens);
                map.add((HashMap) childMap);
            }

        }
    }

}




