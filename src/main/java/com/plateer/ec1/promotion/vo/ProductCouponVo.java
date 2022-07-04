package com.plateer.ec1.promotion.vo;

import com.plateer.ec1.product.vo.ProductVo;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class ProductCouponVo {

    private ProductVo productVo;
    private List<PromotionVo> promotionVoList;
}
