package com.example.onlineshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.example.onlineshop.repository.OnlineMember;
import com.example.onlineshop.model.RegisterModel;
import com.example.onlineshop.entity.OnlineMemberEntity;


@Service
public class RegisterService {

    @Autowired
    private OnlineMember onlineMember;

    private int memberNO;

    @Transactional(rollbackForClassName={"Exception"})
    public int insert(RegisterModel model) {

        OnlineMemberEntity entity = new OnlineMemberEntity();
        memberNO = onlineMember.getMaxMemberNumber()+1;
        entity.setMemberNo(memberNO);
        entity.setAddr(model.getAddr());
        entity.setPassword(model.getPassword());
        entity.setAge(Integer.parseInt(model.getAge()));
        entity.setName(model.getMemberName());
        entity.setSex(model.getSex());
        entity.setPostNumber(model.getPostNumber());
        entity.setPhoneNumber(model.getPhoneNumber());

        int flgNum = onlineMember.insert(entity);
        if (flgNum != 1) {
            return 0;
        }
        return flgNum;
    }

    public int getMemberNo() {
        return memberNO;
    }
    

}