package com.example.familytree.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.familytree.entity.PersonEvent;
import org.apache.ibatis.annotations.Mapper;

/**
* @author admin
* @description 针对表【person_event】的数据库操作Mapper
* @createDate 2023-06-28 14:19:20
* @Entity .PersonEvent
*/
@Mapper
public interface PersonEventMapper extends BaseMapper<PersonEvent> {

}




