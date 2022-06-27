package com.plateer.ec1.promotion.vo;

import com.plateer.ec1.product.vo.Product;
import lombok.Data;

import java.util.List;

@Data
public class ProductCouponVo {

    private Product product;
    private List<PromotionVo> promotionVoList;
    private String maxBenefitYn;
}
