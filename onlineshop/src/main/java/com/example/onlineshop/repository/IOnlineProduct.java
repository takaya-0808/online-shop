package com.example.onlineshop.repository;

import java.util.List;

import com.example.onlineshop.repository.IRepository;
import com.example.onlineshop.entity.OnlineProductEntity;
import com.example.onlineshop.model.SearchModel;

public interface IOnlineProduct extends IRepository {

    public List<OnlineProductEntity> findAll();

    public List<OnlineProductEntity> findSelect(SearchModel model);

}