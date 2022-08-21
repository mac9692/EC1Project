package com.plateer.ec1.claim.mapper;

import com.plateer.ec1.claim.vo.OrderClaimInfoVo;
import com.plateer.ec1.order.vo.OrderGoodsVo;
import com.plateer.ec1.product.vo.ProductVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClaimMapper {
    public String getOrderNo();
    public ProductVo getGoodsForValidate(OrderClaimInfoVo orderClaimInfoVo);
}
