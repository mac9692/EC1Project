package com.plateer.ec1.promotion.mapper;

import com.plateer.ec1.product.vo.ProductVo;
import com.plateer.ec1.promotion.vo.PromotionVo;
import com.plateer.ec1.promotion.vo.request.RequestCouponVo;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PromotionMapper {

    Boolean validateCoupon(RequestCouponVo requestCouponVo);

    Boolean verifyUseCoupon(RequestCouponVo requestCouponVo);

    Boolean verifyCancelCoupon(RequestCouponVo requestCouponVo);

    List<PromotionVo> getPromotionInfo(RequestPromotionVo requestPromotionVo);
}
