package com.example.familytree.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.familytree.entity.Family;
import org.apache.ibatis.annotations.Mapper;


/**
* @author admin
* @description 针对表【family】的数据库操作Mapper
* @Entity .Family
*/
@Mapper
public interface FamilyMapper extends BaseMapper<Family> {

}




