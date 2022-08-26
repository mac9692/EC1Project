package com.plateer.ec1.common.model.order;

import com.plateer.ec1.common.code.order.OPT0003;
import com.plateer.ec1.common.code.order.OPT0004;
import com.plateer.ec1.common.code.product.DVP0001;
import com.plateer.ec1.order.vo.CombinedDeliveryVo;
import com.plateer.ec1.order.vo.DeliveryAddressVo;
import com.plateer.ec1.order.vo.OrderGoodsVo;
import lombok.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OpClmInfoModel {

    private String ordNo;
    private String ordGoodsNo;
    private String ordItemNo;
    private Integer ordSeq;
    private Integer procSeq;
    private String ordClmTpCd;
    private String ordPrgsScd;
    private String dvRvtCcd;
    private Long ordAmt;
    private Integer ordCnt;
    private Integer cnclCnt;
    private Integer rtgsCnt;
    private Integer dvGrpNo;
    private Timestamp ordClmReqDtime;
    private Timestamp ordClmAcptDtime;
    private Timestamp ordClmCmtDtime;
    private String clmRsnCd;
    private String clmDtlRsnTt;
    private Timestamp sysRegDtime;
    private String sysRegrId;
    private Timestamp sysModDtime;
    private String sysModrId;
    private String clmNo;
    private Integer orgProcSeq;
    private Timestamp now = new Timestamp(System.currentTimeMillis());

    public OpClmInfoModel generalVirtualAccountUnPay(OrderGoodsVo orderGoodsVo, CombinedDeliveryVo combinedDeliveryVo) {
        return OpClmInfoModel
                .builder()
                .ordGoodsNo(orderGoodsVo.getOrdGoodsNo())
                .ordItemNo(orderGoodsVo.getOrdItemNo())
                .ordClmTpCd(OPT0003.ORDER.getType())
                .dvRvtCcd(DVP0001.DELIVERY.getType())
                .ordCnt(orderGoodsVo.getOrderCount())
                .ordAmt(orderGoodsVo.getSellDcAmt())
                .cnclCnt(0)
                .rtgsCnt(0)
                .dvGrpNo(combinedDeliveryVo.getCombinedDeliveryNo())
                .ordPrgsScd(OPT0004.ORDER_WAIT.getType())
                .ordClmReqDtime(now)
                .ordClmAcptDtime(now)
                .build();
    }

    public OpClmInfoModel generalVirtualAccountPayComplete(OrderGoodsVo orderGoodsVo, CombinedDeliveryVo combinedDeliveryVo) {
        return OpClmInfoModel
                .builder()
                .ordGoodsNo(orderGoodsVo.getOrdGoodsNo())
                .ordItemNo(orderGoodsVo.getOrdItemNo())
                .ordClmTpCd(OPT0003.ORDER.getType())
                .dvRvtCcd(DVP0001.DELIVERY.getType())
                .ordCnt(orderGoodsVo.getOrderCount())
                .ordAmt(orderGoodsVo.getSellDcAmt())
                .cnclCnt(0)
                .rtgsCnt(0)
                .dvGrpNo(combinedDeliveryVo.getCombinedDeliveryNo())
                .ordPrgsScd(OPT0004.ORDER_COMPLETE.getType())
                .ordClmReqDtime(now)
                .ordClmAcptDtime(now)
                .ordClmCmtDtime(now)
                .build();
    }

    public OpClmInfoModel mobileCouponOrder(OrderGoodsVo orderGoodsVo, CombinedDeliveryVo combinedDeliveryVo) {
        return OpClmInfoModel
                .builder()
                .ordGoodsNo(orderGoodsVo.getOrdGoodsNo())
                .ordItemNo(orderGoodsVo.getOrdItemNo())
                .ordClmTpCd(OPT0003.ORDER.getType())
                .dvRvtCcd(DVP0001.DELIVERY.getType())
                .ordCnt(orderGoodsVo.getOrderCount())
                .ordAmt(orderGoodsVo.getSellDcAmt())
                .cnclCnt(0)
                .rtgsCnt(0)
                .dvGrpNo(combinedDeliveryVo.getCombinedDeliveryNo())
                .ordPrgsScd(OPT0004.ORDER_COMPLETE.getType())
                .ordClmReqDtime(now)
                .ordClmAcptDtime(now)
                .ordClmCmtDtime(now)
                .build();
    }
}
