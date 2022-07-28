package com.plateer.ec1.order.mapper;

import com.plateer.ec1.order.vo.OrderDataVo;
import com.plateer.ec1.order.vo.request.RequestOrderVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderTrxMapper {
    public Long insertOrderHistory(RequestOrderVo jsonRequestOrderVo);

    public Long updateOrderHistory(OrderDataVo orderDataVo);
}
