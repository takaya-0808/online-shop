package com.example.onlineshop.entity;

import java.util.Date;
import java.sql.Timestamp;

public class OnlineOrderListEntity {

    private int listNo;
    private String collectNo;
    private String productCode;
    private int orderCount;
    private int orderPrice;

    public int getListNo() {
        return this.listNo;
    }

    public void setListNo(int listNo) {
        this.listNo = listNo;
    }

    public String getCollectNo() {
        return this.collectNo;
    }

    public void setCollectNo(String collectNo) {
        this.collectNo = collectNo;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getOrderCount() {
        return this.orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public int getOrderPrice() {
        return this.orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }
    
}