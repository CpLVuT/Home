package entity;

public class user {
    private String user_name;
    private int user_no;
    private String password;
    private boolean id_del;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getUser_no() {
        return user_no;
    }

    public void setUser_no(int user_no) {
        this.user_no = user_no;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isId_del() {
        return id_del;
    }

    public void setId_del(boolean id_del) {
        this.id_del = id_del;
    }
}
