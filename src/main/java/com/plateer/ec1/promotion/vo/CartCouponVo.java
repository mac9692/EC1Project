package com.plateer.ec1.promotion.vo;

import com.plateer.ec1.product.vo.ProductVo;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CartCouponVo {

    private PromotionVo promotionVo;
    private List<ProductVo> productVoList;

    public void calProductCouponDcAmt() {
//        promotionVoList = promotionVoList.parallelStream()
//                .map(promotionVo -> {
//                    promotionVo.calculateDcAmt(validatePrmPrc());
//                    return promotionVo;
//                }).collect(Collectors.toList());
    }
}
