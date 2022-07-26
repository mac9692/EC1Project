package com.plateer.ec1.payment.mapper;

import com.plateer.ec1.payment.vo.OrderBaseVo;
import com.plateer.ec1.payment.vo.request.RequestCancelVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {

    public OrderBaseVo getOpPayInfo(RequestCancelVo requestCancelVo);
    public OrderBaseVo getOpPayPointInfo(RequestCancelVo requestCancelVo);
}
