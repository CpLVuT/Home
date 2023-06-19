package entity;

public class HomeTree {
    private int HomeTree_Id;
    private String HomeTree_Name;
    private String Inner_Des;
    private int user_no;
    private boolean id_del;
    private String Crea_Time;

    public int getHomeTree_Id() {
        return HomeTree_Id;
    }

    public void setHomeTree_Id(int homeTree_Id) {
        HomeTree_Id = homeTree_Id;
    }

    public String getHomeTree_Name() {
        return HomeTree_Name;
    }

    public void setHomeTree_Name(String homeTree_Name) {
        HomeTree_Name = homeTree_Name;
    }

    public String getInner_Des() {
        return Inner_Des;
    }

    public void setInner_Des(String inner_Des) {
        Inner_Des = inner_Des;
    }

    public int getUser_no() {
        return user_no;
    }

    public void setUser_no(int user_no) {
        this.user_no = user_no;
    }

    public boolean isId_del() {
        return id_del;
    }

    public void setId_del(boolean id_del) {
        this.id_del = id_del;
    }

    public String getCrea_Time() {
        return Crea_Time;
    }

    public void setCrea_Time(String crea_Time) {
        Crea_Time = crea_Time;
    }
}
