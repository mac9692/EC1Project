package com.plateer.ec1.payment.vo.request;

import lombok.Builder;
import lombok.Data;

import java.io.UnsupportedEncodingException;

@Data
@Builder
public class RequestApproveCompleteVo {
    private String no_tid;
    private String no_oid;
    private String cd_bank;
    private String cd_deal;
    private String dt_trans;
    private String tm_trans;
    private String no_vacct;
    private Long amt_input;
    private String flg_close;
    private String cl_close;
    private String type_msg;
    private String nm_inputbank;
    private String nm_input;
    private String dt_inputstd;
    private String dt_calculstd;
    private String dt_transbase;
    private String cl_trans;
    private String cl_kor;
    private String dt_cshr;
    private String tm_cshr;
    private String no_cshr_appl;
    private String no_cshr_tid;
    private String no_req_tid;
}
