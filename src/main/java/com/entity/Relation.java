package com.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
/*
用于判断同级 任意两人关系的表
只有一种离异的情况需要改变
剩下情况只考虑 生理父母
 */
public class Relation {
    private int Member_Id1;
    private int Member_Id2;
    private int Relation_Id;
    private String RelationType;
    private boolean id_del;
}
