package com.plateer.ec1.order.controller;


import com.plateer.ec1.order.service.OrderService;
import com.plateer.ec1.order.vo.request.RequestOrderVo;
import com.plateer.ec1.order.vo.response.ResponseOrderVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(path = "order")
public class OrderController {

    private final OrderService orderService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public ResponseOrderVo order(@Validated @RequestBody RequestOrderVo requestOrderVo, BindingResult bindingResult) {
        ResponseOrderVo responseOrderVo = new ResponseOrderVo();
        if (bindingResult.hasErrors()) {
            responseOrderVo.setObjectErrorList(bindingResult.getAllErrors());
            return responseOrderVo;
        }
        orderService.order(requestOrderVo);
        return responseOrderVo;
    }
}
