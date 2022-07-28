package com.plateer.ec1.order.vo;

import com.plateer.ec1.common.model.order.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class OrderDataVo {
    private OpOrdBaseModel opOrdBaseModel;
    private OpGoodsInfoModel opGoodsInfoModel;
    private OpClmInfoModel clmInfoModel;
    private OpDvpAreaInfoModel opDvpAreaInfoModel;
    private OpOrdCostInfoModel opOrdCostInfoModel;
    private OpOrdBnfInfoModel opOrdBnfInfoModel;
    private OpOrdBnfRelInfoModel opOrdBnfRelInfoModel;
    private Long historyNo;
    private String json;
    private String procCcd;
}
