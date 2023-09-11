package com.example.onlineshop.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
public class CartController {

    @RequestMapping(path = "/cart", method = RequestMethod.GET)
    public String getLoginForm() {
        return "shop/cart.html";
    }

}