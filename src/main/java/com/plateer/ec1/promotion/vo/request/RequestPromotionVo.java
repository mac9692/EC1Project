package com.plateer.ec1.promotion.vo.request;

import com.plateer.ec1.product.vo.Product;
import com.plateer.ec1.promotion.vo.PromotionVo;
import lombok.Data;

import java.util.List;

@Data
public class RequestPromotionVo {

    private String mbrNo;
    private Long prmNo;
    private String ordNo;
    private Long cpnIssNo;
}
