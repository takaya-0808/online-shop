package com.example.onlineshop.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlineshop.model.GoodsCategoryModel;
import com.example.onlineshop.entity.OnlineCategoryEntity;
import com.example.onlineshop.repository.OnlineCategory;

@Service
public class CategoryService {

    @Autowired
    private OnlineCategory onlineCategory;

    private List<GoodsCategoryModel> categoryList = new ArrayList<GoodsCategoryModel>();

    public List<GoodsCategoryModel> select() {

        List<OnlineCategoryEntity> entityList = onlineCategory.select();
        categoryList.add(new GoodsCategoryModel());
        for (var entity : entityList) {
            GoodsCategoryModel model = new GoodsCategoryModel();
            model.setCategoryID(String.valueOf(entity.getCategoryID()));
            model.setCategoryName(entity.getCategoryName());
            categoryList.add(model);
        }

        return categoryList;

    }
}