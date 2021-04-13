package com.material.components.erp;

public class SalaryVO {
    private int sal_code;   // 급여코드
    private int sal_basic;  // 기본급
    private int sal_night;  // 야근수당
    private int sal_over;   // 특근수당
    private int sal_cos;    // 근속수당
    private int sal_or;     // 직책수당

    public int getSal_code() {
        return sal_code;
    }
    public void setSal_code(int sal_code) {
        this.sal_code = sal_code;
    }
    public int getSal_basic() {
        return sal_basic;
    }
    public void setSal_basic(int sal_basic) {
        this.sal_basic = sal_basic;
    }
    public int getSal_night() {
        return sal_night;
    }
    public void setSal_night(int sal_night) {
        this.sal_night = sal_night;
    }
    public int getSal_over() {
        return sal_over;
    }
    public void setSal_over(int sal_over) {
        this.sal_over = sal_over;
    }
    public int getSal_cos() {
        return sal_cos;
    }
    public void setSal_cos(int sal_cos) {
        this.sal_cos = sal_cos;
    }
    public int getSal_or() {
        return sal_or;
    }
    public void setSal_or(int sal_or) {
        this.sal_or = sal_or;
    }
}
