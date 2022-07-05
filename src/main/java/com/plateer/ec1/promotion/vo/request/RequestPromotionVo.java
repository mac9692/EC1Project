package com.plateer.ec1.promotion.vo.request;

import com.plateer.ec1.product.vo.ProductVo;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class RequestPromotionVo {

    @NotNull(message = "회원번호는 필수값입니다.")
    private String mbrNo;

    List<ProductVo> productVoList;
}
