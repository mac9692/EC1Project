package com.plateer.ec1.promotion.vo;

import com.plateer.ec1.common.code.promotion.PRM0003;
import com.plateer.ec1.product.vo.ProductVo;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class PromotionVo {

    private Long prmNo;
    private String prmNm;
    private String mbrNo;
    private String prmKindCd;
    private String prmPriodCcd;
    private Timestamp prmStrtDt;
    private Timestamp prmEndDt;
    private Long couponIssueNo;
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
    private Timestamp cpnUseDt;
    private Long dcAmt;
    private String maxBenefitYn;

    //프로모션 사용여부 검증
    public boolean validateUseYn() {
        return useYn.equals("Y");
    }

    //쿠폰 사용일자 검증(쿠폰 사용여부 검증)
    public boolean validateCouponUseDt() {
        return cpnUseDt == null;
    }

    //프로모션 기간 유효성 검증
    public boolean validatePromotionDate() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return prmStrtDt.before(timestamp) && prmEndDt.after(timestamp);
    }

    public void calculateDcAmt(ProductCouponVo productCouponVo) {
        if (dcCcd.equals(PRM0003.FIXED_DISCOUNT.getType())) {
            dcAmt = productCouponVo.getProductVo().validatePrmPrc() - dcVal;
        } else if (dcCcd.equals(PRM0003.RATE_DISCOUNT.getType())) {
            dcAmt = productCouponVo.getProductVo().validatePrmPrc() / dcVal;
        } else {
            System.out.println("ERROR");
        }
    }
}
