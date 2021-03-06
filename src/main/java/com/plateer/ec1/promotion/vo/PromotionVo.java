package com.plateer.ec1.promotion.vo;

import com.plateer.ec1.common.code.promotion.PRM0003;
import com.plateer.ec1.common.code.promotion.PRM0004;
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
    private String empYn;
    private Long couponIssueNo;
    private String dcCcd;
    private Long dcVal;
    private Integer minPurAmt;
    private Integer maxDcAmt;
    private String useYn;
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
        return "Y".equals(useYn);
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

    public boolean validateMinPurAmt(Long price) {
        return price >= minPurAmt;
    }

    //쿠폰종류코드 - 상품코드 검증
    public boolean validateProductCoupon() {
        return cpnKindCd.equals(PRM0004.PRODUCT_COUPON.getType());
    }

    public boolean validateCartCoupon() {
        return cpnKindCd.equals(PRM0004.CART_COUPON.getType());
    }

    public void calculateDcAmt(Long price) {
        if (PRM0003.FIXED_DISCOUNT.getType().equals(dcCcd)) {
            dcAmt = dcVal;
        } else if (PRM0003.RATE_DISCOUNT.getType().equals(dcCcd)) {
            double calPrice = (price * (dcVal / (double) 100L));
            dcAmt = (long) calPrice;
            validateDcAmt(dcAmt);
        } else {
            System.out.println("ERROR");
        }
    }

    public void validateDcAmt(long dcAmt) {
        if (dcAmt > maxDcAmt) {
            this.dcAmt = Long.valueOf(maxDcAmt);
        }
    }
}
