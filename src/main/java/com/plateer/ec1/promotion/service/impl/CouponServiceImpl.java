package com.plateer.ec1.promotion.service.impl;

import com.plateer.ec1.promotion.service.CouponService;
import com.plateer.ec1.promotion.vo.Promotion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CouponServiceImpl implements CouponService {

    private String memberNo;
    private List<Promotion> promotionList;
    private Promotion promotion;
    private Long couponIssueNo;
    private String saveUseCcd;
    private int pointAmt;

    @Override
    public List<Promotion> getDownloadCouponList(String memberNo) {
        log.info("다운로드 가능 쿠폰 조회");
        return null;
    }

    @Override
    public boolean checkAvailableDownloadCoupon(String memberNo, Promotion promotion) {
        log.info("다운로드 가능 여부 확인");
        return false;
    }

    @Override
    public Promotion downloadCoupon(String memberNo, Promotion promotion) {
        log.info("쿠폰 다운로드 서비스 시작");
        getDownloadCouponList(memberNo);
        checkAvailableDownloadCoupon(memberNo, promotion);
        log.info("다운로드 가능 여부 확인 성공 시 : 쿠폰 발급 회원 테이블 수정");
        log.info("다운롣 가능 여부 확인 실패 시 : 쿠폰 다운로드 서비스 종료");
        return null;
    }

    @Override
    public Long useCoupon() {
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
