package com.plateer.ec1.promotion.mapper;

import com.plateer.ec1.common.model.promotion.CcPrmBase;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PromotionTrxMapper {

    Integer downloadCoupon(RequestPromotionVo requestPromotionVo);

    void useCoupon(RequestPromotionVo requestPromotionVo);

    void restoreCoupon(RequestPromotionVo requestPromotionVo);
}
