package com.example.familytree.service.impl;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.familytree.config.ResponseResult;
import com.example.familytree.entity.EventType;
import com.example.familytree.entity.Family;
import com.example.familytree.mapper.FamilyMapper;
import com.example.familytree.service.FamilyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
    public ResponseResult insertFamily(Family family) {
        family.setUserId(1);
        family.setCreateTime(new Date());
        family.setIsDel("0");
        familyMapper.insert(family);
        return ResponseResult.success("新增成功");
    }

    @Override
    public ResponseResult delFamily(String id) {
        familyMapper.deleteById(id);
        return ResponseResult.success("");
    }

    @Override
    public ResponseResult updateFamily(Family family) {
        familyMapper.updateById(family);
        return ResponseResult.success(null);
    }

    @Override
    public ResponseResult selectFamily(String id,Integer limit,Integer page) {
        Page<Family> page1 = new Page<>(page,limit);
        familyMapper.selectPage(page1,Wrappers.lambdaQuery(Family.class).eq(!StringUtils.isBlank(id),Family::getId,id));

        return ResponseResult.success(page1);
    }
}




