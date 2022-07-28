package com.plateer.ec1.order.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.plateer.ec1.order.mapper.OrderTrxMapper;
import com.plateer.ec1.order.service.OrderHistoryService;
import com.plateer.ec1.order.vo.OrderDataVo;
import com.plateer.ec1.order.vo.OrderVo;
import com.plateer.ec1.order.vo.request.RequestOrderVo;
import com.plateer.ec1.utils.Utils;
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
        requestOrderVo.setJson(Utils.convertObjectToJson(requestOrderVo));
        return orderTrxMapper.insertOrderHistory(requestOrderVo);
    }

    @Transactional
    @Override
    public Long updateOrderHistory(Long historyNo, OrderDataVo orderDataVo) {
        orderDataVo.setJson(Utils.convertObjectToJson(orderDataVo));
        orderDataVo.setHistoryNo(historyNo);
        return orderTrxMapper.updateOrderHistory(orderDataVo);
    }
}
