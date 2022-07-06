package com.plateer.ec1.promotion.mapper;

import com.plateer.ec1.product.vo.ProductVo;
import com.plateer.ec1.promotion.vo.ProductCouponVo;
import com.plateer.ec1.promotion.vo.PromotionVo;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PromotionMapper {

    Boolean validateCoupon(RequestPromotionVo requestPromotionVo);

    Boolean verifyUseCoupon(RequestPromotionVo requestPromotionVo);

    Boolean verifyCancelCoupon(RequestPromotionVo requestPromotionVo);

    List<PromotionVo> getCouponInfo(RequestPromotionVo requestPromotionVo);
}
