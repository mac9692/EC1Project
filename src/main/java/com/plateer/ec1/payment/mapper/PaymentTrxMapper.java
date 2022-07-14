package com.plateer.ec1.payment.mapper;

import com.plateer.ec1.common.model.order.OpPayInfo;
import com.plateer.ec1.payment.vo.request.RequestApproveCompleteVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentTrxMapper {

    public void insertOpPayInfo(OpPayInfo opPayInfo);

    public void updateOpPayInfoComplete(RequestApproveCompleteVo requestApproveCompleteVo);
}
