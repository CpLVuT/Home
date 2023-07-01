package com.example.familytree.controller;

import com.example.familytree.config.ResponseResult;
import com.example.familytree.entity.EventType;
import com.example.familytree.service.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventTypeController {
    @Autowired
    private EventTypeService eventTypeService;

    //增
    @PostMapping("/insertEventType")
    public String insertEventType(EventType eventType){
        return eventTypeService.insertEventType(eventType);
    }
    //删
    @PostMapping("/delEventType")
    public String delEventType(String id){
        return eventTypeService.delEventType(id);
    }
    //改
    @PostMapping("/updateEventType")
    public String updateEventType(EventType eventType){
        return eventTypeService.updateEventType(eventType);
    }
    //查
    @GetMapping("eventTypeList")
    public List<EventType> eventTypeList(){
        return eventTypeService.selectEventTypeList();
    }

    //不分页 查
    @PostMapping("/eventTypeListAll")
    public ResponseResult eventTypeListAll(){
        return eventTypeService.selectEventTypeListAll();

    }
}
