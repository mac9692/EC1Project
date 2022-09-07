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
public class ExchangeAcceptProcessor extends AbstractClaimProcessor implements ClaimProcessor {

    private final ClaimTrxMapper claimTrxMapper;

    public ExchangeAcceptProcessor(ClaimValidator claimValidator, ClaimMapper claimMapper, MonitoringLogHelper monitoringLogHelper, IFCallHelper ifCallHelper, ClaimTrxMapper claimTrxMapper) {
        super(claimValidator, claimMapper, monitoringLogHelper, ifCallHelper);
        this.claimTrxMapper = claimTrxMapper;
    }

    @Override
    public String getType() {
        return ProcessorType.EXCHANGEACCEPT.getType();
    }

    @Override
    public void claimProcess(RequestClaimVo requestClaimVo) {
        String claimNumber = getClaimNumber();
        Long logSeq = insertMonitoringLog(requestClaimVo);
        ClaimDataVo insertData = new ClaimDataVo();
        ClaimDataVo updateData = new ClaimDataVo();
        if (isValidStatus(requestClaimVo)) {
            ClaimDataVo claimDataVo = manipulateClaimData(getClaimData(requestClaimVo), claimNumber);
            insertData = insertClaimData(claimDataVo);
            updateData = updateClaimData(claimDataVo);
            if (isValidAmount(requestClaimVo)) {
                log.info("교환 접수 성공");
            } else {
                log.info("교환 접수 실패");
            }
        }
        updateMonitoringLog(logSeq, insertData, updateData);
    }

    @Override
    public ClaimDataVo insertClaimData(ClaimDataVo claimDataVo) {
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
        claimDataVo.setOpClmInfoModelList(opClmInfoModelList);
        return claimDataVo;
    }

    @Override
    public ClaimDataVo updateClaimData(ClaimDataVo claimDataVo) {
        return null;
    }

    public ClaimDataVo manipulateClaimData(ClaimDataVo claimDataVo, String claimNumber) {
        claimDataVo.setClaimNo(claimNumber);
        List<OpClmInfoModel> opClmInfoModelList = claimDataVo.getOpClmInfoModelList()
                .stream()
                .filter(opClmInfoModel -> OPT0004.DELIVERY_COMPLETE.getType().equals(opClmInfoModel.getOrdPrgsScd()))
                .collect(Collectors.toList());
        claimDataVo.setOpClmInfoModelList(opClmInfoModelList);
        return claimDataVo;
    }
}
