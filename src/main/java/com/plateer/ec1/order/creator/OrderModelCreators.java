package com.plateer.ec1.order.creator;

import com.plateer.ec1.common.model.order.OpOrdBaseModel;
import com.plateer.ec1.order.vo.OrderProductView;
import com.plateer.ec1.order.vo.request.RequestOrderVo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderModelCreators {

    public static OpOrdBaseModel commonOrderBase(RequestOrderVo requestOrderVo, OrderProductView orderProductView) {
        log.info("주문 데이터 생성 : 주문 기본 생성");
        return null;
    }

    public static OpOrdBaseModel commonOrderProduct(RequestOrderVo requestOrderVo, OrderProductView orderProductView) {
        log.info("주문 데이터 생성 : 주문 상품 생성");
        return null;
    }

    public static OpOrdBaseModel commonOrderClaim(RequestOrderVo requestOrderVo, OrderProductView orderProductView) {
        log.info("주문 데이터 생성 : 주문 클레임 생성");
        return null;
    }
}
