package com.plateer.ec1.payment.vo.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.plateer.ec1.payment.vo.OrderInfoVo;
import com.plateer.ec1.payment.vo.PayInfoVo;
import com.plateer.ec1.payment.vo.response.ResponseApproveVo;
import com.plateer.ec1.utils.Constants;
import lombok.Data;
import org.apache.coyote.Response;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.http.*;
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
import java.util.Arrays;

@Data
public class RequestApproveVo {
    private LocalDateTime now = LocalDateTime.now();
    private String timestamp = now.format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"));
    private String dtInput = now.plusHours(24).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    private String tmInput = now.plusHours(24).format(DateTimeFormatter.ofPattern("hhmm"));
    private String clientIp = getIpAddress();

    public HttpEntity<MultiValueMap<String, String>>  createContext(OrderInfoVo orderInfoVo, PayInfoVo payInfoVo) {
        HttpHeaders headers = getHttpHeaders();

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("type", Constants.TYPE);
        map.add("paymethod", Constants.PAY_METHOD);
        map.add("timestamp", timestamp);
        map.add("clientIp", clientIp);
        map.add("mid", Constants.MID);
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
        map.add("hashData", convertSHA512(Constants.INI_API_KEY + Constants.TYPE + Constants.PAY_METHOD + timestamp + clientIp + Constants.MID + orderInfoVo.getMoid() + String.valueOf(payInfoVo.getPayAmount())));

        HttpEntity<MultiValueMap<String, String>> context = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        return context;
    }

    public HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Arrays.asList(MediaType.ALL));
        return headers;
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
