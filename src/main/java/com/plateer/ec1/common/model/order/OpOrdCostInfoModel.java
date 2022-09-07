package com.plateer.ec1.common.model.order;

import com.plateer.ec1.claim.vo.ClaimDataVo;
import com.plateer.ec1.common.code.order.OPT0005;
import com.plateer.ec1.common.code.order.OPT0006;
import com.plateer.ec1.common.code.order.OPT0008;
import com.plateer.ec1.common.code.product.DVP0001;
import com.plateer.ec1.common.code.product.DVP0002;
import com.plateer.ec1.order.vo.CombinedDeliveryVo;
import com.plateer.ec1.order.vo.request.RequestOrderVo;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.util.List;

@Slf4j
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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

    public OpOrdCostInfoModel generalOrder(RequestOrderVo requestOrderVo, CombinedDeliveryVo combinedDeliveryVo) {
        return OpOrdCostInfoModel
                .builder()
                .ordCstNo(combinedDeliveryVo.getOrderCostNo())
                .dvGrpNo(combinedDeliveryVo.getCombinedDeliveryNo())
                .aplyCcd(OPT0005.APPLY.getType())
                .dvAmtTpCd(OPT0006.DELIVERY_CHARGE.getType())
                .orgDvAmt(0L)
                .aplyDvAmt(0L)
                .dvBnfAmt(0L)
                .ordNo(requestOrderVo.getOrderNo())
                .imtnRsnCcd(OPT0008.COMPANY.getType())
                .dvPlcTpCd(DVP0002.FREE.getType())
                .build();
    }

    public OpOrdCostInfoModel mobileCouponOrder(RequestOrderVo requestOrderVo, CombinedDeliveryVo combinedDeliveryVo) {
        return OpOrdCostInfoModel
                .builder()
                .ordCstNo(combinedDeliveryVo.getOrderCostNo())
                .dvGrpNo(combinedDeliveryVo.getCombinedDeliveryNo())
                .aplyCcd(OPT0005.APPLY.getType())
                .dvAmtTpCd(OPT0006.DELIVERY_CHARGE.getType())
                .orgDvAmt(0L)
                .aplyDvAmt(0L)
                .dvBnfAmt(0L)
                .ordNo(requestOrderVo.getOrderNo())
                .imtnRsnCcd(OPT0008.COMPANY.getType())
                .dvPlcTpCd(DVP0002.FREE.getType())
                .build();
    }

    public List<OpOrdCostInfoModel> getReturnAcceptData(ClaimDataVo claimDataVo) {
        List<OpOrdCostInfoModel> opOrdCostInfoModelList = claimDataVo.getOpOrdCostInfoModelList();
        opOrdCostInfoModelList
                .forEach(opOrdCostInfoModel -> {
                    opOrdCostInfoModel.setOrdCstNo(opOrdCostInfoModel.getOrdCstNo() + 1);
                    opOrdCostInfoModel.setDvGrpNo(opOrdCostInfoModel.getDvGrpNo() + 1);
                    opOrdCostInfoModel.setClmNo(opOrdCostInfoModel.getClmNo());
                    opOrdCostInfoModel.setDvAmtTpCd(OPT0006.RETURN_CHARGE.getType());
                    opOrdCostInfoModel.setDvPlcTpCd(DVP0002.CHARGED.getType());
                    if (OPT0008.CUSTOMER.getType().equals(claimDataVo.getImtnRsnCcd())) {
                        opOrdCostInfoModel.setAplyDvAmt(3000L);
                        opOrdCostInfoModel.setOrgDvAmt(3000L);
                        opOrdCostInfoModel.setImtnRsnCcd(OPT0008.CUSTOMER.getType());
                    } else if (OPT0008.COMPANY.getType().equals(claimDataVo.getImtnRsnCcd())) {
                        opOrdCostInfoModel.setOrgDvAmt(3000L);
                        opOrdCostInfoModel.setDvBnfAmt(3000L);
                        opOrdCostInfoModel.setImtnRsnCcd(OPT0008.COMPANY.getType());
                    } else {
                        log.info("귀책구분코드 오류 발생");
                    }
                });
        return opOrdCostInfoModelList;
    }

    public List<OpOrdCostInfoModel> getReturnWithdrawalInsertData(ClaimDataVo claimDataVo) {
        List<OpOrdCostInfoModel> opOrdCostInfoModelList = claimDataVo.getOpOrdCostInfoModelList();
        opOrdCostInfoModelList.forEach(opOrdCostInfoModel -> {
            opOrdCostInfoModel.setOrdCstNo(opOrdCostInfoModel.getOrdCstNo() + 1);
            opOrdCostInfoModel.setClmNo(opOrdCostInfoModel.getClmNo());
        });

        return opOrdCostInfoModelList;
    }
}
