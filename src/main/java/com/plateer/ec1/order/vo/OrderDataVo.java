package com.plateer.ec1.order.vo;

import com.plateer.ec1.common.model.order.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@Setter
public class OrderDataVo {
    private OpOrdBaseModel opOrdBaseModel;
    private List<OpGoodsInfoModel> opGoodsInfoModelList;
    private List<OpClmInfoModel> clmInfoModelList;
    private List<OpDvpAreaInfoModel> opDvpAreaInfoModelList;
    private List<OpDvpInfoModel> opDvpInfoModelList;
    private List<OpOrdCostInfoModel> opOrdCostInfoModelList;
    private List<OpOrdBnfInfoModel> opOrdBnfInfoModelList;
    private List<OpOrdBnfRelInfoModel> opOrdBnfRelInfoModelList;
    private Long historyNo;
    private String json;
    private String procCcd;
}
