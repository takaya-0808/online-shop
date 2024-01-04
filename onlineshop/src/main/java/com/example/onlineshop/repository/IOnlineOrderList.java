package com.example.onlineshop.repository;

import com.example.onlineshop.entity.OnlineOrderListEntity;

import java.util.List;

public interface IOnlineOrderList extends IRepository {

    public List<OnlineOrderListEntity> findAll();

    public int insert(OnlineOrderListEntity entity);

    public int update(OnlineOrderListEntity entity);

    public int delete(int listNo);
}