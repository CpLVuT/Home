package com.example.familytree.service.impl;



import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.familytree.config.ResponseResult;
import com.example.familytree.entity.PersonRelation;
import com.example.familytree.entity.PersonType;
import com.example.familytree.mapper.PersonTypeMapper;
import com.example.familytree.service.PersonTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author admin
* @description 针对表【person_type】的数据库操作Service实现
* @createDate 2023-06-28 14:19:25
*/
@Service
public class PersonTypeServiceImpl implements PersonTypeService {
    @Resource
    private PersonTypeMapper personTypeMapper;

    @Override
    public ResponseResult personTypeList(String id, Integer limit, Integer page) {
        Page<PersonType> page1 = new Page<>(page,limit);
        personTypeMapper.selectPage(page1, Wrappers.lambdaQuery(PersonType.class).eq(!StringUtils.isBlank(id),PersonType::getId,id));
        return ResponseResult.success(page1);
    }

    @Override
    public ResponseResult personTypeListAll() {
        return ResponseResult.success(personTypeMapper.selectList(Wrappers.lambdaQuery(PersonType.class)));
    }
}




