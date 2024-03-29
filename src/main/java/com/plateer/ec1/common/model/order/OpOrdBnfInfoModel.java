package com.plateer.ec1.common.model.order;

import com.plateer.ec1.claim.vo.ClaimDataVo;
import com.plateer.ec1.common.code.promotion.PRM0012;
import com.plateer.ec1.order.vo.OrderBenefitVo;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OpOrdBnfInfoModel {

    private String ordBnfNo;
    private Integer ordBnfAmt;
    private Long prmNo;
    private Long cpnIssNo;
    private Integer ordCnclBnfAmt;
    private Integer degrCcd;
    private Timestamp sysRegDtime;
    private String sysRegrId;
    private Timestamp sysModDtime;
    private String sysModrId;
    private String cpnKndCd;
    private String ordNo;

    public OpOrdBnfInfoModel generalOrder(OrderBenefitVo orderBenefitVo) {
        return OpOrdBnfInfoModel
                .builder()
                .ordBnfNo(orderBenefitVo.getOrdBnfNo())
                .prmNo(orderBenefitVo.getPrmNo())
                .cpnIssNo(orderBenefitVo.getCpnIssNo())
                .cpnKndCd(orderBenefitVo.getCpnKndCd())
                .degrCcd(orderBenefitVo.getDegrCcd())
                .ordBnfAmt(orderBenefitVo.getOrdCnclBnfAmt())
                .ordCnclBnfAmt(0)
                .build();
    }

    public OpOrdBnfInfoModel mobileCouponOrder(OrderBenefitVo orderBenefitVo) {
        return OpOrdBnfInfoModel
                .builder()
                .ordBnfNo(orderBenefitVo.getOrdBnfNo())
                .prmNo(orderBenefitVo.getPrmNo())
                .cpnKndCd(orderBenefitVo.getCpnKndCd())
                .degrCcd(orderBenefitVo.getDegrCcd())
                .ordBnfAmt(orderBenefitVo.getOrdCnclBnfAmt())
                .ordCnclBnfAmt(0)
                .build();
    }

    public List<OpOrdBnfInfoModel> getReturnAcceptData(ClaimDataVo claimDataVo) {
        List<OpOrdBnfInfoModel> opOrdBnfInfoModelList = claimDataVo.getOpOrdBnfInfoModelList();
        opOrdBnfInfoModelList.forEach(opOrdBnfInfoModel -> {
            opOrdBnfInfoModel.setOrdCnclBnfAmt(opOrdBnfInfoModel.getOrdBnfAmt());
        });
        return opOrdBnfInfoModelList;
    }
}
