package com.example.onlineshop.service;

import java.util.UUID;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlineshop.model.SessionModel;
import com.example.onlineshop.util.Uuid;

import javax.servlet.http.HttpSession;

@Service
public class SessionService {

    public static DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
    public static String sessionID = "";

    public SessionService() {}
    
    public String getSessionID() {
        
        if (sessionID.isEmpty()) {
            var uuid = new Uuid();
            sessionID = uuid.createSessionID();
        }
    
        return sessionID;
    }

    public SessionModel getSeesionModel(String sessionID) {

        SessionModel sessionModel = new SessionModel();
        sessionModel.setSessionName("ゲストさん");
        LocalDateTime nowDate = LocalDateTime.now();
        String strDate = dtf1.format(nowDate);
        sessionModel.setSessionTime(strDate);
        return sessionModel;
    }

}
