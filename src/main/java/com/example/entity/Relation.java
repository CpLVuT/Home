package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Data
@Accessors(chain = true)
/*
用于判断同级 任意两人关系的表
只有一种离异的情况需要改变
剩下情况只考虑 现在的父母 同辈 和毫无关系的陌生人
按照顺序为 1 2 0
由于限制了主键id1必须是小辈，所以无子辈关系。
 */
@AllArgsConstructor
@NoArgsConstructor//无参构造注解
//@TableName("Relation")
public class Relation {
    @TableId(value = "Member_Id1",type = IdType.INPUT)
    private Integer Member_Id1;
    private int Member_Id2;
    private int Relation_Id;
    private String RelationType;
}
