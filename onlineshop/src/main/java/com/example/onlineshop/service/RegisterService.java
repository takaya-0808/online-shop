package com.example.onlineshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.example.onlineshop.repository.IOnlineMember;
import com.example.onlineshop.model.RegisterModel;
import com.example.onlineshop.model.RegisterCheckModel;
import com.example.onlineshop.entity.OnlineMemberEntity;
import com.example.onlineshop.util.Uuid;


@Service
public class RegisterService {

    @Autowired
    private IOnlineMember onlineMember;

    private int memberNO;

    @Transactional(rollbackForClassName={"Exception"})
    public String insert(RegisterModel model) {

        OnlineMemberEntity entity = new OnlineMemberEntity();
        var uuid = new Uuid();
        int memberID = uuid.createMemberID();
        entity.setMemberNo(memberID);
        entity.setAddr(model.getAddr());
        entity.setPassword(model.getPassword());
        entity.setAge(Integer.parseInt(model.getAge()));
        entity.setName(model.getMemberName());
        entity.setSex(model.getSex());
        entity.setPostNumber(model.getPostNumber());
        entity.setPhoneNumber(model.getPhoneNumber());

        int flgNum = onlineMember.insert(entity);
        if (flgNum != 1) {
            return null;
        }
        return Integer.valueOf(memberID).toString();
    }

    public RegisterCheckModel checkRegister(RegisterModel model) {

        RegisterCheckModel registerCheckModel = new RegisterCheckModel();
        registerCheckModel.setMemberName(model.getMemberName());
        registerCheckModel.setAge(model.getAge());
        registerCheckModel.setAddr(model.getAddr());
        String gender = (model.getSex() == "1") ? "女" : "男";
        registerCheckModel.setSex(gender);
        registerCheckModel.setPostNumber(model.getPostNumber());
        registerCheckModel.setPhoneNumber(model.getPhoneNumber());
        return registerCheckModel;
    }
    

}