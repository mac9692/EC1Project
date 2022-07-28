package com.plateer.ec1.order.creator;

import com.plateer.ec1.common.model.order.*;
import com.plateer.ec1.order.vo.OrderProductView;
import com.plateer.ec1.order.vo.request.RequestOrderVo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderModelCreators {

    public static OpOrdBaseModel commonOrderBase(RequestOrderVo requestOrderVo, OrderProductView orderProductView) {
        return new OpOrdBaseModel();
    }

    public static OpGoodsInfoModel commonOrderProduct(RequestOrderVo requestOrderVo, OrderProductView orderProductView) {
        return new OpGoodsInfoModel();
    }

    public static OpClmInfoModel commonOrderClaim(RequestOrderVo requestOrderVo, OrderProductView orderProductView) {
        return new OpClmInfoModel();
    }

    public static OpDvpAreaInfoModel commonOrderDelivery(RequestOrderVo requestOrderVo) {
        return new OpDvpAreaInfoModel();
    }

    public static OpOrdCostInfoModel commonOrderCost(RequestOrderVo requestOrderVo) {
        return new OpOrdCostInfoModel();
    }

    public static OpOrdBnfInfoModel commonOrderBenefit(RequestOrderVo requestOrderVo) {
        return null;
    }

    public static OpOrdBnfRelInfoModel commonOrderBenefitRelation(RequestOrderVo requestOrderVo) {
        return null;
    }
}
