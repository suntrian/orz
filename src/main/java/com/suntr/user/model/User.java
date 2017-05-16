package com.suntr.user.model;

import java.util.Date;

/**
 * Created by suntr on 5/14/2017.
 */
public class User {

    private int id;
    private String name;
    private String password;
    private boolean online;
    private Date last_op_time;

    public User(){}
    public User(String name, String password){
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public Date getLast_op_time() {
        return last_op_time;
    }

    public void setLast_op_time(Date last_op_time) {
        this.last_op_time = last_op_time;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", online=" + online +
                ", last_op_time=" + last_op_time +
                '}';
    }

}
