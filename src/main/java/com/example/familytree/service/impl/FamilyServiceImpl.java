package com.example.familytree.service.impl;



import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.familytree.entity.EventType;
import com.example.familytree.entity.Family;
import com.example.familytree.mapper.FamilyMapper;
import com.example.familytree.service.FamilyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author admin
* @description 针对表【family】的数据库操作Service实现
* @createDate 2023-06-28 14:19:11
*/
@Service
public class FamilyServiceImpl implements FamilyService {
    @Resource
    private FamilyMapper familyMapper;

    @Override
    public String insertFamily(Family family) {
        familyMapper.insert(family);
        return "新增成功";
    }

    @Override
    public String delFamily(String id) {
        familyMapper.deleteById(id);
        return "删除成功";
    }

    @Override
    public String updateFamily(Family family) {
        familyMapper.updateById(family);
        return "更新成功";
    }

    @Override
    public List<Family> selectFamily() {
        return familyMapper.selectList(Wrappers.lambdaQuery(Family.class));
    }
}




