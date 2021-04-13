package com.material.components.erp;

import java.util.Date;

public class ProductVO {

    private int pro_code; 		// 상품코드
    private String pro_name; 	// 상품명
    private int pro_pur_price; 	// 구매단가
    private int pro_sal_price; 	// 판매단가
    private int pro_state; 		// 상태
    private Date pro_reg_date; 	// 상품등록일

    public int getPro_code() {
        return pro_code;
    }

    public void setPro_code(int pro_code) {
        this.pro_code = pro_code;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public int getPro_pur_price() {
        return pro_pur_price;
    }

    public void setPro_pur_price(int pro_pur_price) {
        this.pro_pur_price = pro_pur_price;
    }

    public int getPro_sal_price() {
        return pro_sal_price;
    }

    public void setPro_sal_price(int pro_sal_price) {
        this.pro_sal_price = pro_sal_price;
    }

    public int getPro_state() {
        return pro_state;
    }

    public void setPro_state(int pro_state) {
        this.pro_state = pro_state;
    }

    public Date getPro_reg_date() {
        return pro_reg_date;
    }

    public void setPro_reg_date(Date pro_reg_date) {
        this.pro_reg_date = pro_reg_date;
    }

}
