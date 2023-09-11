package com.example.onlineshop.model;


public class RegisterModel {

    private String memberNo;
    private String password;
    private String passwordCheck;
    private String age;
    private String sex;
    private String postNumber;
    private String addr;
    private String phoneNumber;
    
    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberNo() {
        return this.memberNo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPasswordCheck(String passwordCheck) {
        this.passwordCheck = passwordCheck;
    }

    public String getPasswordCheck() {
        return this.passwordCheck;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
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

    public void setAdder(String adder) {
        this.adder = adder;
    }

    public String getAdder() {
        return this.adder;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

}