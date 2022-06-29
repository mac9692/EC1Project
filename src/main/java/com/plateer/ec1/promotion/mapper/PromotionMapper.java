package com.plateer.ec1.promotion.mapper;

import com.plateer.ec1.promotion.vo.CartCouponVo;
import com.plateer.ec1.promotion.vo.ProductCouponVo;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PromotionMapper {

    Boolean validateCoupon(RequestPromotionVo requestPromotionVo);

    Boolean verifyUseCoupon(RequestPromotionVo requestPromotionVo);

    Boolean verifyCancelCoupon(RequestPromotionVo requestPromotionVo);

    List<ProductCouponVo> getCartCouponInfo(RequestPromotionVo requestPromotionVo);
}
