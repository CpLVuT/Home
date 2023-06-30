package com.example.familytree.entity;


import lombok.Data;

import java.util.List;
@Data
public class PersonView {
    private  FamilyPerson familyPerson = new FamilyPerson();
    //子级
    List<PersonView> children;
}
