package com.plateer.ec1.claim.vo.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.ObjectError;

import java.util.List;

@Getter
@Setter
public class ResponseClaimVo {
    private List<ObjectError> objectErrorList;
}
