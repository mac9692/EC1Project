package com.plateer.ec1.claim.creator.impl;

import com.plateer.ec1.claim.creator.ClaimDataCreator;
import com.plateer.ec1.claim.enums.CreatorType;
import com.plateer.ec1.claim.vo.Claim;
import com.plateer.ec1.common.model.order.ClaimModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ECouponCancelCompleteDataCreator implements ClaimDataCreator {
    @Override
    public CreatorType getType() {
        return CreatorType.ECOUPONCANCELCOMPLETE;
    }

    @Override
    public ClaimModel getInsertClaimData(Claim claim) {
        log.info("E 쿠폰 취소완료 : 결제 취소 데이터 생성");
        return null;
    }

    @Override
    public ClaimModel getUpdateClaimData(Claim claim) {
        return null;
    }

    @Override
    public void updateOrderBenefitData(Claim claim) {

    }

    @Override
    public ClaimModel insertOrderBenefitRelation(ClaimModel claimModel) {
        return null;
    }

    @Override
    public void updateOrderCost(ClaimModel claimModel) {

    }

    @Override
    public ClaimModel insertOrderCost(ClaimModel claimModel) {
        return null;
    }

    @Override
    public void updateOrderClaim(ClaimModel claimModel) {
        log.info("E 쿠폰 취소완료 : 주문 상태 변경");
    }

    @Override
    public ClaimModel insertOrderClaim(ClaimModel claimModel) {
        return null;
    }
}
