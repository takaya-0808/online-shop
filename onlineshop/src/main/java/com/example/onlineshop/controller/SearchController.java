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
import com.example.onlineshop.service.SearchService;
import com.example.onlineshop.model.GoodsCategoryModel;
import com.example.onlineshop.model.SearchModel;
import com.example.onlineshop.model.SearchProductModel;


@Controller
public class SearchController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SearchService searchService;

    @Autowired
    private SessionService sessionService = new SessionService();

    @RequestMapping(path = "/searchForm", method = RequestMethod.GET)
    public ModelAndView showSearchForm() {

        var mav = new ModelAndView();
        mav.addObject("categorys", categoryService.select());
        mav.addObject("sessionModel", sessionService.getSeesionModel(sessionService.getSessionID()));
        mav.setViewName("shop/search");
        return mav;
    }

    @RequestMapping(path = "/searchResult", method= RequestMethod.GET)
    public ModelAndView searchGoods(@ModelAttribute SearchModel searchModel, @RequestParam(name="button") String name) {

        var mav = new ModelAndView();
        if (name.equals("clear")) {
            return new ModelAndView("redirect:/searchForm");
        }
        
        mav.addObject("products", searchService.findAll());
        mav.addObject("categorys", categoryService.select());
        mav.addObject("sessionModel", sessionService.getSeesionModel(sessionService.getSessionID()));
        mav.setViewName("shop/search");
        return mav;
    }

}