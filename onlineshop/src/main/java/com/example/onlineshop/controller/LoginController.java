package com.example.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import com.example.onlineshop.model.LoginModel;
import com.example.onlineshop.service.LoginService;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String loginForm() {
        return "user/login.html";
    }

    @RequestMapping(path = "/logincheck", method = RequestMethod.POST)
    public String checkLogin(Model model, @ModelAttribute LoginModel loginModel, @RequestParam(name="button") String name) {

        System.out.println(name);
        if (!name.equals("ログイン")) {
            return "user/login.html";
        }
        boolean flg = loginService.checkLoginForm(loginModel);
        String msg = flg ? "ログインに成功しました" : "ログインに失敗しました";
        model.addAttribute("message", msg);
        return "user/loginResult.html";
    }
}