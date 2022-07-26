package com.plateer.ec1.payment.vo.context;

import com.plateer.ec1.payment.vo.OrderBaseVo;
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

public class FullRefundContextVo {
    private LocalDateTime now = LocalDateTime.now();
    private String timestamp = now.format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"));
    private String clientIp = getIpAddress();

    public HttpEntity<MultiValueMap<String, String>> createContext(OrderBaseVo orderBaseVo) {
        HttpHeaders headers = getHttpHeaders();

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("type", Constants.PAYMENT_FULL_REFUND_TYPE);
        map.add("paymethod", Constants.PAY_METHOD);
        map.add("timestamp", timestamp);
        map.add("clientIp", clientIp);
        map.add("mid", Constants.MID);
        map.add("msg", null);
        map.add("tid", orderBaseVo.getTrsnId());
        map.add("refundAcctNum", Utils.convertSHA512(orderBaseVo.getRfndAcctNo()));
        map.add("refundBankCode", orderBaseVo.getRfndBnkCk());
        map.add("refundAcctName", orderBaseVo.getRfndAcctOwnNm());

        map.add("hashData", Utils.convertSHA512(Constants.INI_API_KEY + Constants.PAYMENT_FULL_REFUND_TYPE + Constants.PAY_METHOD + timestamp + clientIp + Constants.MID + orderBaseVo.getTrsnId() + orderBaseVo.getRfndAcctNo()));

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
