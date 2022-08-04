package com.plateer.ec1.order.vo.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.ObjectError;

import java.util.List;

@Getter
@Setter
public class ResponseOrderVo {
    private List<ObjectError> objectErrorList;
}
