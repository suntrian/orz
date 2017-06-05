package com.suntr.model;

import java.util.Date;

/**
 * Created by suntr on 5/28/2017.
 */
public class UserProfile {
    private int id;
    private String code;
    private boolean gender;
    private String photo;
    private Date birthday;
    private String telphone;
    private String email;
    private String address;
    private Date jointime;
    private Date leavetime;
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getJointime() {
        return jointime;
    }

    public void setJointime(Date jointime) {
        this.jointime = jointime;
    }

    public Date getLeavetime() {
        return leavetime;
    }

    public void setLeavetime(Date leavetime) {
        this.leavetime = leavetime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", gender=" + gender +
                ", photo='" + photo + '\'' +
                ", birthday=" + birthday +
                ", telphone='" + telphone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", jointime=" + jointime +
                ", leavetime=" + leavetime +
                ", comment='" + comment + '\'' +
                '}';
    }
}
