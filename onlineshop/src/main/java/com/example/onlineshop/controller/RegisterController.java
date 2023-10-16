package com.example.onlineshop.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.onlineshop.model.RegisterModel;
import com.example.onlineshop.model.SexModel;
import com.example.onlineshop.service.SexService;
import com.example.onlineshop.service.RegisterService;
import com.example.onlineshop.service.SessionService;
import com.example.onlineshop.validation.RegisterValidation;

@Controller
public class RegisterController {

    @Autowired
    private SexService sexService;

    @Autowired
    private RegisterService registerService;

    @Autowired
    private SessionService sessionService;

    private RegisterValidation registerValidation;

    private RegisterModel registerModel;

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public ModelAndView getLoginForm() {

        var mav = new ModelAndView();
        sessionService = new SessionService();
        mav.addObject("genderList", sexService.getSexList());
        mav.addObject("registerModel", new RegisterModel());
        String sessionID = sessionService.getSessionID();
        System.out.println(sessionID);
        mav.addObject("sessionModel", sessionService.getSeesionModel(sessionID));
        mav.setViewName("user/register");
        return mav;
    }

    @RequestMapping(path = "/registerCheck", method = RequestMethod.POST)
    public ModelAndView checkRegister(@ModelAttribute RegisterModel model, @RequestParam(name="button") String name) {

        if (name.equals("return")) {
            return new ModelAndView("redirect:/menu");
        }
        if (name.equals("clear")) {
            return new ModelAndView("redirect:/register");
        }
        var mav = registerValidation.valid(model);        
        if (!mav.isEmpty()) {
            mav.addObject("genderList", sexService.getSexList());
            mav.setViewName("user/register");
            return mav;
        }
        registerModel = model;
        String sessionID = sessionService.getSessionID();
        mav.addObject("sessionModel", sessionService.getSeesionModel(sessionID));
        mav.addObject("registerModel", registerService.checkRegister(model));
        mav.setViewName("user/registerResult");
        return mav;
    }

    @RequestMapping(path = "registerResult", method = RequestMethod.POST)
    public ModelAndView resultRegister(@RequestParam(name="button") String name) {

        // if (registerService.insert(model) == 1) {
        //     mav.addObject("message", "会員登録に成功しました");
        //     mav.addObject("memberNo", registerService.getMemberNo());
        // } else {
        //     mav.addObject("message", "会員登録に失敗しました");
        // }
        return null;
    }
}