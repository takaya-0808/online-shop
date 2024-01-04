package com.example.onlineshop.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.onlineshop.service.SessionService;
import com.example.onlineshop.service.ICartService;
import com.example.onlineshop.model.GoodsCartModel;
import com.example.onlineshop.validation.CartValidation;

import java.util.List;
import java.util.ArrayList;

@Controller
public class CartController {

    @Autowired
    private SessionService sessionService = sessionService = new SessionService();

    @Autowired
    private ICartService cartService;

    public List<GoodsCartModel> goodsCartModel = new ArrayList<GoodsCartModel>();

    @RequestMapping(path = "/cartForm", method = RequestMethod.GET)
    public ModelAndView showShoppingCart(@RequestParam(name="button",  required = false) String button, @RequestParam(name="count", required = false) String count) {

        if (button != null && button.equals("return")) {
            return new ModelAndView("redirect:/searchForm");
        }

        ModelAndView mav = new ModelAndView();
        if (button != null) {
            CartValidation cartValidation = new CartValidation(cartService);
            var valid = cartValidation.valid(button, count);
            if (valid != null) {
                valid.setViewName("redirect:/searchDetail?productCode="+button);
                return valid;
            }
            if (count != null) {
                goodsCartModel = (List<GoodsCartModel>)cartService.add(button, Integer.parseInt(count));
            }
        }
        mav.addObject("sessionModel", sessionService.getSessionModel(sessionService.getSessionID()));
        mav.addObject("products", goodsCartModel);
        mav.setViewName("shop/cart");
        return mav;
    }

    @RequestMapping(path = "/cartGoods", method = RequestMethod.GET)
    public ModelAndView showCartDetail(@RequestParam(name="button") String button) {

        if (button.equals("clear")) {
            return new ModelAndView("redirect:/searchForm");
        } else if (button.equals("cancel")) {
            return new ModelAndView("redirect:/searchForm");
        } else if (button.equals("menu")) {
            return new ModelAndView("redirect:/menu");
        }
        ModelAndView mav = new ModelAndView();
        return mav;
    }

}