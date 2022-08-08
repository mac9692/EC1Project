package com.plateer.ec1.order.strategy.impl.data;

import com.plateer.ec1.order.creator.OrderModelCreator;
import com.plateer.ec1.order.enums.DataStrategyType;
import com.plateer.ec1.order.strategy.DataStrategy;
import com.plateer.ec1.order.vo.OrderDataVo;
import com.plateer.ec1.order.vo.request.RequestOrderVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ECouponDataStrategy implements DataStrategy {

    private final OrderModelCreator orderModelCreator;

    @Override
    public String getType() {
        return DataStrategyType.ECOUPON.getType();
    }

    @Override
    public OrderDataVo create(RequestOrderVo requestOrderVo) {
        return OrderDataVo
                .builder()
                .opOrdBaseModel(orderModelCreator.commonOrderBase(requestOrderVo))
                .opGoodsInfoModelList(orderModelCreator.commonOrderProduct(requestOrderVo))
                .clmInfoModelList(orderModelCreator.commonOrderClaim(requestOrderVo))
                .opDvpAreaInfoModelList(orderModelCreator.commonOrderDelivery(requestOrderVo))
                .opDvpInfoModelList(orderModelCreator.commonOrderDeliveryInfo(requestOrderVo))
                .opOrdCostInfoModelList(orderModelCreator.commonOrderCost(requestOrderVo))
                .opOrdBnfInfoModelList(orderModelCreator.commonOrderBenefit(requestOrderVo))
                .opOrdBnfRelInfoModelList(orderModelCreator.commonOrderBenefitRelation(requestOrderVo))
                .build();
    }
}
