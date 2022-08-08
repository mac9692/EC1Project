package com.plateer.ec1.order.creator;

import com.plateer.ec1.common.model.order.*;
import com.plateer.ec1.order.vo.OrderGoodsVo;
import com.plateer.ec1.order.vo.OrderProductView;
import com.plateer.ec1.order.vo.request.RequestOrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class OrderModelCreator {

    public OpOrdBaseModel commonOrderBase(RequestOrderVo requestOrderVo) {
        OpOrdBaseModel opOrdBaseModel = new OpOrdBaseModel();
        return opOrdBaseModel.generalVirtualAccountPayComplete(requestOrderVo);
    }

    public List<OpGoodsInfoModel> commonOrderProduct(RequestOrderVo requestOrderVo) {
        OpGoodsInfoModel opGoodsInfoModel = new OpGoodsInfoModel();
        List<OrderGoodsVo> orderGoodsVoList = new ArrayList<>();
        return null;
    }

    public List<OpClmInfoModel> commonOrderClaim(RequestOrderVo requestOrderVo) {
        OpClmInfoModel opClmInfoModel = new OpClmInfoModel();
        return null;
    }

    public List<OpDvpAreaInfoModel> commonOrderDelivery(RequestOrderVo requestOrderVo) {
        OpDvpInfoModel opDvpInfoModel = new OpDvpInfoModel();
        return null;
    }

    public List<OpDvpInfoModel> commonOrderDeliveryInfo(RequestOrderVo requestOrderVo) {
        OpDvpInfoModel opDvpInfoModel = new OpDvpInfoModel();
        return null;
    }

    public List<OpOrdCostInfoModel> commonOrderCost(RequestOrderVo requestOrderVo) {
        OpOrdCostInfoModel opOrdCostInfoModel = new OpOrdCostInfoModel();
        return null;
    }

    public List<OpOrdBnfInfoModel> commonOrderBenefit(RequestOrderVo requestOrderVo) {
        OpOrdBnfInfoModel opOrdBnfInfoModel = new OpOrdBnfInfoModel();
        return null;
    }

    public List<OpOrdBnfRelInfoModel> commonOrderBenefitRelation(RequestOrderVo requestOrderVo) {
        OpOrdBnfRelInfoModel opOrdBnfRelInfoModel = new OpOrdBnfRelInfoModel();
        return null;
    }
}
