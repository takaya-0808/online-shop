package com.example.onlineshop.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.onlineshop.model.RegisterModel;


@Controller
public class RegisterController {

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String getLoginForm() {
        return "user/register.html";
    }

    @RequestMapping(path = "/registercheck", method = RequestMethod.POST)
    public ModelAndView checkRegister(ModelAndView mav, @ModelAttribute RegisterModel model) {

        
        return "user/register.html";
    }
}