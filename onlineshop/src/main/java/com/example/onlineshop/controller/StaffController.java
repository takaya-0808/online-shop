package com.example.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.example.onlineshop.service.SessionService;
import com.example.onlineshop.service.IStaffService;
import com.example.onlineshop.model.StaffModel;

@Controller
public class StaffController {

    @Autowired
    private IStaffService staffService;

    @Autowired
    private SessionService sessionService = new SessionService();

    @RequestMapping(path="/staff/login", method = RequestMethod.GET) 
    public ModelAndView loginForm() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("sessionModel", sessionService.getSessionModel(sessionService.getSessionID()));
        mav.setViewName("staff/login");
        return mav;
    }

    @RequestMapping(path="/staff/loginCheck", method = RequestMethod.POST)
    public ModelAndView checkLogin(@ModelAttribute StaffModel staffModel, @RequestParam(name="button") String name) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("sessionModel", sessionService.getSessionModel(sessionService.getSessionID()));
        if (name.equals("クリア")) {
            return new ModelAndView("staff/login");
        }
        boolean flg = staffService.login(staffModel);
        String message = "";
        // ログイン成功
        if (flg) {
            return new ModelAndView("/staff");
        } 
        // ログイン失敗
        else {
            message = "ログイン失敗しました。";
        }
        System.out.println(message);
        mav.addObject("msg", message);
        mav.setViewName("staff/login");
        return mav;
    }

    @RequestMapping(path="/staff", method = RequestMethod.GET) 
    public ModelAndView staffMenu() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("sessionModel", sessionService.getSessionModel(sessionService.getSessionID()));
        mav.setViewName("staff/menu");
        return mav;
    }

    @RequestMapping(path="/staff/search", method = RequestMethod.GET)
    public ModelAndView searchForm() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("sessionModel", sessionService.getSessionModel(sessionService.getSessionID()));
        return mav;
    }

    @RequestMapping(path="/staff/logout", method = RequestMethod.POST)
    public ModelAndView logout() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("sessionModel", sessionService.getSessionModel(sessionService.getSessionID()));
        return mav;
    }

}