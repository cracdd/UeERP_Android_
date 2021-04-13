package com.material.components.erp;

public class AccountVO {

    private int acco_code;		// 계정번호
    private String acco_name;	// 계정명
    private String acco_sum;	// 계정금액

    public int getAcco_code() {
        return acco_code;
    }
    public void setAcco_code(int acco_code) {
        this.acco_code = acco_code;
    }
    public String getAcco_name() {
        return acco_name;
    }
    public void setAcco_name(String acco_name) {
        this.acco_name = acco_name;
    }
    public String getAcco_sum() {
        return acco_sum;
    }
    public void setAcco_sum(String acco_sum) {
        this.acco_sum = acco_sum;
    }
}
