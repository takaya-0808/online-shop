package com.example.onlineshop.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.onlineshop.service.SessionService;
import com.example.onlineshop.model.GoodsCartModel;

import java.util.List;
import java.util.ArrayList;

@Controller
public class CartController {

    @Autowired
    private SessionService sessionService = sessionService = new SessionService();

    public List<GoodsCartModel> goodsCartModel = new ArrayList<GoodsCartModel>();

    @RequestMapping(path = "/cartForm", method = RequestMethod.GET)
    public ModelAndView getLoginForm(@RequestParam(name="button",  required = false) String name) {

        if (name != null && name.equals("return")) {
            return new ModelAndView("redirect:/searchForm");
        }
        
        ModelAndView mav = new ModelAndView();
        mav.addObject("sessionModel", sessionService.getSessionModel(sessionService.getSessionID()));
        mav.setViewName("shop/cart");
        return mav;
    }

}