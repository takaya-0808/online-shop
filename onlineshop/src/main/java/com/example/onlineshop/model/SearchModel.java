package com.example.onlineshop.model;

public class SearchModel {

    private String goodsCategory;
    private String goodsName;
    private String goodsProduct;
    private String minMoney;
    private String maxMoney;

    public String getGoodsCategory() {
        return this.goodsCategory;
    }

    public void setGoodsCategory(String goodsCategory) {
        this.goodsCategory = goodsCategory;
    }

    public String getGoodsName() {
        return this.goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsProduct() {
        return this.goodsProduct;
    }

    public void setGoodsProduct(String goodsProduct) {
        this.goodsProduct = goodsProduct;
    }

    public String getMinMoney() {
        return this.minMoney;
    }

    public void setMinMoney(String minMoney) {
        this.minMoney = minMoney;
    }

    public String getMaxMoney() {
        return this.maxMoney;
    }

    public void setMaxMoney(String maxMoney) {
        this.maxMoney = maxMoney;
    }

}