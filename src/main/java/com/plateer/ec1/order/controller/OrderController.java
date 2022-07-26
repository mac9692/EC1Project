package com.plateer.ec1.order.controller;


import com.plateer.ec1.order.service.OrderService;
import com.plateer.ec1.order.vo.request.RequestOrderVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(path = "order")
public class OrderController {

    private final OrderService orderService;

    @RequestMapping(path = "order")
    public void order(RequestOrderVo requestOrderVo) {
        orderService.order(requestOrderVo);
    }
}
