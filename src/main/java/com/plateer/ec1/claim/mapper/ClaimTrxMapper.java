package com.plateer.ec1.claim.mapper;

import com.plateer.ec1.common.model.order.*;
import com.plateer.ec1.order.vo.OrderDataVo;
import com.plateer.ec1.order.vo.request.RequestOrderVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClaimTrxMapper {
    Long insertMonitoringLog(OpOrdClmMntLogModel opOrdClmMntLogModel);

    void updateMonitoringLog(OpOrdClmMntLogModel opOrdClmMntLogModel);
}
