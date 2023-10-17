package com.example.onlineshop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.onlineshop.service.CategoryService;
import com.example.onlineshop.service.SessionService;
import com.example.onlineshop.model.GoodsCategoryModel;
import com.example.example.onlineshop.model.SearchModel;


@Controller
public class SearchController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SessionService sessionService = new SessionService();

    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public ModelAndView showSearchForm() {
        ModelAndView mav = new ModelAndView();
        List<GoodsCategoryModel> categoryList = categoryService.select();
        mav.addObject("categorys", categoryList);
        String sessionID = sessionService.getSessionID();
        System.out.println(sessionID);
        mav.addObject("sessionModel", sessionService.getSeesionModel(sessionID));
        mav.setViewName("shop/search");
        return mav;
    }

    @RequestMapping(path = "/searchResult", method= RequestMethod.GET)
    public ModelAndView searchGoods(@ModelAttribute SearchModel searchModel, @RequestParam(name="button") String name) {

        
        return null;
    }

}