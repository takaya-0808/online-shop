package com.example.onlineshop.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlineshop.repository.OnlineProduct;
import com.example.onlineshop.model.SearchProductModel;
import com.example.onlineshop.entity.OnlineProductEntity;

@Service
public class SearchService {

    @Autowired
    private OnlineProduct onlineProduct;

    public List<SearchProductModel> searchProductModel = new ArrayList<SearchProductModel>();

    public List<SearchProductModel> findAll() {

        List<OnlineProductEntity> entityList = onlineProduct.findAll();
        for (int i=0; i<entityList.size(); i++) {
            SearchProductModel model = new SearchProductModel();
            model.setProductCode(entityList.get(i).getProductCode());
            model.setProductName(entityList.get(i).getProductName());
            model.setProductSeller(entityList.get(i).getMaker());
            model.setProductPrice(Integer.valueOf(entityList.get(i).getUnitPrice()).toString());
            model.setProductMemo(entityList.get(i).getMemo());
            searchProductModel.add(model);
        }
        return searchProductModel;
    }

}