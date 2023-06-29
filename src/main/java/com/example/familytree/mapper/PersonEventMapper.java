package com.example.familytree.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.familytree.entity.PersonEvent;
import org.apache.ibatis.annotations.Mapper;

/**
* @author admin
* @description 针对表【person_event】的数据库操作Mapper
* @Entity .PersonEvent
*/
@Mapper
public interface PersonEventMapper extends BaseMapper<PersonEvent> {

}




