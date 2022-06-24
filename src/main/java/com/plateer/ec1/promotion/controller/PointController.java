package com.plateer.ec1.promotion.controller;

import com.plateer.ec1.promotion.service.PointService;
import com.plateer.ec1.promotion.vo.PointVo;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api")
@Slf4j
public class PointController {

    private final PointService pointService;

    @RequestMapping(path = "getPointInfo")
    public PointVo getPointInfo(RequestPromotionVo requestPromotionVo) {
        log.info("포인트 정보 조회 시작");
        return pointService.getPointInfo(requestPromotionVo.getClnNo());
    }

    @RequestMapping(path = "savePoint")
    public PointVo savePoint(RequestPromotionVo requestPromotionVo) {
        log.info("포인트 저장 시작");
        return pointService.savePoint(requestPromotionVo.getClnNo(), requestPromotionVo.getPointAmt());
    }

    @RequestMapping(path = "usePoint")
    public PointVo usePoint(RequestPromotionVo requestPromotionVo) {
        log.info("포인트 사용 시작");
        return pointService.usePoint(requestPromotionVo.getClnNo(), requestPromotionVo.getPointAmt());
    }

    @RequestMapping(path = "cancelPoint")
    public PointVo cancelPoint(RequestPromotionVo requestPromotionVo) {
        log.info("포인트 사용 취소 시작");
        return pointService.cancelPoint(requestPromotionVo.getClnNo(), requestPromotionVo.getPointAmt());
    }
}
