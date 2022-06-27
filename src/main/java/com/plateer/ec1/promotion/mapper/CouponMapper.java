package com.plateer.ec1.promotion.mapper;

import com.plateer.ec1.common.model.promotion.CcCpnBase;
import com.plateer.ec1.common.model.promotion.CcPrmBase;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

@Mapper
public interface CouponMapper {

    List<CcPrmBase> getDownloadCouponList(RequestPromotionVo requestPromotionVo);

    Integer checkAvailableDownloadCoupon(RequestPromotionVo requestPromotionVo);

    Integer insertCouponIssue(RequestPromotionVo requestPromotionVo);
}
