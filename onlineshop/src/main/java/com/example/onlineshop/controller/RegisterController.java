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
import com.example.onlineshop.validation.RegisterValidation;
import com.example.onlineshop.entity.OnlineMemberEntity;


@Controller
public class RegisterController {

    @Autowired
    private SexService sexService;

    @Autowired
    private RegisterService registerService;

    private RegisterValidation registerValidation;

    private RegisterModel registerModel = new RegisterModel();

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public ModelAndView getLoginForm() {

        var mav = new ModelAndView();
        mav.addObject("genderList", sexService.getSexList());
        mav.addObject("registerModel", new RegisterModel());
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
        mav.addObject("registerModel", registerService.checkRegister(model));
        mav.setViewName("user/registerCheck");
        return mav;
    }

    @RequestMapping(path = "registerResult", method = RequestMethod.POST)
    public ModelAndView resultRegister(@RequestParam(name="button") String name) {

        if (name.equals("return")) {
            registerModel = new RegisterModel();
            return new ModelAndView("redirect:/register");
        }
        var mav = new ModelAndView("user/registerResult");
        try {
            OnlineMemberEntity entity = registerService.insert(registerModel);
            mav.addObject("message", "会員登録に成功しました");
            mav.addObject("memberNo", entity.getMemberNo());
        } catch (Exception ex) {
            System.out.println("Failed Registration");
            mav.addObject("message", "会員登録に失敗しました");
        }
        return mav;
    }
}