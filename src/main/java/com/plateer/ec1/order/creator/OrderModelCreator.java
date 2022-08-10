package com.plateer.ec1.order.creator;

import com.plateer.ec1.common.model.order.*;
import com.plateer.ec1.order.enums.DataStrategyType;
import com.plateer.ec1.order.vo.*;
import com.plateer.ec1.order.vo.request.RequestOrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Component
public class OrderModelCreator {

    public OrderDataVo create(RequestOrderVo requestOrderVo) {
        return OrderDataVo
                .builder()
                .opOrdBaseModel(commonOrderBase(requestOrderVo))
                .opGoodsInfoModelList(commonOrderProduct(requestOrderVo))
                .clmInfoModelList(commonOrderClaim(requestOrderVo))
                .opDvpAreaInfoModelList(commonOrderDelivery(requestOrderVo))
                .opDvpInfoModelList(commonOrderDeliveryInfo(requestOrderVo))
                .opOrdCostInfoModelList(commonOrderCost(requestOrderVo))
                .opOrdBnfInfoModelList(commonOrderBenefit(requestOrderVo))
                .opOrdBnfRelInfoModelList(commonOrderBenefitRelation(requestOrderVo))
                .build();
    }

    public OpOrdBaseModel commonOrderBase(RequestOrderVo requestOrderVo) {
        OpOrdBaseModel opOrdBaseModel = new OpOrdBaseModel();

        if (DataStrategyType.GENERAL.getType().equals(requestOrderVo.getOrderType())) {
            return opOrdBaseModel.generalVirtualAccountPayComplete(requestOrderVo);
        }
        if (DataStrategyType.ECOUPON.getType().equals(requestOrderVo.getOrderNo())) {
            return opOrdBaseModel.eCouponPointPay(requestOrderVo);
        }
        return null;
    }

    public List<OpGoodsInfoModel> commonOrderProduct(RequestOrderVo requestOrderVo) {
        List<OpGoodsInfoModel> opGoodsInfoModelList = new ArrayList<>();
        List<OrderGoodsVo> orderGoodsVoList = requestOrderVo.getOrderGoodsVoList();
        OpGoodsInfoModel opGoodsInfoModel = new OpGoodsInfoModel();

        if (DataStrategyType.GENERAL.getType().equals(requestOrderVo.getOrderType())) {
            orderGoodsVoList.forEach(orderGoodsVo -> opGoodsInfoModelList.add(opGoodsInfoModel.generalOrder(orderGoodsVo)));
            return opGoodsInfoModelList;
        }
        if (DataStrategyType.ECOUPON.getType().equals(requestOrderVo.getOrderType())) {
            orderGoodsVoList.forEach(orderGoodsVo -> opGoodsInfoModelList.add(opGoodsInfoModel.mobileCouponOrder(orderGoodsVo)));
            return opGoodsInfoModelList;
        }
        return null;
    }

    public List<OpClmInfoModel> commonOrderClaim(RequestOrderVo requestOrderVo) {
        List<OpClmInfoModel> opClmInfoModelList = new ArrayList<>();
        List<OrderGoodsVo> orderGoodsVoList = requestOrderVo.getOrderGoodsVoList();
        List<DeliveryAddressVo> deliveryAddressVoList = requestOrderVo.getDeliveryAddressVoList();
        List<CombinedDeliveryVo> combinedDeliveryVoList = deliveryAddressVoList
                .stream()
                .map(DeliveryAddressVo::getCombinedDeliveryVoList)
                .flatMap(Collection::stream).collect(Collectors.toList());
        OpClmInfoModel opClmInfoModel = new OpClmInfoModel();

        if (DataStrategyType.GENERAL.getType().equals(requestOrderVo.getOrderType())) {
            for (OrderGoodsVo orderGoodsVo : orderGoodsVoList) {
                combinedDeliveryVoList.forEach(combinedDeliveryVo -> opClmInfoModelList.add(opClmInfoModel.generalVirtualAccountUnPay(orderGoodsVo, combinedDeliveryVo)));
            }
            return opClmInfoModelList;
        }
        if (DataStrategyType.ECOUPON.getType().equals(requestOrderVo.getOrderType())) {
            for (OrderGoodsVo orderGoodsVo : orderGoodsVoList) {
                combinedDeliveryVoList.forEach(combinedDeliveryVo -> opClmInfoModelList.add(opClmInfoModel.mobileCouponOrder(orderGoodsVo, combinedDeliveryVo)));
            }
            return opClmInfoModelList;
        }
        return null;
    }

    public List<OpDvpAreaInfoModel> commonOrderDelivery(RequestOrderVo requestOrderVo) {
        List<OpDvpAreaInfoModel> opDvpAreaInfoModelList = new ArrayList<>();
        List<DeliveryAddressVo> deliveryAddressVoList = requestOrderVo.getDeliveryAddressVoList();
        OpDvpAreaInfoModel opDvpInfoModel = new OpDvpAreaInfoModel();

        if (DataStrategyType.GENERAL.getType().equals(requestOrderVo.getOrderType())) {
            deliveryAddressVoList.forEach(deliveryAddressVo -> opDvpAreaInfoModelList.add(opDvpInfoModel.generalOrder(deliveryAddressVo)));
            return opDvpAreaInfoModelList;
        }
        if (DataStrategyType.ECOUPON.getType().equals(requestOrderVo.getOrderType())) {
            deliveryAddressVoList.forEach(deliveryAddressVo -> opDvpAreaInfoModelList.add(opDvpInfoModel.mobileCouponOrder(deliveryAddressVo)));
            return opDvpAreaInfoModelList;
        }
        return null;
    }

    public List<OpDvpInfoModel> commonOrderDeliveryInfo(RequestOrderVo requestOrderVo) {
        List<OpDvpInfoModel> opDvpInfoModelList = new ArrayList<>();
        List<DeliveryAddressVo> deliveryAddressVoList = requestOrderVo.getDeliveryAddressVoList();
        List<CombinedDeliveryVo> combinedDeliveryVoList = deliveryAddressVoList
                .stream()
                .map(DeliveryAddressVo::getCombinedDeliveryVoList)
                .flatMap(Collection::stream).collect(Collectors.toList());
        OpDvpInfoModel opDvpInfoModel = new OpDvpInfoModel();

        if (DataStrategyType.GENERAL.getType().equals(requestOrderVo.getOrderType())) {
            for (CombinedDeliveryVo combinedDeliveryVo : combinedDeliveryVoList) {
                deliveryAddressVoList.forEach(deliveryAddressVo -> opDvpInfoModelList.add(opDvpInfoModel.generalOrder(deliveryAddressVo,combinedDeliveryVo)));
                return opDvpInfoModelList;
            }
        }
        if (DataStrategyType.ECOUPON.getType().equals(requestOrderVo.getOrderType())) {
            for (CombinedDeliveryVo combinedDeliveryVo : combinedDeliveryVoList) {
                deliveryAddressVoList.forEach(deliveryAddressVo -> opDvpInfoModelList.add(opDvpInfoModel.mobileCouponOrder(deliveryAddressVo,combinedDeliveryVo)));
                return opDvpInfoModelList;
            }
        }
        return null;
    }

    public List<OpOrdCostInfoModel> commonOrderCost(RequestOrderVo requestOrderVo) {
        List<OpOrdCostInfoModel> opOrdCostInfoModelList = new ArrayList<>();
        List<DeliveryAddressVo> deliveryAddressVoList = requestOrderVo.getDeliveryAddressVoList();
        List<CombinedDeliveryVo> combinedDeliveryVoList = deliveryAddressVoList
                .stream()
                .map(DeliveryAddressVo::getCombinedDeliveryVoList)
                .flatMap(Collection::stream).collect(Collectors.toList());
        OpOrdCostInfoModel opOrdCostInfoModel = new OpOrdCostInfoModel();

        if (DataStrategyType.GENERAL.getType().equals(requestOrderVo.getOrderType())) {
            combinedDeliveryVoList.forEach(combinedDeliveryVo -> opOrdCostInfoModelList.add(opOrdCostInfoModel.generalOrder(requestOrderVo, combinedDeliveryVo)));
            return opOrdCostInfoModelList;
        }
        if (DataStrategyType.ECOUPON.getType().equals(requestOrderVo.getOrderType())) {
            combinedDeliveryVoList.forEach(combinedDeliveryVo -> opOrdCostInfoModelList.add(opOrdCostInfoModel.mobileCouponOrder(requestOrderVo, combinedDeliveryVo)));
            return opOrdCostInfoModelList;
        }
        return null;
    }

    public List<OpOrdBnfInfoModel> commonOrderBenefit(RequestOrderVo requestOrderVo) {
        List<OpOrdBnfInfoModel> opOrdBnfInfoModelList = new ArrayList<>();
        List<OrderBenefitVo> orderBenefitVoList = requestOrderVo.getOrderBenefitVoList();
        OpOrdBnfInfoModel opOrdBnfInfoModel = new OpOrdBnfInfoModel();

        if (DataStrategyType.GENERAL.getType().equals(requestOrderVo.getOrderType())) {
            orderBenefitVoList.forEach(orderBenefitVo -> opOrdBnfInfoModelList.add(opOrdBnfInfoModel.generalOrder(orderBenefitVo)));
            return opOrdBnfInfoModelList;
        }
        if (DataStrategyType.ECOUPON.getType().equals(requestOrderVo.getOrderType())) {
            orderBenefitVoList.forEach(orderBenefitVo -> opOrdBnfInfoModelList.add(opOrdBnfInfoModel.mobileCouponOrder(orderBenefitVo)));
            return opOrdBnfInfoModelList;
        }
        return null;
    }

    public List<OpOrdBnfRelInfoModel> commonOrderBenefitRelation(RequestOrderVo requestOrderVo) {
        List<OpOrdBnfRelInfoModel> opOrdBnfInfoModelList = new ArrayList<>();
        List<OrderBenefitVo> orderBenefitVoList = requestOrderVo.getOrderBenefitVoList();
        List<OrderBenefitProductVo> orderBenefitProductVoList = orderBenefitVoList
                .stream()
                .map(OrderBenefitVo::getOrderBenefitProductVoList)
                .flatMap(Collection::stream).collect(Collectors.toList());
        OpOrdBnfRelInfoModel opOrdBnfRelInfoModel = new OpOrdBnfRelInfoModel();

        if (DataStrategyType.GENERAL.getType().equals(requestOrderVo.getOrderType())) {
            for (OrderBenefitVo orderBenefitVo : orderBenefitVoList) {
                orderBenefitProductVoList.stream().forEach(orderBenefitProductVo -> opOrdBnfInfoModelList.add(opOrdBnfRelInfoModel.generalOrder(requestOrderVo, orderBenefitVo, orderBenefitProductVo)));
                return opOrdBnfInfoModelList;
            }
        }
        if (DataStrategyType.ECOUPON.getType().equals(requestOrderVo.getOrderType())) {
            for (OrderBenefitVo orderBenefitVo : orderBenefitVoList) {
                orderBenefitProductVoList.forEach(orderBenefitProductVo -> opOrdBnfInfoModelList.add(opOrdBnfRelInfoModel.mobileCouponOrder(requestOrderVo, orderBenefitVo, orderBenefitProductVo)));
                return opOrdBnfInfoModelList;
            }
        }
        return null;
    }
}
