package com.example.onlineshop.entity;

import java.util.Date;
import java.sql.Timestamp;

public class OnlineOrderEntity {

    private int orderNo;
    private int memberNo;
    private int totalMoney;
    private int totalTax;
    private Date orderDate;
    private String collectNo;
    private Timestamp lastUpdDate;

    public int getOrderNo() {
        return this.orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public int getMemberNo() {
        return this.memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public int getTotalMoney() {
        return this.totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getTotalTax() {
        return this.totalTax;
    }

    public void setTotalTax(int totalTax) {
        this.totalTax = totalTax;
    }

    public Date getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getCollectNo() {
        return this.collectNo;
    }

    public void setCollectNo(String collectNo) {
        this.collectNo = collectNo;
    }

    public Timestamp getLstUpdDate() {
        return this.lastUpdDate;
    }

    public void setLstUpdDate(Timestamp lastUpdDate) {
        this.lastUpdDate = lastUpdDate;
    }

}