package com.example.onlineshop.service;

import com.example.onlineshop.model.LoginModel;
import com.example.onlineshop.model.SessionModel;

public interface ILoginService {

    public SessionModel checkLoginForm(LoginModel loginModel);

}