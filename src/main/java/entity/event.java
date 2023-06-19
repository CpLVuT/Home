package entity;

import java.security.PrivateKey;

public class event {
    private int Member_Id;
    private String Event_Time;
    private int Event_Num;//直接使用分项目id代替事件类型；
    private String Event_Des;
    private boolean id_del;

    public int getMember_Id() {
        return Member_Id;
    }

    public void setMember_Id(int member_Id) {
        Member_Id = member_Id;
    }

    public String getEvent_Time() {
        return Event_Time;
    }

    public void setEvent_Time(String event_Time) {
        Event_Time = event_Time;
    }

    public int getEvent_Num() {
        return Event_Num;
    }

    public void setEvent_Num(int event_Num) {
        Event_Num = event_Num;
    }

    public String getEvent_Des() {
        return Event_Des;
    }

    public void setEvent_Des(String event_Des) {
        Event_Des = event_Des;
    }

    public boolean isId_del() {
        return id_del;
    }

    public void setId_del(boolean id_del) {
        this.id_del = id_del;
    }
}
