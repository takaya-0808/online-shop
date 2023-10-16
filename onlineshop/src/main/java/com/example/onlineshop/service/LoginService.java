package com.example.onlineshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlineshop.repository.OnlineMember;
import com.example.onlineshop.model.LoginModel;
import com.example.onlineshop.model.SessionModel;
import com.example.onlineshop.entity.OnlineMemberEntity;

@Service
public class LoginService implements ILoginService {

    @Autowired
    private OnlineMember onlineMember;

    public SessionModel checkLoginForm(LoginModel loginModel) {

        List<OnlineMemberEntity> memberList = onlineMember.findAll();
        SessionModel sessionModel = new SessionModel();
        for (int i=0; i<memberList.size(); i++) {
            String id = String.valueOf(memberList.get(i).getMemberNo());
            String pass = memberList.get(i).getPassword();
            if (id.equals(loginModel.getMemberNo()) && pass.equals(loginModel.getPassword())) {
                OnlineMemberEntity entity = onlineMember.findById(loginModel.getMemberNo());
                sessionModel.setSessionID(String.valueOf(entity.getMemberNo()));
                sessionModel.setSessionName(entity.getName());
                return sessionModel;
            }
        }
        return null;
    }



}