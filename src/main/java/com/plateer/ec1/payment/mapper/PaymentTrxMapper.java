package com.plateer.ec1.payment.mapper;

import com.plateer.ec1.common.model.order.OpPayInfo;
import com.plateer.ec1.payment.vo.OrderBaseVo;
import com.plateer.ec1.payment.vo.request.RequestApproveCompleteVo;
import com.plateer.ec1.payment.vo.request.RequestCancelVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentTrxMapper {

    public void insertOpPayInfo(OpPayInfo opPayInfo);

    public void updateOpPayInfoComplete(RequestApproveCompleteVo requestApproveCompleteVo);

    public void updateOpPayInfoCancel(OrderBaseVo orderBaseVo);

    public void insertOpPayInfoCancel(OrderBaseVo orderBaseVo);

    public void insertOpPayInfoCancelBefore(OrderBaseVo orderBaseVo, RequestCancelVo requestCancelVo);

    public void insertOpPayInfoPointApprove(OpPayInfo opPayInfo);

    public void updateOpPayInfoPointCancel(RequestCancelVo requestCancelVo);
}
