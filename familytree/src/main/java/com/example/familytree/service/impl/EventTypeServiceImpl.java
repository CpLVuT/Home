package com.example.familytree.service.impl;



import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.familytree.config.ResponseResult;
import com.example.familytree.entity.EventType;
import com.example.familytree.mapper.EventTypeMapper;
import com.example.familytree.service.EventTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author admin
* @description 针对表【event_type】的数据库操作Service实现
* @createDate 2023-06-28 14:17:50
*/
@Service
public class EventTypeServiceImpl  implements EventTypeService {
    @Resource
    private EventTypeMapper eventTypeMapper;

    @Override
    public String insertEventType(EventType eventType) {
        eventTypeMapper.insert(eventType);
        return "新增成功";
    }

    @Override
    public String delEventType(String id) {
        eventTypeMapper.deleteById(id);
        return "删除成功";
    }

    @Override
    public String updateEventType(EventType eventType) {
        eventTypeMapper.updateById(eventType);
        return "更新成功";
    }

    @Override
    public List<EventType> selectEventTypeList() {
        return eventTypeMapper.selectList(Wrappers.lambdaQuery(EventType.class));
    }

    @Override
    public ResponseResult selectEventTypeListAll() {
        return ResponseResult.success(eventTypeMapper.selectList(Wrappers.lambdaQuery(EventType.class)));
    }
}




