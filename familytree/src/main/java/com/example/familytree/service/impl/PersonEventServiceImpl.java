package com.example.familytree.service.impl;



import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.familytree.config.ResponseResult;
import com.example.familytree.entity.*;
import com.example.familytree.mapper.EventTypeMapper;
import com.example.familytree.mapper.FamilyPersonMapper;
import com.example.familytree.mapper.PersonEventMapper;
import com.example.familytree.service.PersonEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author admin
* @description 针对表【person_event】的数据库操作Service实现
* @createDate 2023-06-28 14:19:20
*/
@Service
@Slf4j
public class PersonEventServiceImpl implements PersonEventService {
    @Resource
    private PersonEventMapper personEventMapper;
    @Resource
    private FamilyPersonMapper familyPersonMapper;
    @Resource
    private EventTypeMapper eventTypeMapper;

    @Override
    public ResponseResult PersonEventList(String id, Integer limit, Integer page) {
        Page<PersonEvent> page1 = new Page<>(page,limit);
        personEventMapper.selectPage(page1, Wrappers.lambdaQuery(PersonEvent.class).eq(!StringUtils.isBlank(id),PersonEvent::getId,id));
        List<PersonEventView> eventViewList = page1.getRecords().stream().map(e -> {
            PersonEventView eventView = new PersonEventView();
            eventView.setId(e.getId());
            FamilyPerson person = familyPersonMapper.selectOne(Wrappers.lambdaQuery(FamilyPerson.class).eq(FamilyPerson::getId,e.getPersonId()));
            eventView.setPersonId(e.getPersonId());
            eventView.setPersonName(person.getName());
            eventView.setEventDate(e.getEventDate());
            EventType eventType = eventTypeMapper.selectOne(Wrappers.lambdaQuery(EventType.class).eq(EventType::getId,e.getTypeId()));
            eventView.setTypeId(String.valueOf(e.getTypeId()));
            eventView.setTypeName(eventType.getName());
            eventView.setEventDesc(e.getEventDesc());
            return eventView;
        }).collect(Collectors.toList());
        Page<PersonEventView> page2 = new Page<>();
        page2.setCurrent(page1.getCurrent());
        page2.setTotal(page1.getTotal());
        page2.setSize(page1.getSize());
        page2.setRecords(eventViewList);
        return ResponseResult.success(page2);
    }

    @Override
    public ResponseResult insertPersonEvent(PersonEvent personEvent) {
        personEvent.setIsDel("0");
        return ResponseResult.success(personEventMapper.insert(personEvent));
    }

    @Override
    public ResponseResult updatePersonEvent(PersonEvent personEvent) {
        return ResponseResult.success(personEventMapper.updateById(personEvent));
    }

    @Override
    public ResponseResult delPersonEvent(String id) {
        return ResponseResult.success(personEventMapper.deleteById(id));
    }

    @Override
    public ResponseResult PersonEventView(String id) {
        log.info(String.valueOf(StringUtils.isBlank(id)));
        List<PersonEvent> personEvents = new ArrayList<>();
        if (!StringUtils.isBlank(id)){
            personEvents = personEventMapper.selectList(Wrappers.lambdaQuery(PersonEvent.class).eq(PersonEvent::getPersonId,id));
        }

        List<PersonEventView> personEventViews = personEvents.stream().map(e -> {
            PersonEventView view = new PersonEventView();
            view.setEventDate(e.getEventDate());
            //获取类型名称
            EventType eventType =  eventTypeMapper.selectOne(Wrappers.lambdaQuery(EventType.class).eq(EventType::getId,e.getTypeId()));
            view.setTypeName(eventType.getName());
            return view;
        }).collect(Collectors.toList());
        return ResponseResult.success(personEventViews);
    }
}




