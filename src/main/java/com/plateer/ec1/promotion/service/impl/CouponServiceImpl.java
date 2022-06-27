package com.plateer.ec1.promotion.service.impl;

import com.plateer.ec1.common.model.promotion.CcCpnBase;
import com.plateer.ec1.common.model.promotion.CcPrmBase;
import com.plateer.ec1.promotion.mapper.CouponMapper;
import com.plateer.ec1.promotion.service.CouponService;
import com.plateer.ec1.promotion.vo.PromotionVo;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {

    private final CouponMapper couponMapper;

    /*
    * 1. 프로모션 시작일시, 종료일시 검증
    * 2. 쿠폰 다운로드 가능 시작일, 종료일 검증
    * 3. 프로모션 사용여부 검증
    * 4. 개인별 다운로드 가능 제한 검증
    * */
    @Override
    public List<CcPrmBase> getDownloadCouponList(RequestPromotionVo requestPromotionVo) {
        log.info("다운로드 가능 쿠폰 조회");
        return couponMapper.getDownloadCouponList(requestPromotionVo);
    }

    /*
    * 1. 다운로드 클릭 시 쿠폰 다운로드 가능 수량 확인
    * 리턴 값 : 쿠폰 다운로드 남은 개수 리턴
    * */
    @Override
    public Integer checkAvailableDownloadCoupon(RequestPromotionVo requestPromotionVo) {
        log.info("다운로드 가능 여부 확인");
        return couponMapper.checkAvailableDownloadCoupon(requestPromotionVo);
    }

    /*
    * 실제 사용자가 다운로드 가능한 쿠폰 목록을 보는 것부터
    * 다운로드 버튼을 누르는 것
    * 다운로드를 하는 것까지 일련의 로직으로 작성
    * 결과가 성공하거나 실패하거나 모두 다운로드 가능한 쿠폰 목록을 조회
    * */
    @Override
    public List<CcPrmBase> downloadCoupon(RequestPromotionVo requestPromotionVo) {
        log.info("쿠폰 다운로드 서비스 시작");
        //개인별 다운로드 가능 쿠폰 조회
        getDownloadCouponList(requestPromotionVo);

        //쿠폰 다운로드 가능수량 검증
        if (checkAvailableDownloadCoupon(requestPromotionVo) > 0) {
            log.info("다운로드 가능 여부 확인 성공 시 : 쿠폰 발급 회원 테이블 데이터 삽입");
            //쿠폰 발행
            couponMapper.insertCouponIssue(requestPromotionVo);

        } else {
            log.info("다운로 가능 여부 확인 실패 시 : 쿠폰 다운로드 서비스 종료");
            log.info("다운로드 가능 횟수가 초과했습니다.");
        }
        return getDownloadCouponList(requestPromotionVo);
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
