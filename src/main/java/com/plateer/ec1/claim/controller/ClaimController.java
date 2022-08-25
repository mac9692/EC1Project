package com.plateer.ec1.claim.controller;

import com.plateer.ec1.claim.service.ClaimService;
import com.plateer.ec1.claim.validator.ClaimValidator;
import com.plateer.ec1.claim.vo.request.RequestClaimVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api")
@Slf4j
public class ClaimController {

    private final ClaimValidator claimValidator;
    private final ClaimService claimService;

    @InitBinder
    public void init(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(claimValidator);
    }

    @PostMapping(path = "claim")
    public Object claim(@RequestBody @Validated RequestClaimVo requestClaimVo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return bindingResult.getAllErrors();
        }
        claimService.claim(requestClaimVo);
        return null;
    }
}
