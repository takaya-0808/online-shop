package com.example.onlineshop.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
public class MenuController {

    @RequestMapping(path = "/menu", method = RequestMethod.GET)
    public String index() {
        return "common/menu.html";
    }

}