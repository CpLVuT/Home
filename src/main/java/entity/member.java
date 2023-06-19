package entity;

import java.util.List;

public class member{
    private String Name;
    private String Sex;
    private String Birth;
    private String Death;
    private boolean id_del;
    private int Member_Id;
    private int HomeTree_Id;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getBirth() {
        return Birth;
    }

    public void setBirth(String birth) {
        Birth = birth;
    }

    public String getDeath() {
        return Death;
    }

    public void setDeath(String death) {
        Death = death;
    }


    public boolean isId_del() {
        return id_del;
    }

    public void setId_del(boolean id_del) {
        this.id_del = id_del;
    }

    public int getMember_Id() {
        return Member_Id;
    }

    public void setMember_Id(int member_Id) {
        Member_Id = member_Id;
    }

    public int getHomeTree_Id() {
        return HomeTree_Id;
    }

    public void setHomeTree_Id(int homeTree_Id) {
        HomeTree_Id = homeTree_Id;
    }
}
