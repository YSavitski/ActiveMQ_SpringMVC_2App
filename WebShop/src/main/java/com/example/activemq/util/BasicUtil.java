package com.example.activemq.util;

import java.util.UUID;

public class BasicUtil {
    public static String getUniqueID(){
        return UUID.randomUUID().toString();
    }
}
