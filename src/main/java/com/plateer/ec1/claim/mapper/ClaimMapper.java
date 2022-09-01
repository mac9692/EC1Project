package com.plateer.ec1.claim.mapper;

import com.plateer.ec1.claim.vo.OrderClaimInfoVo;
import com.plateer.ec1.claim.vo.request.RequestClaimVo;
import com.plateer.ec1.common.model.order.*;
import com.plateer.ec1.order.vo.OrderGoodsVo;
import com.plateer.ec1.product.vo.ProductVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClaimMapper {
    public String getOrderNo();

    public String getClaimNo();
    public ProductVo getGoodsForValidate(OrderClaimInfoVo orderClaimInfoVo);
    public List<OpClmInfoModel> getOpClmInfoModelList(RequestClaimVo requestClaimVo);
    public List<OpOrdCostInfoModel> getOpOrdCostInfoModelList(RequestClaimVo requestClaimVo);
    public List<OpOrdBnfRelInfoModel> getOpOrdBnfRelInfoModelList(RequestClaimVo requestClaimVo);
    public List<OpOrdBnfInfoModel> getOpOrdBnfInfoModelList(RequestClaimVo requestClaimVo);
    public List<OpPayInfoModel> getOpPayInfoModelList(RequestClaimVo requestClaimVo);

}
