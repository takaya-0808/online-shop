package com.example.onlineshop.model;


public class GoodsDetailModel {

    private String productCode;
    private String productName;
    private String productImageName;
    private String memo;
    private String productPrice;

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImageName() {
        return this.productImageName;
    }
    
    public void setProductImageName(String productImageName) {
        this.productImageName = productImageName;
    }

    public String getMemo() {
        return this.memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getProductPrice() {
        return this.productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

}