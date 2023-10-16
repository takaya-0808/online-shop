package com.example.onlineshop.service;

import java.util.UUID;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.core.RedisTemplate;

import com.example.onlineshop.model.SessionModel;

import javax.servlet.http.HttpSession;

@Service
public class SessionService {

    private RedisTemplate<String, SessionModel> redisTemplate = new RedisTemplate<>();

    public static DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
    public static String sessionID = "";

    public SessionService() {}
    
    public String getSessionID() {
        
        if (sessionID.isEmpty()) {
            UUID uuid = UUID.randomUUID();
            sessionID = uuid.toString();
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

    public SessionModel getRedisSession(String sessionID) {
        // セッション管理
        SessionModel sessionModel = new SessionModel();
        if (!redisTemplate.hasKey(sessionID)) {
            sessionModel.setSessionName("ゲストさん");
        } else {
            sessionModel = redisTemplate.opsForValue().get(sessionID);
        }
        LocalDateTime nowDate = LocalDateTime.now();
        String strDate = dtf1.format(nowDate);
        sessionModel.setSessionTime(strDate);
        return sessionModel;
    }

    public SessionModel getRedisSession(String sessionID, SessionModel sessionModel) {
        // セッション管理
        SessionModel model = redisTemplate.opsForValue().get(sessionID);
        model.setSessionName(sessionModel.getSessionName());
        LocalDateTime nowDate = LocalDateTime.now();
        String strDate = dtf1.format(nowDate);
        model.setSessionTime(strDate);
        return model;
    }

}
