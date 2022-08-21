package com.plateer.ec1.order.mapper;

import com.plateer.ec1.order.vo.OrderGoodsVo;
import com.plateer.ec1.product.vo.ProductVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    public String getOrderNo();
    public ProductVo getGoodsForValidate(OrderGoodsVo orderGoodsVo);
}
