package com.example.familytree.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.familytree.config.ResponseResult;
import com.example.familytree.entity.EventType;

import java.util.List;

/**
* @author admin
* @description 针对表【event_type】的数据库操作Service
* @createDate 2023-06-28 14:17:50
*/
public interface EventTypeService  {
    //增
    public String insertEventType(EventType eventType);
    //删
    public String delEventType(String id);
    //改
    public String updateEventType(EventType eventType);
    //查
    public List<EventType> selectEventTypeList();
    //不分页 查
    public ResponseResult selectEventTypeListAll();
}
