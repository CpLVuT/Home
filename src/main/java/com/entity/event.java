package com.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class event {
    private int Member_Id;
    private String Event_Time;
    private int Event_Num;//直接使用分项目id代替事件类型；
    private String Event_Des;
    private boolean id_del;

}
