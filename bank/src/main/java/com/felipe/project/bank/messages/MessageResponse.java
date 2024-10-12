package com.felipe.project.bank.messages;

import java.util.HashMap;
import java.util.Map;

public class MessageResponse {
    public static Map<String, String> getMessageResponse(String message){
        Map<String, String> successResponse = new HashMap<>();
        successResponse.put("message", message);
        return successResponse;
    }
}
