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
        mav.addObject("sessionModel", sessionService.getSeesionModel(sessionService.getSessionID()));
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
        mav.addObject("sessionModel", sessionService.getSeesionModel(sessionService.getSessionID()));
        mav.addObject("registerModel", registerService.checkRegister(model));
        mav.setViewName("user/registerCheck");
        return mav;
    }

    @RequestMapping(path = "registerResult", method = RequestMethod.POST)
    public ModelAndView resultRegister(@RequestParam(name="button") String name) {

        if (name.equals("return")) {
            return new ModelAndView("redirect:/register");
        }
        String memberID = registerService.insert(registerModel);
        ModelAndView mav = new ModelAndView();
        if (memberID != null) {
            mav.addObject("member_msg", "会員番号は" + memberID + "です。");
            mav.addObject("meg", "登録に完了しました");
        } else {
            mav.addObject("meg", "登録に失敗しました");
        }
        mav.addObject("sessionModel", sessionService.getSeesionModel(sessionService.getSessionID()));
        mav.setViewName("user/registerResult");
        return mav;
    }
}