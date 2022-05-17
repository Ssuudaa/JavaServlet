package com.gk.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class User {
    private Integer id;
    private String sid;
    private String password;
    private Date ctime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public User(Integer id, String sid, String password, Date ctime) {
        this.id = id;
        this.sid = sid;
        this.password = password;
        this.ctime = ctime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", sid='" + sid + '\'' +
                ", password='" + password + '\'' +
                ", ctime=" + ctime +
                '}';
    }
}
