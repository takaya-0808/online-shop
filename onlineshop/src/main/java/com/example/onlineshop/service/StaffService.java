package com.example.onlineshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlineshop.repository.IOnlineStaff;
import com.example.onlineshop.entity.OnlineStaffEntity;
import com.example.onlineshop.model.StaffModel;

@Service
public class StaffService implements IStaffService{

    @Autowired
    private IOnlineStaff onlineStaff;

    private OnlineStaffEntity onlineStaffEntity;

    @Override
    public OnlineStaffEntity findById(String staffNo) {

        onlineStaffEntity = (OnlineStaffEntity)onlineStaff.findById(staffNo);
        return onlineStaffEntity;
    }

    @Override
    public List<OnlineStaffEntity> findAll() {
        
        List<OnlineStaffEntity> onlineStaffList = (List<OnlineStaffEntity>)onlineStaff.findAll();
        return onlineStaffList;
    }

    @Override
    public boolean login(StaffModel model) {

        OnlineStaffEntity entity = findById(model.getStaffNo());
        if (entity == null) {
            return false;
        }
        if (entity.getPassword().equals(model.getPassword())) {
            return true;
        }
        return false;
    }

}