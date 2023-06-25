package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;


@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor//无参构造注解
@TableName("event")
public class event {
    /*
    一个人可以经历多种
    不同的事件 但是某个人和某件事情要一一对应
    所以使用了 联合主键
     */
    @MppMultiId
    private Integer Member_Id;//
    private String Event_Time;
    @MppMultiId
    private int Event_Num;//直接使用分项目id代替事件类型；
    private String Event_Des;

}
