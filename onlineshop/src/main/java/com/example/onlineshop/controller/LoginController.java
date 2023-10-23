package com.example.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.example.onlineshop.model.LoginModel;
import com.example.onlineshop.model.SessionModel;
import com.example.onlineshop.service.LoginService;
import com.example.onlineshop.service.SessionService;
import com.example.onlineshop.validation.LoginValidation;


@Controller
public class LoginController {

    @Autowired
    private SessionService sessionService = new SessionService();

    @Autowired
    private LoginService loginService;

    @RequestMapping(path = "/loginForm", method = RequestMethod.GET)
    public ModelAndView loginForm() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("sessionModel", sessionService.getSeesionModel(sessionService.getSessionID()));
        mav.setViewName("user/login");
        return mav;
    }

    @RequestMapping(path = "/loginCheck", method = RequestMethod.POST)
    public ModelAndView checkLogin(@ModelAttribute LoginModel loginModel, @RequestParam(name="button") String name) {

        if (!name.equals("ログイン")) {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("user/login");
            return mav;
        }

        ModelAndView mav = LoginValidation.valid(loginModel);
        if (!mav.isEmpty()) {
            mav.setViewName("user/login");
            return mav;
        }
        SessionModel sessionModel = loginService.checkLoginForm(loginModel);
        String msg = (sessionModel!=null) ? "ログインに成功しました" : "ログインに失敗しました";
        mav.addObject("sessionModel", sessionService.getSeesionModel(sessionService.getSessionID()));
        mav.addObject("message", msg);
        if (sessionModel!=null) {
            mav.setViewName("user/loginResult");
        } else {
            mav.setViewName("user/login");
        }

        return mav;
    }
}