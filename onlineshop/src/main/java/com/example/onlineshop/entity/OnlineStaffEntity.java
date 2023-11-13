package com.example.onlineshop.entity;

import java.util.Date;

public class OnlineStaffEntity {

    private int staffNo;
    private String password;
    private String name;
    private int age;
    private String sex;
    private Date registerDate;
    private Date lastUpdDate;

    public int getStaffNo() {
        return this.staffNo;
    }

    public void setStaffNo(int staffNo) {
        this.staffNo = staffNo;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getRegisterDate() {
        return this.registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getLastUpdDate() {
        return this.lastUpdDate;
    }

    public void setLastUpdDate(Date lastUpdDate) {
        this.lastUpdDate = lastUpdDate;
    }
}