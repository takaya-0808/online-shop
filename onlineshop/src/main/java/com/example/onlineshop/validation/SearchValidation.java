package com.example.onlineshop.validation;

import org.springframework.web.servlet.ModelAndView;

import com.example.onlineshop.model.SearchModel;

public class SearchValidation {

    public static ModelAndView valid(SearchModel model) {

        ModelAndView mav = new ModelAndView();

        if (!model.getMinMoney().isEmpty() || !(model.getMinMoney() == null)) {
            if (!model.getMinMoney().matches("^[0-9]*$")) {
                mav.addObject("MinMoneyError", "金額は半角数値で入力してください");
            }
            int money = Integer.parseInt(model.getMinMoney());
            if (money < 0) {
                mav.addObject("MinMoneyError", "金額は0以上を入力してください");
            }
        }

        if (!model.getMaxMoney().isEmpty() || !(model.getMaxMoney() == null)) {
            if (!model.getMaxMoney().matches("^[0-9]*$")) {
                mav.addObject("memberNoError", "会員番号は半角数字にしてください");
            }
            int money = Integer.parseInt(model.getMaxMoney());
            if (money < 0) {
                mav.addObject("MaxMoneyError", "金額は0以上を入力してください");
            }
        }

        if ((!model.getMinMoney().isEmpty() || !(model.getMinMoney() == null)) && (!model.getMaxMoney().isEmpty() || !(model.getMaxMoney() == null))) {
            int maxMoney = Integer.parseInt(model.getMaxMoney());
            int minMoney = Integer.parseInt(model.getMinMoney());
            if (minMoney > maxMoney) {
                mav.addObject("MoneyError", "下限金額は上限金額より大きくしないでください");
            }
        }
        return mav;
    }
}