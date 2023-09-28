package com.example.onlineshop.validation;

import org.springframework.web.servlet.ModelAndView;
import com.example.onlineshop.model.RegisterModel;

public class RegisterValidation {

    public static ModelAndView valid(RegisterModel model) {

        var mav = new ModelAndView();

        if (model.getMemberName() == null || model.getMemberName().isEmpty()) {
           mav.addObject("MemberNameError", "必須入力です"); 
        }

        if (model.getPassword() == null || model.getPasswordCheck() == null || model.getPassword().isEmpty() || model.getPasswordCheck().isEmpty()) {
            mav.addObject("PasswordError", "必須入力です");
        } else {
            if (!model.getPassword().equals(model.getPasswordCheck())) {
                mav.addObject("PasswordError", "パスワードと確認用パスワードは一致させてください");
            }
        }

        if (model.getAge() == null || model.getAge().isEmpty()) {
            mav.addObject("AgeError", "必須入力です");
        } else {
            if (!model.getAge().matches("^[0-9]*$")) {
                mav.addObject("AgeError", "年齢は半角数字を入力してください");
            }
        }

        if (model.getSex() == null || model.getSex().isEmpty()) {
            mav.addObject("SexError", "必須入力です");
        }

        if (model.getPostNumber() == null || model.getPostNumber().isEmpty()) {
            mav.addObject("PostNumberError", "必須入力です");
        } else {
            if (!model.getPostNumber().matches("^[0-9]{3}-[0-9]{4}$")) {
                mav.addObject("PostNumberError", "正しい郵便番号を入力してください");
            }
        }

        if (model.getAddr() == null || model.getAddr().isEmpty()) {
            mav.addObject("AddrError", "必須入力です");
        } else {
            if (model.getAddr().length() >= 50) {
                mav.addObject("AddrError", "住所は50字以下で入力してください");
            }
        }

        if (model.getPhoneNumber() == null || model.getPhoneNumber().isEmpty()) {
            mav.addObject("PhoneError", "必須入力です");
        } else {
            if (!model.getPhoneNumber().matches("^[0-9]{3}-[0-9]{4}-[0-9]{4}$")) {
                mav.addObject("PhoneError", "正しい電話番号を入力してください");
            }
        }

        return mav;

    }

}