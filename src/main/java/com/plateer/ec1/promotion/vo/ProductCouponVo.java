package com.plateer.ec1.promotion.vo;

import com.plateer.ec1.product.vo.Product;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class ProductCouponVo {

    private Long prmNo;
    private String prmNm;
    private String prmKindCd;
    private String prmPriodCcd;
    private Timestamp prmStrtDt;
    private Timestamp prmEndDt;
    private String dcCcd;
    private Integer dcVal;
    private Integer minPurAmt;
    private Integer maxDcAmt;
    private String useYn;
    private String aplyTgtCcd;
    private String aplyTgtNo;
    private String cpnKindCd;
    private String degrCcd;
    private String mdaGb;
    private String entChnGb;
    private Long cpnIssNo;
    private String mbrNo;
    private Timestamp cpnUseDt;

}
