package com.example.onlineshop.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlineshop.repository.IOnlineProduct;
import com.example.onlineshop.model.SearchProductModel;
import com.example.onlineshop.model.GoodsDetailModel;
import com.example.onlineshop.model.SearchModel;
import com.example.onlineshop.entity.OnlineProductEntity;
import com.example.onlineshop.service.ISearchService;

@Service
public class SearchService implements ISearchService{

    @Autowired
    private IOnlineProduct onlineProduct;

    @Override
    public List<SearchProductModel> findAll() {

        List<SearchProductModel> searchProductModel = new ArrayList<SearchProductModel>();
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

    @Override
    public List<SearchProductModel> findSelect(SearchModel searchModel) {

        List<SearchProductModel> searchProductModel = new ArrayList<SearchProductModel>();
        // List<OnlineProductEntity> entityList = onlineProduct.findSelect(searchModel);
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

    @Override
    public GoodsDetailModel findById(String productCode) {

        GoodsDetailModel detailModel = new GoodsDetailModel();
        OnlineProductEntity entity = (OnlineProductEntity) onlineProduct.findById(productCode);
        detailModel.setProductCode(entity.getProductCode());
        detailModel.setProductName(entity.getProductName());
        detailModel.setProductImageName(entity.getPictureName());
        detailModel.setMemo(entity.getMemo());
        detailModel.setProductPrice(String.valueOf(entity.getUnitPrice()));
        return detailModel;
    }

}