package com.example.familytree.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.familytree.entity.PersonRelation;
import org.apache.ibatis.annotations.Mapper;

/**
* @author admin
* @description 针对表【person_relation】的数据库操作Mapper
* @createDate 2023-06-28 14:19:22
* @Entity .PersonRelation
*/
@Mapper
public interface PersonRelationMapper extends BaseMapper<PersonRelation> {

}




