package com.example.onlineshop.entity;

import java.util.Date;

public class OnlineMemberEntity {

    private int memberNo;
    private String password;
    private int age;
    private String name;
    private String sex;
    private String postNumber;
    private String addr;
    private String phoneNumber;
    private Date registerDate;
    private String delFlg;
    private Date lstUpdDate;
    
    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public int getMemberNo() {
        return this.memberNo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return this.sex;
    }

    public void setPostNumber(String postNumber) {
        this.postNumber = postNumber;
    }

    public String getPostNumber() {
        return this.postNumber;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getAddr() {
        return this.addr;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getRegisterDate() {
        return this.registerDate;
    }

    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg;
    }

    public String getDelFlg() {
        return this.delFlg;
    }

    public void setLstUpdDate(Date lstUpdDate) {
        this.lstUpdDate = lstUpdDate;
    }

    public Date getLstUpdDate() {
        return this.lstUpdDate;
    }

}