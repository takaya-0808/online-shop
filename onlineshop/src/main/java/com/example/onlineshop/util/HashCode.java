package com.example.onlineshop.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class HashCode {
    
    public String passwordToHashCode(String password) {

        BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
        String encodeedPassword = bcpe.encode(password);
        return encodeedPassword;
    }
    
    public boolean passwordCheck(String password, String checkPassword) {

        BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
        boolean flg = bcpe.matches(password, checkPassword);
        return flg;
    }

}