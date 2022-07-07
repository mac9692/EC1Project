package com.plateer.ec1.promotion.vo.response;

import com.plateer.ec1.promotion.vo.CartCouponVo;
import lombok.Data;

import java.util.List;

@Data
public class CartCouponResponseVo extends BaseResponseVo {

    private String memberNo;
    private List<CartCouponVo> cartCouponVoList;
}
