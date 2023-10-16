package com.example.onlineshop.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.onlineshop.service.SessionService;
import com.example.onlineshop.model.SessionModel;



@Controller
public class MenuController {

    @Autowired
    private SessionService sessionService = new SessionService();

    @RequestMapping(path = "/menu", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        String sessionID = sessionService.getSessionID();
        System.out.println(sessionID);
        mav.addObject("sessionModel", sessionService.getSeesionModel(sessionID));
        mav.setViewName("common/menu");
        return mav;
    }

}