package com.plateer.ec1.order.strategy.impl.data;

import com.plateer.ec1.order.creator.OrderModelCreator;
import com.plateer.ec1.order.enums.DataStrategyType;
import com.plateer.ec1.order.strategy.DataStrategy;
import com.plateer.ec1.order.vo.OrderDataVo;
import com.plateer.ec1.order.vo.OrderProductView;
import com.plateer.ec1.order.vo.request.RequestOrderVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ECouponDataStrategy implements DataStrategy {

    private final OrderModelCreator orderModelCreator;

    @Override
    public DataStrategyType getType() {
        return DataStrategyType.ECOUPON;
    }

    @Override
    @Transactional
    public OrderDataVo create(RequestOrderVo requestOrderVo) {
        OrderDataVo orderDataVo = OrderDataVo
                .builder()
                .opOrdBaseModel(orderModelCreator.commonOrderBase(requestOrderVo))
                .opGoodsInfoModel(orderModelCreator.commonOrderProduct(requestOrderVo))
                .clmInfoModel(orderModelCreator.commonOrderClaim(requestOrderVo))
                .opDvpAreaInfoModel(orderModelCreator.commonOrderDelivery(requestOrderVo))
                .opOrdCostInfoModel(orderModelCreator.commonOrderCost(requestOrderVo))
                .opOrdBnfInfoModel(orderModelCreator.commonOrderBenefit(requestOrderVo))
                .opOrdBnfRelInfoModel(orderModelCreator.commonOrderBenefitRelation(requestOrderVo))
                .build();
        return orderDataVo;
    }
}
