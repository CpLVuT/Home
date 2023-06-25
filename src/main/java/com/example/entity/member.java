package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor//无参构造注解
@TableName("member")
public class  member {
    private String Name;
    private String Sex;
    private String Birth;
    private String Death;
    @TableId(value = "Member_Id",type = IdType.INPUT)
    private Integer Member_Id;
    private int Mother_ID;
    private int Father_ID;//如果到了最下方 则两个都为0
}
