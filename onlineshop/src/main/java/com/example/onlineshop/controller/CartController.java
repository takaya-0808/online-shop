package com.example.onlineshop.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.onlineshop.service.SessionService;

@Controller
public class CartController {

    @Autowired
    private SessionService sessionService = sessionService = new SessionService();

    @RequestMapping(path = "/cartForm", method = RequestMethod.GET)
    public ModelAndView getLoginForm() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("sessionModel", sessionService.getSeesionModel(sessionService.getSessionID()));
        mav.setViewName("shop/cart");
        return mav;
    }

}