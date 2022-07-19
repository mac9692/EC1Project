package com.plateer.ec1.payment.vo.context;

import com.plateer.ec1.payment.vo.OrderInfoVo;
import com.plateer.ec1.payment.vo.PayInfoVo;
import com.plateer.ec1.utils.Constants;
import com.plateer.ec1.utils.Utils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class ApproveContextVo {
    private LocalDateTime now = LocalDateTime.now();
    private String timestamp = now.format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"));
    private String dtInput = now.plusHours(24).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    private String tmInput = now.plusHours(24).format(DateTimeFormatter.ofPattern("hhmm"));
    private String clientIp = getIpAddress();

    public HttpEntity<MultiValueMap<String, String>>  createContext(OrderInfoVo orderInfoVo, PayInfoVo payInfoVo) {
        HttpHeaders headers = getHttpHeaders();

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("type", Constants.PAYMENT_APPROVE_TYPE);
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
        map.add("hashData", Utils.convertSHA512(Constants.INI_API_KEY + Constants.PAYMENT_APPROVE_TYPE + Constants.PAY_METHOD + timestamp + clientIp + Constants.MID + orderInfoVo.getMoid() + String.valueOf(payInfoVo.getPayAmount())));

        return new HttpEntity<MultiValueMap<String, String>>(map, headers);
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
}
