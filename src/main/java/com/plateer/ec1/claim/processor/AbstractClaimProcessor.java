package com.plateer.ec1.claim.processor;

import com.plateer.ec1.claim.helper.IFCallHelper;
import com.plateer.ec1.claim.helper.MonitoringLogHelper;
import com.plateer.ec1.claim.mapper.ClaimMapper;
import com.plateer.ec1.claim.mapper.ClaimTrxMapper;
import com.plateer.ec1.claim.validator.ClaimValidator;
import com.plateer.ec1.claim.vo.ClaimDataVo;
import com.plateer.ec1.claim.vo.request.RequestClaimVo;
import com.plateer.ec1.common.model.order.OpOrdClmMntLogModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public abstract class AbstractClaimProcessor implements ClaimProcessor{

    private final ClaimValidator claimValidator;
    private final ClaimMapper claimMapper;
    private final MonitoringLogHelper monitoringLogHelper;
    private final IFCallHelper ifCallHelper;

    @Override
    public void doProcess(RequestClaimVo requestClaimVo) {
        claimProcess(requestClaimVo);
    }

    @Override
    public String getClaimNumber() {
        return claimMapper.getClaimNo();
    }

    @Override
    public Long insertMonitoringLog(RequestClaimVo requestClaimVo) {
        return monitoringLogHelper.insertMonitoringLog(requestClaimVo);
    }

    @Override
    public boolean isValidStatus(RequestClaimVo requestClaimVo) {
        return claimValidator.isValidStatus(requestClaimVo);
    }

    @Override
    public ClaimDataVo getClaimData(RequestClaimVo requestClaimVo) {
        return ClaimDataVo
                .builder()
                .orderNo(requestClaimVo.getOrderNo())
                .opClmInfoModelList(claimMapper.getOpClmInfoModelList(requestClaimVo))
                .opOrdCostInfoModelList(claimMapper.getOpOrdCostInfoModelList(requestClaimVo))
                .opOrdBnfRelInfoModelList(claimMapper.getOpOrdBnfRelInfoModelList(requestClaimVo))
                .opOrdBnfInfoModelList(claimMapper.getOpOrdBnfInfoModelList(requestClaimVo))
                .imtnRsnCcd(requestClaimVo.getImtnRsnCcd())
                .build();
    }

    @Override
    public void interfaceCall(RequestClaimVo requestClaimVo) {
        ifCallHelper.callRestoreCoupon(requestClaimVo);
        ifCallHelper.callRestoreInventory(requestClaimVo);
        ifCallHelper.callPaymentIF(requestClaimVo);
    }

    @Override
    public void doPostProcess(ClaimDataVo claimDataVo) {

    }

    @Override
    public void updateMonitoringLog(Long logSeq, ClaimDataVo insertData, ClaimDataVo updateData) {
        monitoringLogHelper.updateMonitoringLog(logSeq, insertData, updateData);
    }

    @Override
    public boolean isValidAmount(RequestClaimVo requestClaimVo) {
        return claimValidator.isValidAmount(requestClaimVo);
    }

}
