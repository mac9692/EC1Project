package com.plateer.ec1.payment.vo.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.plateer.ec1.common.model.order.OpPayInfo;
import com.plateer.ec1.payment.vo.OrderInfoVo;
import com.plateer.ec1.payment.vo.PayInfoVo;
import com.plateer.ec1.payment.vo.response.ResponseContextVo;
import lombok.Data;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class RequestContextVo {
    private final String TYPE = "Pay";
    private final String PAY_METHOD = "Vacct";
    private final String MID = "INIpayTest";
    private final String INI_API_KEY = "ItEQKi3rY7uvDS8l";
    private final String URL_POST = "https://iniapi.inicis.com/api/v1/formpay";
    private LocalDateTime now = LocalDateTime.now();
    private String timestamp = now.format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"));
    private String dtInput = now.plusHours(24).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    private String tmInput = now.plusHours(24).format(DateTimeFormatter.ofPattern("hhmm"));
    private String clientIp = getIpAddress();

    public ResponseContextVo createContext(OrderInfoVo orderInfoVo, PayInfoVo payInfoVo) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("type", TYPE);
        map.add("paymethod", PAY_METHOD);
        map.add("timestamp", timestamp);
        map.add("clientIp", clientIp);
        map.add("mid", MID);
        map.add("url", orderInfoVo.getStoreUrl());
        map.add("moid", orderInfoVo.getMoid());
        map.add("goodName", orderInfoVo.getGoodName());
        map.add("buyerName", orderInfoVo.getBuyerName());
        map.add("buyerEmail", orderInfoVo.getBuyerEmail());
        map.add("price", String.valueOf(payInfoVo.getPayAmount()));
        map.add("bankCode", payInfoVo.getBankCode());
        map.add("dtInput", dtInput);
        map.add("tmInput", tmInput);
        map.add("nmInput", payInfoVo.getDepositorName());
        map.add("hashData", convertSHA512(INI_API_KEY + TYPE + PAY_METHOD + timestamp + clientIp + MID + orderInfoVo.getMoid() + String.valueOf(payInfoVo.getPayAmount())));

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(URL_POST, request, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseContextVo responseContextVo = new ResponseContextVo();
        try {
            responseContextVo = objectMapper.readValue(response.getBody(), ResponseContextVo.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return responseContextVo;
    }

    public String getIpAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public String convertSHA512(String message) {
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
