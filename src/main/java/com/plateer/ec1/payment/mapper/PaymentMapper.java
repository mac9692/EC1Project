package com.plateer.ec1.payment.mapper;

import com.plateer.ec1.common.model.order.OpOrdBase;
import com.plateer.ec1.common.model.order.OpPayInfo;
import com.plateer.ec1.payment.vo.request.RequestApproveCompleteVo;
import com.plateer.ec1.payment.vo.request.RequestCancelVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentMapper {

    public OpPayInfo getOpPayInfo(RequestCancelVo requestCancelVo);

    public OpOrdBase getOpOrdBase(RequestCancelVo requestCancelVo);
}
