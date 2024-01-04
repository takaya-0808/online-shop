package com.example.onlineshop.repository;

import java.util.List;

import com.example.onlineshop.entity.OnlineCategoryEntity;

public interface IOnlineCategory extends IRepository {

    public List<OnlineCategoryEntity> findAll();

}