package com.example.onlineshop.service;

import java.util.List;

import com.example.onlineshop.model.SearchProductModel;
import com.example.onlineshop.model.SearchModel;

public interface ISearchService extends IService {

    public List<SearchProductModel> findAll();

    public List<SearchProductModel> findSelect(SearchModel searchModel);

}