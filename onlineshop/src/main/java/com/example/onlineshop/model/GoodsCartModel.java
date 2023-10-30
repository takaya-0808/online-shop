package com.example.onlineshop.model;

public class GoodsCartModel {

    private String selectButton;
    private String productCode;
    private String productName;
    private String productSeller;
    private String productPrice;
    private String productCount;

    public void setSelectButton(String selectButton) {
        this.selectButton = selectButton;
    }

    public String getSelectButton() {
        return this.selectButton;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductSeller(String productSeller) {
        this.productSeller = productSeller;
    }

    public String getProductSeller() {
        return this.productSeller;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductPrice() {
        return this.productPrice;
    }

    public void setProductCount(String productCount) {
        this.productCount = productCount;
    }

    public String getProductCount() {
        return this.productCount;
    }

}