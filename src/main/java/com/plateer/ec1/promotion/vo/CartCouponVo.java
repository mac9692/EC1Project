package com.plateer.ec1.promotion.vo;

import com.plateer.ec1.product.vo.ProductVo;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CartCouponVo {

    private PromotionVo promotionVo;
    private List<ProductVo> productVoList;

    public void calCartCouponDcAmt() {
        productVoList = productVoList.stream()
                .peek(productVo -> promotionVo.calculateDcAmt(productVo.validatePrmPrc())).collect(Collectors.toList());
    }

    public void calculateMaxBenefit() {

    }
}
