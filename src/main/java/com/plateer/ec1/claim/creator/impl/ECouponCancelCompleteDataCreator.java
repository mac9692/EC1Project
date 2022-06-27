package com.plateer.ec1.claim.creator.impl;

import com.plateer.ec1.claim.creator.ClaimDataCreator;
import com.plateer.ec1.claim.enums.CreatorType;
import com.plateer.ec1.claim.vo.Claim;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ECouponCancelCompleteDataCreator implements ClaimDataCreator {
    @Override
    public CreatorType getType() {
        return CreatorType.ECOUPONCANCELCOMPLETE;
    }
//
//    @Override
//    public void getInsertClaimData(Claim claim) {
//        log.info("E 쿠폰 취소완료 : 결제 취소 데이터 생성");
//    }
//
//    @Override
//    public void getUpdateClaimData(Claim claim) {
//        return null;
//    }
//
//    @Override
//    public void updateOrderBenefitData(Claim claim) {
//
//    }
//
//    @Override
//    public void insertOrderBenefitRelation(Claim claim) {
//        return null;
//    }
//
//    @Override
//    public void updateOrderCost(Claim claim) {
//
//    }
//
//    @Override
//    public ClaimModel insertOrderCost(Claim claim) {
//        return null;
//    }
//
//    @Override
//    public void updateOrderClaim(Claim claim) {
//        log.info("E 쿠폰 취소완료 : 주문 상태 변경");
//    }
//
//    @Override
//    public ClaimModel insertOrderClaim(Claim claim) {
//        return null;
//    }
}
