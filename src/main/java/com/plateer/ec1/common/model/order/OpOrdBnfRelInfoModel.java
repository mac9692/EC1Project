package com.plateer.ec1.common.model.order;

import com.plateer.ec1.claim.vo.ClaimDataVo;
import com.plateer.ec1.common.code.order.OPT0005;
import com.plateer.ec1.order.vo.OrderBenefitProductVo;
import com.plateer.ec1.order.vo.OrderBenefitVo;
import com.plateer.ec1.order.vo.request.RequestOrderVo;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OpOrdBnfRelInfoModel {

    private String ordNo;
    private Integer ordSeq;
    private Integer procSeq;
    private String ordBnfNo;
    private String aplyCnclCcd;
    private Long aplyAmt;
    private String clmNo;
    private Timestamp sysRegDtime;
    private String sysRegrId;
    private Timestamp sysModDtime;
    private String sysModrId;

    public OpOrdBnfRelInfoModel generalOrder(RequestOrderVo requestOrderVo, OrderBenefitVo orderBenefitVo, OrderBenefitProductVo orderBenefitProductVo) {
        return OpOrdBnfRelInfoModel
                .builder()
                .ordNo(requestOrderVo.getOrderNo())
                .ordBnfNo(orderBenefitVo.getOrdBnfNo())
                .ordSeq(orderBenefitProductVo.getOrdSeq())
                .procSeq(orderBenefitProductVo.getProcSeq())
                .aplyCnclCcd(OPT0005.APPLY.getType())
                .aplyAmt(orderBenefitProductVo.getAplyAmt())
                .build();
    }

    public OpOrdBnfRelInfoModel mobileCouponOrder(RequestOrderVo requestOrderVo, OrderBenefitVo orderBenefitVo, OrderBenefitProductVo orderBenefitProductVo) {
        return OpOrdBnfRelInfoModel
                .builder()
                .ordNo(requestOrderVo.getOrderNo())
                .ordBnfNo(orderBenefitVo.getOrdBnfNo())
                .ordSeq(orderBenefitProductVo.getOrdSeq())
                .procSeq(orderBenefitProductVo.getProcSeq())
                .aplyCnclCcd(OPT0005.APPLY.getType())
                .aplyAmt(orderBenefitProductVo.getAplyAmt())
                .build();
    }

    public List<OpOrdBnfRelInfoModel> getReturnAcceptData(ClaimDataVo claimDataVo) {
        List<OpOrdBnfRelInfoModel> opOrdBnfRelInfoModelList = claimDataVo.getOpOrdBnfRelInfoModelList();
        opOrdBnfRelInfoModelList
                .forEach(opOrdBnfRelInfoModel -> {
                    opOrdBnfRelInfoModel.setProcSeq(opOrdBnfRelInfoModel.getProcSeq() + 1);
                    opOrdBnfRelInfoModel.setAplyCnclCcd(OPT0005.CANCEL.getType());
                    opOrdBnfRelInfoModel.setClmNo(claimDataVo.getClaimNo());
                });
        return opOrdBnfRelInfoModelList;
    }

    public List<OpOrdBnfRelInfoModel> getReturnWithdrawalInsertData(ClaimDataVo claimDataVo) {
        List<OpOrdBnfRelInfoModel> opOrdBnfRelInfoModelList = claimDataVo.getOpOrdBnfRelInfoModelList();
        opOrdBnfRelInfoModelList
                .forEach(opOrdBnfRelInfoModel -> {
                    opOrdBnfRelInfoModel.setProcSeq(opOrdBnfRelInfoModel.getProcSeq() + 1);
                    opOrdBnfRelInfoModel.setAplyCnclCcd(OPT0005.APPLY.getType());
                    opOrdBnfRelInfoModel.setClmNo(claimDataVo.getClaimNo());
                });
        return opOrdBnfRelInfoModelList;
    }
}
