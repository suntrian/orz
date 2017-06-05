package com.suntr.model;

import java.util.Date;

/**
 * Created by suntrian on 17-6-3.
 */
public class Project {

    private int id;
    private String name;
    private int upper;
    private int type;
    private int status;
    private int level;
    private String code;
    private String comment;
    private int creator;
    private Date createtime;
    private Date starttime;
    private Date endtime;
    private int manager;
    private int department;

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

    public int getUpper() {
        return upper;
    }

    public void setUpper(int upper) {
        this.upper = upper;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", upper=" + upper +
                ", type=" + type +
                ", status=" + status +
                ", level=" + level +
                ", code='" + code + '\'' +
                ", comment='" + comment + '\'' +
                ", creator=" + creator +
                ", createtime=" + createtime +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", manager=" + manager +
                ", department=" + department +
                '}';
    }
}
