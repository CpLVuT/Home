package com.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
    private int Member_Id;//
    private String Event_Time;
    private int Event_Num;//直接使用分项目id代替事件类型；
    private String Event_Des;

}