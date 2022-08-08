package com.plateer.ec1.order.mapper;

import com.plateer.ec1.common.model.order.*;
import com.plateer.ec1.order.vo.OrderDataVo;
import com.plateer.ec1.order.vo.request.RequestOrderVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderTrxMapper {
    public Long insertOrderHistory(RequestOrderVo jsonRequestOrderVo);

    public Long updateOrderHistory(OrderDataVo orderDataVo);

    void insertOrderBase(OpOrdBaseModel opOrdBaseModel);

    void insertOrderProduct(List<OpGoodsInfoModel> opGoodsInfoModelList);

    void insertOrderClaim(List<OpClmInfoModel> clmInfoModelList);

    void insertOrderDelivery(List<OpDvpAreaInfoModel> opDvpAreaInfoModels);

    void insertOrderDeliveryInfo(List<OpDvpInfoModel> opDvpInfoModelList);

    void insertOrderCost(List<OpOrdCostInfoModel> opOrdCostInfoModelList);

    void insertOrderBenefit(List<OpOrdBnfInfoModel> opOrdBnfInfoModelList);

    void insertOrderBenefitRelation(List<OpOrdBnfRelInfoModel> opOrdBnfRelInfoModelList);
}
