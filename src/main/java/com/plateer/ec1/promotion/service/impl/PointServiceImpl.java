package com.plateer.ec1.promotion.service.impl;

import com.plateer.ec1.promotion.service.PointService;
import com.plateer.ec1.promotion.vo.PointVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PointServiceImpl implements PointService {

    private String memberNo;
    private String saveUseCcd;
    private int pointAmt;

    @Override
    public PointVo getPointInfo(String clnNo) {
        log.info("포인트 정보 GET 서비스 시작");
        log.info("포인트 정보 GET 서비스 종료");
        return null;
    }

    @Override
    public PointVo savePoint(String clnNo, int pointAmt) {
        log.info("포인트 저장 서비스 시작");
        log.info("포인트 저장 서비스 종료");
        return null;
    }

    @Override
    public PointVo usePoint(String clnNo, int pointAmt) {
        log.info("포인트 사용 서비스 시작");
        log.info("포인트 사용 서비스 종료");
        return null;
    }

    @Override
    public PointVo cancelPoint(String clnNo, int pointAmt) {
        log.info("포인트 사용취소 서비스 시작");
        log.info("포인트 사용취소 서비스 종료");
        return null;
    }
}
