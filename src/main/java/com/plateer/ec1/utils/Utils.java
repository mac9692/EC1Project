package com.plateer.ec1.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Utils {

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
}
