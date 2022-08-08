package com.plateer.ec1.order.service.impl;

import com.plateer.ec1.common.model.order.*;
import com.plateer.ec1.order.mapper.OrderTrxMapper;
import com.plateer.ec1.order.vo.OrderDataVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderDataInsertProcessor {

    private final OrderTrxMapper orderTrxMapper;

    @Transactional
    public void insertOrderData(OrderDataVo orderDataVo) {
        insertOrderBase(orderDataVo.getOpOrdBaseModel());
        insertOrderProduct(orderDataVo.getOpGoodsInfoModelList());
        insertOrderClaim(orderDataVo.getClmInfoModelList());
        insertOrderDelivery(orderDataVo.getOpDvpAreaInfoModelList());
        insertOrderDeliveryInfo(orderDataVo.getOpDvpInfoModelList());
        insertOrderCost(orderDataVo.getOpOrdCostInfoModelList());
        insertOrderBenefit(orderDataVo.getOpOrdBnfInfoModelList());
        insertOrderBenefitRelation(orderDataVo.getOpOrdBnfRelInfoModelList());
    }

    private void insertOrderBase(OpOrdBaseModel opOrdBaseModel) {
        orderTrxMapper.insertOrderBase(opOrdBaseModel);
    }

    private void insertOrderProduct(List<OpGoodsInfoModel> opGoodsInfoModelList) {
        orderTrxMapper.insertOrderProduct(opGoodsInfoModelList);
    }

    private void insertOrderClaim(List<OpClmInfoModel> clmInfoModelList) {
        orderTrxMapper.insertOrderClaim(clmInfoModelList);
    }

    private void insertOrderDelivery(List<OpDvpAreaInfoModel> opDvpAreaInfoModelList) {
        orderTrxMapper.insertOrderDelivery(opDvpAreaInfoModelList);
    }

    private void insertOrderDeliveryInfo(List<OpDvpInfoModel> opDvpInfoModelList) {
        orderTrxMapper.insertOrderDeliveryInfo(opDvpInfoModelList);
    }

    private void insertOrderCost(List<OpOrdCostInfoModel> opOrdCostInfoModelList) {
        orderTrxMapper.insertOrderCost(opOrdCostInfoModelList);
    }

    private void insertOrderBenefit(List<OpOrdBnfInfoModel> opOrdBnfInfoModelList) {
        orderTrxMapper.insertOrderBenefit(opOrdBnfInfoModelList);
    }

    private void insertOrderBenefitRelation(List<OpOrdBnfRelInfoModel> opOrdBnfRelInfoModelList) {
        orderTrxMapper.insertOrderBenefitRelation(opOrdBnfRelInfoModelList);
    }
}
