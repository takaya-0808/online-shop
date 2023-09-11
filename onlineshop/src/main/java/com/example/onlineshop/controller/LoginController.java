package com.example.onlineshop.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
public class LoginController {

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String getLoginForm() {
        return "user/login.html";
    }
}