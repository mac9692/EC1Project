package com.plateer.ec1.payment.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextCreator {
    private final String TYPE = "Pay";
    private final String PAY_METHOD = "Vacct";
    private final String MID = "INIpayTest";
    private final String INI_API_KEY = "ItEQKi3rY7uvDS8l";
    private LocalDateTime now = LocalDateTime.now();
    private String timestamp = now.format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"));
    private String dtInput = now.plusHours(24).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    private String tmInput = now.plusHours(24).format(DateTimeFormatter.ofPattern("hhmm"));
    private String clientIp = getIpAddress();
    private String moid = "1";
    private String price = "1777";

    public void createContext() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        String url = "https://iniapi.inicis.com/api/v1/formpay";

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("type", TYPE);
        map.add("paymethod", PAY_METHOD);
        map.add("timestamp", timestamp);
        map.add("clientIp", clientIp);
        map.add("mid", MID);
        map.add("url", "abc");
        map.add("moid", moid);
        map.add("goodName", "g");
        map.add("buyerName", "gg");
        map.add("buyerEmail", "ggg");
        map.add("price", price);
        map.add("bankCode", "11");
        map.add("dtInput", dtInput);
        map.add("tmInput", tmInput);
        map.add("nmInput", "박진성");
        map.add("hashData", getSHA512(INI_API_KEY + TYPE + PAY_METHOD + timestamp + clientIp + MID + moid + price));

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        System.out.println(response.getBody());
    }

    public String getIpAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public String getSHA512(String message) {
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
