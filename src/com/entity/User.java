package com.entity;

public class User {

    private int id;
    private String loginname;
    private String username;
    private String password;
    private String sex;
    private int type;

    public User(int id, String loginname, String username, String password, String sex, int type) {
        this.id = id;
        this.loginname = loginname;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.type = type;
    }
    public User(Object o, String loginname, String username, String password, String sex, int type) {
        this.loginname = loginname;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.type = type;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginname='" + loginname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", type=" + type +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
