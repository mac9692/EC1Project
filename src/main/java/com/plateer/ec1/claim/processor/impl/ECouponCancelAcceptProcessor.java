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
import com.plateer.ec1.common.code.order.OPT0004;
import com.plateer.ec1.common.model.order.OpClmInfoModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public void claimProcess(RequestClaimVo requestClaimVo) {
        String claimNumber = getClaimNumber();
        Long logSeq = insertMonitoringLog(requestClaimVo);
        ClaimDataVo insertData = new ClaimDataVo();
        ClaimDataVo updateData = new ClaimDataVo();
        ClaimDataVo claimDataVo = manipulateClaimData(getClaimData(requestClaimVo), claimNumber);
        insertData = insertClaimData(claimDataVo);
        updateData = updateClaimData(claimDataVo);
        if (isValidAmount(requestClaimVo)) {
            log.info("E쿠폰 주문취소 접수 성공");
        } else {
            log.info("E쿠폰 주문취소 접수 실패");
        }

        updateMonitoringLog(logSeq, insertData, updateData);
    }

    @Transactional
    @Override
    public ClaimDataVo insertClaimData(ClaimDataVo claimDataVo) {
        List<OpClmInfoModel> opClmInfoModelList = new OpClmInfoModel().getECouponCancelAcceptInsertData(claimDataVo);

        claimTrxMapper.insertOpClmInfo(opClmInfoModelList);

        claimDataVo.setOpClmInfoModelList(opClmInfoModelList);
        return claimDataVo;
    }

    @Transactional
    @Override
    public ClaimDataVo updateClaimData(ClaimDataVo claimDataVo) {
        claimTrxMapper.updateOpClmInfoCnclCnt(claimDataVo.getOpClmInfoModelList());
        return claimDataVo;
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
