package com.example.familytree.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.familytree.entity.PersonType;
import org.apache.ibatis.annotations.Mapper;

/**
* @author admin
* @description 针对表【person_type】的数据库操作Mapper
* @Entity .PersonType
*/
@Mapper
public interface PersonTypeMapper extends BaseMapper<PersonType> {

}




