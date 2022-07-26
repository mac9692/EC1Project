package com.plateer.ec1.order.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.plateer.ec1.order.mapper.OrderTrxMapper;
import com.plateer.ec1.order.service.OrderHistoryService;
import com.plateer.ec1.order.vo.OrderVo;
import com.plateer.ec1.order.vo.request.RequestOrderVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
@RequiredArgsConstructor
public class OrderHistoryServiceImpl implements OrderHistoryService {
    private final OrderTrxMapper orderTrxMapper;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Transactional
    @Override
    public Long insertOrderHistory(RequestOrderVo requestOrderVo) {
        String jsonOrderRequestVo;
        try {
            jsonOrderRequestVo = objectMapper.writeValueAsString(requestOrderVo);
            requestOrderVo.setJson(jsonOrderRequestVo);
            System.out.println(jsonOrderRequestVo);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return orderTrxMapper.insertOrderHistory(requestOrderVo);
    }

    @Transactional
    @Override
    public void updateOrderHistory(Long historyNo, OrderVo orderVo) {
        log.info("주문 모니터링 결과 업데이트");
    }
}
