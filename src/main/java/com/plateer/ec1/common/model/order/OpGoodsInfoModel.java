package com.plateer.ec1.common.model.order;

import com.plateer.ec1.order.vo.OrderGoodsVo;
import com.plateer.ec1.order.vo.request.RequestOrderVo;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Builder
public class OpGoodsInfoModel {
    private String ordNo;
    private String ordGoodsNo;
    private String ordItemNo;
    private String goodsSellTpCd;
    private String goodsDlvTpCd;
    private String goodsNm;
    private String itemNm;
    private Long sellAmt;
    private Long sellDcAmt;
    private Timestamp sysRegDtime;
    private String sysRegrId;
    private Timestamp sysModDtime;
    private String sysModrId;

    public OpGoodsInfoModel generalOrder(OrderGoodsVo orderGoodsVo) {
        builder()
                .ordGoodsNo(orderGoodsVo.getOrdGoodsNo())
                .ordItemNo(orderGoodsVo.getOrdItemNo())
                .goodsSellTpCd(orderGoodsVo.getGoodsSellTpCd())
                .goodsDlvTpCd(orderGoodsVo.getGoodsDlvTpCd())
                .sellAmt(orderGoodsVo.getSellAmt())
                .sellDcAmt(orderGoodsVo.getSellDcAmt())
                .build();

        return this;
    }

    public OpGoodsInfoModel eCouponOrder(OrderGoodsVo orderGoodsVo) {
        builder()
                .ordGoodsNo(orderGoodsVo.getOrdGoodsNo())
                .ordItemNo(orderGoodsVo.getOrdItemNo())
                .goodsSellTpCd(orderGoodsVo.getGoodsSellTpCd())
                .goodsDlvTpCd(orderGoodsVo.getGoodsDlvTpCd())
                .sellAmt(orderGoodsVo.getSellAmt())
                .sellDcAmt(orderGoodsVo.getSellDcAmt())
                .build();

        return this;
    }
}
