package com.plateer.ec1.promotion.mapper;

import com.plateer.ec1.common.model.promotion.CcCpnBase;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CouponMapper {

    List<CcCpnBase> getDownloadCouponList();

    Integer insertCouponIssue();

    Integer updateCouponBase();
}
