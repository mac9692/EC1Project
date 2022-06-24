package com.plateer.ec1.promotion.service;

import com.plateer.ec1.promotion.vo.PointVo;

public interface PointService {

    PointVo getPointInfo(String clnNo);

    PointVo savePoint(String clnNo, int pointAmt);

    PointVo usePoint(String clnNo, int pointAmt);

    PointVo cancelPoint(String clnNo, int pointAmt);
}
