package com.example.familytree.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.familytree.entity.EventType;
import org.apache.ibatis.annotations.Mapper;

/**
* @author admin
* @description 针对表【event_type】的数据库操作Mapper
* @Entity .EventType
*/
@Mapper
public interface EventTypeMapper extends BaseMapper<EventType> {

}




