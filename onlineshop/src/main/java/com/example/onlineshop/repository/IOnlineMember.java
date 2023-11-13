package com.example.onlineshop.repository;

import java.util.List;
import com.example.onlineshop.model.RegisterModel;
import com.example.onlineshop.entity.OnlineMemberEntity;

public interface IOnlineMember extends IRepository {

    public List<OnlineMemberEntity> findAll();

    public int insert(OnlineMemberEntity entity);

    public int edit(RegisterModel model);

    public int delete(String id);
    
}