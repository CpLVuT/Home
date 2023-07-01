package com.example.familytree.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.familytree.entity.EventType;
import org.apache.ibatis.annotations.Mapper;

/**
* @author admin
* @description 针对表【event_type】的数据库操作Mapper
* @createDate 2023-06-28 14:17:50
* @Entity .EventType
*/
@Mapper
public interface EventTypeMapper extends BaseMapper<EventType> {

}




