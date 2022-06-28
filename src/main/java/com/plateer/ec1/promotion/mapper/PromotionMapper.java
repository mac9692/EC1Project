package com.plateer.ec1.promotion.mapper;

import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PromotionMapper {

    Boolean validateCoupon(RequestPromotionVo requestPromotionVo);

    Boolean verifyUseCoupon(RequestPromotionVo requestPromotionVo);

    Boolean verifyCancelCoupon(RequestPromotionVo requestPromotionVo);
}
