package com.plateer.ec1.order.controller;


import com.plateer.ec1.order.service.OrderService;
import com.plateer.ec1.order.vo.request.RequestOrderVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(path = "order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public void order(@Valid @RequestBody RequestOrderVo requestOrderVo) {
        orderService.order(requestOrderVo);
    }
}
