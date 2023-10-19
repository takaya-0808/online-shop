package com.example.onlineshop.model;

public class SearchProductModel {

    public String productCode;
    public String productName;
    public String productSeller;
    public String productPrice;
    public String productMemo;

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

    public String getProductSeller() {
        return this.productSeller;
    }

    public void setProductSeller(String productSeller) {
        this.productSeller = productSeller;
    }

    public String getProductPrice() {
        return this.productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductMemo() {
        return this.productMemo;
    }

    public void setProductMemo(String productMemo) {
        this.productMemo = productMemo;
    }

}