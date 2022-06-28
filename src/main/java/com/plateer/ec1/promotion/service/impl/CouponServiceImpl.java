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

        //프로모션 및 쿠폰 유효성 검사
        if (validateCoupon(requestPromotionVo)) {
            log.info("다운로드 가능 여부 확인 성공 시 : 쿠폰 발급 회원 테이블 데이터 삽입");
            //쿠폰 발행
            promotionTrxMapper.downloadCoupon(requestPromotionVo);
        } else {
            log.info("다운로 가능 여부 확인 실패 시 : 쿠폰 다운로드 서비스 종료");
            log.info("다운로드 가능 횟수가 초과했습니다.");
        }
    }

    @Override
    public Long useCoupon(RequestPromotionVo requestPromotionVo) {
        log.info("쿠폰 사용 서비스 시작");
        log.info("쿠폰 사용일시 처리 프로세스 진행");
        log.info("쿠폰 발급 회원 테이블 수정");
        log.info("쿠폰 사용 서비스 종료");
        return null;
    }

    @Override
    public Long cancelCoupon() {
        log.info("쿠폰 취소 서비스 시작");
        verifyCoupon();
        log.info("검증 성공 시 : 신규 쿠폰 발급 데이터 생성, 원쿠폰 발급번호 등록 처리 프로세스");
        log.info("검증 실패 시 : 종료");
        log.info("쿠폰 발급 회원 테이블 수정");
        log.info("쿠폰 취소 서비스 종료");
        return null;
    }

    @Override
    public boolean verifyCoupon() {
        log.info("쿠폰 검증 시작");
        log.info("취소일시 < 프로모션 종료 일시 검증 프로세스");
        log.info("쿠폰 검증 종료");
        return false;
    }
}
