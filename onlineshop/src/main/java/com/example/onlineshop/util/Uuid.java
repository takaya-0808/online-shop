package com.example.onlineshop.util;

import java.util.UUID;

public class Uuid {

    public static String sessionID = "";

    public static String productID = "";

    // public static String memberID = "";

    public int createMemberID() {
        var uuid = UUID.randomUUID();
        int memberID = uuid.hashCode();
        return memberID;
    }

    public String createProductID() {
        var uuid = UUID.randomUUID();
        int uuidInt = uuid.hashCode();
        productID = Integer.valueOf(uuidInt).toString();
        return productID;
    }

    public String createSessionID() {
        UUID uuid = UUID.randomUUID();
        sessionID = uuid.toString();
        return sessionID;
    }

}