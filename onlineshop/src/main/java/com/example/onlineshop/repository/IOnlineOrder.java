package com.example.onlineshop.repository;

import com.example.onlineshop.entity.OnlineOrderEntity;

import java.util.List;

public interface IOnlineOrder extends IRepository {

    public List<OnlineOrderEntity> findAll();

    public int insert(OnlineOrderEntity entity);

    public int update(OnlineOrderEntity entity);

    public int delete(int orderNo);

}