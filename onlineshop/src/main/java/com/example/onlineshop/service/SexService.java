package com.example.onlineshop.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlineshop.model.SexModel;
import com.example.onlineshop.entity.SexEntity;
import com.example.onlineshop.repository.Sex;


@Service
public class SexService {

    @Autowired
    private Sex sexGender;

    public List<SexModel> getSexList() {

        List<SexEntity> entityList = sexGender.getSexList();
        List<SexModel> modelList = new ArrayList<SexModel>();
        
        modelList.add(new SexModel());
        for (SexEntity entity : entityList) {
            SexModel sexModel = new SexModel();
            sexModel.setGenderId(String.valueOf(entity.getSexId()));
            sexModel.setGenderName(entity.getSexName());
            modelList.add(sexModel);
        }

        return modelList;
    }

}   