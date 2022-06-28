package com.plateer.ec1.promotion.service.impl;

import com.plateer.ec1.common.model.promotion.CcPrmBase;
import com.plateer.ec1.promotion.mapper.PromotionMapper;
import com.plateer.ec1.promotion.mapper.PromotionTrxMapper;
import com.plateer.ec1.promotion.service.CouponService;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {

    private final PromotionMapper promotionMapper;
    private final PromotionTrxMapper promotionTrxMapper;

    /*
    * 1. 프로모션 사용 여부 검증
    * 2. 프로모션 시작일시 종료일시 검증
    * 3. 다운로드 가능시작일, 가능종료일 검증
    * 4. 개인별 다운로드 가능 수량 검증
    * 5. 총 다운로드 가능 수량 검증
    * */
    @Override
    public Boolean validateCoupon(RequestPromotionVo requestPromotionVo) {
        return promotionMapper.validateCoupon(requestPromotionVo);
    }


    @Override
    public void downloadCoupon(RequestPromotionVo requestPromotionVo) {
        log.info("쿠폰 다운로드 서비스 시작");

        if (validateCoupon(requestPromotionVo)) {
            log.info("다운로드 가능 여부 확인 성공 시 : 쿠폰 발급 회원 테이블 데이터 삽입");
            promotionTrxMapper.downloadCoupon(requestPromotionVo);
        } else {
            log.info("다운로드 가능 여부 확인 실패 시 : 쿠폰 다운로드 서비스 종료");
            log.info("다운로드 가능 횟수가 초과했습니다.");
        }
    }

    /*
    * 쿠폰 사용 시 유효성 검사 항목과 쿠폰 취소 시 유효성 검사 항목이 다른 것 같아서 유효성 검사를 개별적으로 진행했습니다.
    * 쿠폰 사용 시 유효성 검사 항목
    * 1. 쿠폰사용일시 null 여부(쿠폰 사용여부)
    * 2. 주문번호 null 여부(쿠폰 사용여부)
    * 3. 프로모션 기간 검증
    * */
    @Override
    public void useCoupon(RequestPromotionVo requestPromotionVo) {
        log.info("쿠폰 사용 서비스 시작");
        boolean result = promotionMapper.verifyUseCoupon(requestPromotionVo);
        if (result) {
            log.info("쿠폰 사용일시 처리 프로세스 진행");
            log.info("쿠폰 발급 회원 테이블 수정");
            promotionTrxMapper.useCoupon(requestPromotionVo);
        } else {
            log.info("쿠폰 사용 실패");
            log.info("유효하지 않은 쿠폰입니다.");
        }
        log.info("쿠폰 사용 서비스 종료");
    }

    /*
    * 쿠폰 취소 시 유효성 검사 항목
    * 1. 쿠폰사용일시 not null 여부(쿠폰 사용여부)
    * 2. Request 주문번호와 사용이력 주문번호 일치 여부
    * 3. 원쿠폰발행번호와 쿠폰발행번호를 비교하여 복원 여부 검증
    * 4. 프로모션 기간 검증
    * */
    @Override
    public void cancelCoupon(RequestPromotionVo requestPromotionVo) {
        log.info("쿠폰 취소 서비스 시작");

        boolean result = promotionMapper.verifyCancelCoupon(requestPromotionVo);
        if (result) {
            log.info("검증 성공 시 : 신규 쿠폰 발급 데이터 생성, 원쿠폰 발급번호 등록 처리 프로세스");
            promotionTrxMapper.restoreCoupon(requestPromotionVo);
        } else {
            log.info("검증 실패 시 : 종료");
            log.info("유효하지 않은 쿠폰입니다.");
        }
        log.info("쿠폰 취소 서비스 종료");
    }

}
