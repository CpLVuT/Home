package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.entity.Relation;
import com.example.entity.event;
import com.example.entity.member;
import com.example.mapper.EventMapper;
import com.example.mapper.MemberMapper;
import com.example.mapper.RelationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Controller
public class MemberController {
    /*
    这个部分相关的一些问题 autowired必须要有bean才能注入，
    记得检查下自己前面部分的代码 有没有加对应的注解
     */
    @Autowired
    private EventMapper eventMapper;
    @Autowired
    private RelationMapper relationMapper;
    @Autowired
    private MemberMapper memberMapper;


    //增加
    /*
    在这里完成增删改查
     */
    public String MemberInsert(int Member_Id, String Name, String Sex, String Birth, String Death, int Mother_Id, int Father_ID) {

        return memberMapper.insert(new member(Name, Sex, Birth, Death, Member_Id, Mother_Id, Father_ID)) > 0 ? "成功！" : "失败！";
        //insert函数的返回值本来应当是整数弧，我在这里为了看到结果加了成功或者失败 因而是String类型
    }

    public String RelationInsert(int Member_Id1, int Member_Id2, int Relation_Id, String RelationType) {
        return relationMapper.insert(new Relation(Member_Id1, Member_Id2, Relation_Id, RelationType)) > 0 ? "成功！" : "失败！";
    }

    public String EventInesert(int Member_Id, String Event_Time, int Event_Id, String Events_Des) {
        return eventMapper.insert(new event(Member_Id, Event_Time, Event_Id, Events_Des)) > 0 ? "成功!" : "失败";
    }
    @RequestMapping("/hello1")
    public String test(){
        return "hello";
    }
    //查询列表 这里直接一口气查询所有家谱成员 因为单独查询在Service层里实现了。
    public List<member> MemeberSelect(){
        return memberMapper.selectList(null);
    }
    public List<event> EventSelect(){
        return eventMapper.selectList(null);
    }
    public List<Relation> RelationSelect(){
        return relationMapper.selectList(null);
    }
    //删除特定成员
    public String MemberDel(int Member_id){
        return memberMapper.deleteById(Member_id)>0?"成功！":"失败!";
    }
    //因为要两个参数来找到某人对应时间才可以删除所以 使用bymap删除
    public String EventDel(int Member_Id,int Event_Id){
        Map<String,Object>map=new HashMap<>();
        map.put("Member_Id",Member_Id);
        map.put("Event_Num",Event_Id);
        return eventMapper.deleteByMap(map)>0?"成功！":"失败！";
    }
    //Relation同理
    public String RelationDel(int Member_Id1,int Memebr_Id2){
        Map<String,Object>map = new HashMap<>();
        map.put("Member_Id1",Member_Id1);
        map.put("Member_Id2",Memebr_Id2);
        return relationMapper.deleteByMap(map)>0?"成功!":  "失败!";
    }

    /*
    改这里还有小问题就是 updatebyID这个函数是通过id（主键进行修改的）
    预期将表建成双主键表
    */
    public String UpdateMemeber(member member){
        return memberMapper.updateById(member)>0?"成功！":"失败！";
    }
    public String UpdateEvent(event event){
        return eventMapper.updateById(event)>0?"成功！":"失败！";
    }
    public String UpdateRelation(Relation relation){
        return relationMapper.updateById(relation)>0?"成功！":"失败";
    }


}

