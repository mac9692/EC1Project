package com.plateer.ec1.common.model.order;

import com.plateer.ec1.common.code.order.OPT0005;
import com.plateer.ec1.common.code.order.OPT0006;
import com.plateer.ec1.common.code.product.DVP0002;
import com.plateer.ec1.order.vo.CombinedDeliveryVo;
import lombok.*;

import java.sql.Timestamp;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OpOrdCostInfoModel {

    private String ordCstNo;
    private Integer dvGrpNo;
    private String aplyCcd;
    private String orgOrdCstNo;
    private String clmNo;
    private String ordNo;
    private String dvAmtTpCd;
    private Long orgDvAmt;
    private Long dvBnfAmt;
    private Long aplyDvAmt;
    private String imtnRsnCcd;
    private Timestamp sysRegDtime;
    private String sysRegrId;
    private Timestamp sysModDtime;
    private String sysModrId;
    private String dvPlcTpCd;
    private Long cnclDvAmt;

    public OpOrdCostInfoModel generalOrder(CombinedDeliveryVo combinedDeliveryVo) {
        return OpOrdCostInfoModel
                .builder()
                .dvGrpNo(combinedDeliveryVo.getCombinedDeliveryNo())
                .aplyCcd(OPT0005.APPLY.getType())
                .dvAmtTpCd(OPT0006.DELIVERY_CHARGE.getType())
                .orgDvAmt(0L)
                .aplyDvAmt(0L)
                .dvBnfAmt(0L)
                .dvPlcTpCd(DVP0002.FREE.getType())
                .build();
    }

    public OpOrdCostInfoModel mobileCouponOrder(CombinedDeliveryVo combinedDeliveryVo) {
        return OpOrdCostInfoModel
                .builder()
                .dvGrpNo(combinedDeliveryVo.getCombinedDeliveryNo())
                .aplyCcd(OPT0005.APPLY.getType())
                .dvAmtTpCd(OPT0006.DELIVERY_CHARGE.getType())
                .orgDvAmt(0L)
                .aplyDvAmt(0L)
                .dvBnfAmt(0L)
                .dvPlcTpCd(DVP0002.FREE.getType())
                .build();
    }
}
