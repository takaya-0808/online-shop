package com.example.onlineshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlineshop.repository.OnlineMember;
import com.example.onlineshop.model.LoginModel;
import com.example.onlineshop.entity.OnlineMemberEntity;

@Service
public class LoginService {

    @Autowired
    private OnlineMember onlineMember;

    public boolean checkLoginForm(LoginModel loginModel) {

        List<OnlineMemberEntity> memberList = onlineMember.findAllMember();
        boolean flg = false;
        for (int i=0; i<memberList.size(); i++) {
            String id = String.valueOf(memberList.get(i).getMemberNo());
            String pass = memberList.get(i).getPassword();
            if (id.equals(loginModel.getMemberNo()) && pass.equals(loginModel.getPassword())) {
                flg = true;
                break;
            }
        }
        return flg;
    }

}