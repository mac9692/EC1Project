package com.plateer.ec1.claim.processor.impl;

import com.plateer.ec1.claim.enums.ProcessorType;
import com.plateer.ec1.claim.helper.IFCallHelper;
import com.plateer.ec1.claim.helper.MonitoringLogHelper;
import com.plateer.ec1.claim.mapper.ClaimMapper;
import com.plateer.ec1.claim.mapper.ClaimTrxMapper;
import com.plateer.ec1.claim.processor.AbstractClaimProcessor;
import com.plateer.ec1.claim.processor.ClaimProcessor;
import com.plateer.ec1.claim.validator.ClaimValidator;
import com.plateer.ec1.claim.vo.ClaimDataVo;
import com.plateer.ec1.claim.vo.request.RequestClaimVo;
import com.plateer.ec1.common.code.order.OPT0003;
import com.plateer.ec1.common.code.order.OPT0004;
import com.plateer.ec1.common.model.order.OpClmInfoModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class ECouponCancelAcceptProcessor extends AbstractClaimProcessor implements ClaimProcessor {

    private final ClaimTrxMapper claimTrxMapper;

    public ECouponCancelAcceptProcessor(ClaimValidator claimValidator, ClaimMapper claimMapper, MonitoringLogHelper monitoringLogHelper, IFCallHelper ifCallHelper, ClaimTrxMapper claimTrxMapper) {
        super(claimValidator, claimMapper, monitoringLogHelper, ifCallHelper);
        this.claimTrxMapper = claimTrxMapper;
    }

    @Override
    public String getType() {
        return ProcessorType.ECOUPONCANCELACCEPT.getType();
    }

    @Override
    public void claimProcess(RequestClaimVo requestClaimVo) {
        String claimNumber = getClaimNumber();
        Long logSeq = insertMonitoringLog(requestClaimVo);
        ClaimDataVo claimDataVo = new ClaimDataVo();
        if (isValidStatus(requestClaimVo)) {
            claimDataVo = manipulateClaimData(getClaimData(requestClaimVo), claimNumber);
            insertClaimData(claimDataVo);
            updateClaimData(claimDataVo);
            if (isValidAmount(requestClaimVo)) {
                log.info("E쿠폰 주문취소 접수 성공");
            } else {
                log.info("E쿠폰 주문취소 접수 실패");
            }
        }
        updateMonitoringLog(logSeq, claimDataVo);
    }

    @Override
    public void insertClaimData(ClaimDataVo claimDataVo) {
        List<OpClmInfoModel> opClmInfoModelList = claimDataVo.getOpClmInfoModelList();
                opClmInfoModelList
                .forEach(opClmInfoModel -> {
                    opClmInfoModel.setOrgProcSeq(opClmInfoModel.getProcSeq());
                    opClmInfoModel.setProcSeq(opClmInfoModel.getProcSeq() + 1);
                    opClmInfoModel.setOrdClmTpCd(OPT0003.CANCEL.getType());
                    opClmInfoModel.setOrdPrgsScd(OPT0004.CANCEL_REQUEST.getType());
                    opClmInfoModel.setClmNo(claimDataVo.getClaimNo());
                });
                claimTrxMapper.insertOpClmInfo(opClmInfoModelList);
    }

    @Override
    public void updateClaimData(ClaimDataVo claimDataVo) {
        claimTrxMapper.updateOpClmInfo(claimDataVo.getOpClmInfoModelList());
    }

    public ClaimDataVo manipulateClaimData(ClaimDataVo claimDataVo, String claimNumber) {
        claimDataVo.setClaimNo(claimNumber);
        List<OpClmInfoModel> opClmInfoModelList = claimDataVo.getOpClmInfoModelList()
                .stream()
                .filter(opClmInfoModel -> OPT0004.ORDER_COMPLETE.getType().equals(opClmInfoModel.getOrdPrgsScd()))
                .collect(Collectors.toList());
        claimDataVo.setOpClmInfoModelList(opClmInfoModelList);
        return claimDataVo;
    }
}
