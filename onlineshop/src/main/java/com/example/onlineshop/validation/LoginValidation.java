package com.example.onlineshop.validation;

import org.springframework.web.servlet.ModelAndView;
import com.example.onlineshop.model.LoginModel;

public class LoginValidation {

    public static ModelAndView valid(LoginModel loginModel) {

        ModelAndView mav = new ModelAndView();

        if (loginModel.getMemberNo().isEmpty()) {
            mav.addObject("memberNoError", "必須入力です");
        } else {
            // 会員番号の正規表現
            if (!loginModel.getMemberNo().matches("^[0-9]*$")) {
                mav.addObject("memberNoError", "会員番号は半角数字にしてください");
            }
        }

        if (loginModel.getPassword().isEmpty()) {
            mav.addObject("passwordError", "必須入力です");
        } else {
            // passwordの正規表現
            if (!loginModel.getPassword().matches("^[0-9a-zA-Z]*$")) {
                mav.addObject("passwordError", "パスワードは半角英数字にしてください");
            }
        }

        return mav;
    }

}