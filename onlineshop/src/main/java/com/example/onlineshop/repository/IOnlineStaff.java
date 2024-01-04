package com.example.onlineshop.repository;

import java.util.List;

import com.example.onlineshop.model.StaffModel;
import com.example.onlineshop.entity.OnlineStaffEntity;

public interface IOnlineStaff extends IRepository {

    public List<OnlineStaffEntity> findAll();

    public int insert(StaffModel model);

}