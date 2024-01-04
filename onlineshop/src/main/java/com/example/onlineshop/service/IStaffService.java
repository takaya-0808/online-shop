package com.example.onlineshop.service;

import java.util.List;

import com.example.onlineshop.model.StaffModel;
import com.example.onlineshop.entity.OnlineStaffEntity;

public interface IStaffService {

    public OnlineStaffEntity findById(String staffNo);

    public List<OnlineStaffEntity> findAll();

    public boolean login(StaffModel model);

}