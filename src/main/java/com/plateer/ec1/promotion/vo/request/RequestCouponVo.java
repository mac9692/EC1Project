package com.plateer.ec1.promotion.vo.request;

import lombok.Builder;
import lombok.Data;

@Data
public class RequestCouponVo {

    private String mbrNo;
    private Long prmNo;
    private Long cpnIssNo;
    private String ordNo;
}
