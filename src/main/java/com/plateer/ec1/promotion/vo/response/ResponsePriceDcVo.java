package com.plateer.ec1.promotion.vo.response;

import com.plateer.ec1.product.vo.ProductVo;
import lombok.Data;

import java.util.List;

@Data
public class ResponsePriceDcVo extends ResponseBaseVo {

    private String memberNo;
    private List<ProductVo> productVoList;
}
