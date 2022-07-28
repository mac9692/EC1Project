package com.plateer.ec1.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.plateer.ec1.order.vo.request.RequestOrderVo;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Utils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String convertSHA512(String message) {
        String hashString = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            digest.reset();
            digest.update(message.getBytes(StandardCharsets.UTF_8));
            hashString = String.format("%0128x", new BigInteger(1, digest.digest()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return hashString;
    }

    public static String convertObjectToJson(Object object) {
        String jsonData = null;
        try {
            jsonData = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return jsonData;
    }
}
