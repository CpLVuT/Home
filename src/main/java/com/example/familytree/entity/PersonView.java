package com.example.familytree.entity;


import lombok.Data;

import java.util.List;
@Data
public class PersonView {
    /*
    用来完成和前端的交互
    一个普通的 展示类
     */
    private  FamilyPerson familyPerson = new FamilyPerson();
    //子级
    List<PersonView> children;
}
