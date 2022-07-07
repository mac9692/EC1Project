package com.plateer.ec1.promotion.vo.response;

import com.plateer.ec1.promotion.vo.ProductCouponVo;
import lombok.Data;

import java.util.List;

@Data
public class PriceDcResponseVo extends BaseResponseVo {

    private String memberNo;
    private List<ProductCouponVo> productCouponVoList;
}
