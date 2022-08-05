package com.plateer.ec1.order.creator;

import com.plateer.ec1.common.model.order.*;
import com.plateer.ec1.order.vo.OrderProductView;
import com.plateer.ec1.order.vo.request.RequestOrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderModelCreator {

    public OpOrdBaseModel commonOrderBase(RequestOrderVo requestOrderVo) {
        return new OpOrdBaseModel();
    }

    public OpGoodsInfoModel commonOrderProduct(RequestOrderVo requestOrderVo) {
        return null;
    }

    public OpClmInfoModel commonOrderClaim(RequestOrderVo requestOrderVo) {
        return new OpClmInfoModel();
    }

    public OpDvpAreaInfoModel commonOrderDelivery(RequestOrderVo requestOrderVo) {
        return new OpDvpAreaInfoModel();
    }

    public OpOrdCostInfoModel commonOrderCost(RequestOrderVo requestOrderVo) {
        return new OpOrdCostInfoModel();
    }

    public OpOrdBnfInfoModel commonOrderBenefit(RequestOrderVo requestOrderVo) {
        return null;
    }

    public OpOrdBnfRelInfoModel commonOrderBenefitRelation(RequestOrderVo requestOrderVo) {
        return null;
    }
}
