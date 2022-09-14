package com.plateer.ec1.claim.mapper;

import com.plateer.ec1.common.model.order.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClaimTrxMapper {
    void insertMonitoringLog(OpOrdClmMntLogModel opOrdClmMntLogModel);

    void updateMonitoringLog(OpOrdClmMntLogModel opOrdClmMntLogModel);

    void insertOpClmInfo(List<OpClmInfoModel> opClmInfoModelList);

    void insertOpOrdBnfRelInfoModel(List<OpOrdBnfRelInfoModel> opOrdBnfRelInfoModelList);

    void insertOpOrdCostInfoModel(List<OpOrdCostInfoModel> opOrdCostInfoModelList);

    void updateOpClmInfoCnclCnt(List<OpClmInfoModel> opClmInfoModelList);

    void updateOpClmInfoRtgsCnt(List<OpClmInfoModel> opClmInfoModelList);

    void updateOpOrdBnfInfo(List<OpOrdBnfInfoModel> opOrdBnfInfoModelList);
}
