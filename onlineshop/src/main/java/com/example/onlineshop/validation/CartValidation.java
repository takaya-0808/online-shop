package com.example.onlineshop.validation;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.onlineshop.model.GoodsCartModel;
import com.example.onlineshop.service.ICartService;

public class CartValidation {

    @Autowired
    private ICartService cartService;

    public CartValidation(ICartService service) {
        this.cartService = service;
    }

    public ModelAndView valid(String id, String count) {

        ModelAndView mav = new ModelAndView();
        int stockCount = (int)this.cartService.getCountStock(id);

        if (count == null || count.isEmpty()) {
            mav.addObject("stockCountError", "購入数は1～999の数値で入力してください。");
        } else {
            int goodsCount = Integer.parseInt(count);
            if (0 > goodsCount || goodsCount < 1000) {
                mav.addObject("stockCountError", "購入数は1～999の数値で入力してください。");
            }
            if (goodsCount < stockCount) {
                mav.addObject("stockCountError", "在庫が足りません。購入数を変更してください。");
            }
        }

        if (mav.isEmpty()) {
            return null;
        }
        return mav;
    }
}