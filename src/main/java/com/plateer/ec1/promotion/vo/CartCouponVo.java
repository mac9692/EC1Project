package com.plateer.ec1.promotion.vo;

import com.plateer.ec1.product.vo.Product;
import lombok.Data;

import java.util.List;

@Data
public class CartCouponVo {

    private PromotionVo promotionVo;
    private List<Product> productList;
    private String maxBenefitYn;

}
