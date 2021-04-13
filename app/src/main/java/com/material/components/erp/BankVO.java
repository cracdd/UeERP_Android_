package com.material.components.erp;

import java.util.Date;

public class BankVO {

    private int bank_code;			// 계좌코드
    private String bank_name;		// 계좌명
    private String bank_no;			// 계좌번호
    private String bank_bank;		// 은행
    private String bank_balance;	// 잔액
    private String bank_object;		// 개설목적
    private Date bank_reg_date;		// 등록일
    private int bank_state;			// 상태

    public String getBank_balance() {
        return bank_balance;
    }

    public void setBank_balance(String bank_balance) {
        this.bank_balance = bank_balance;
    }

    public int getBank_code() {
        return bank_code;
    }

    public void setBank_code(int bank_code) {
        this.bank_code = bank_code;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getBank_no() {
        return bank_no;
    }

    public void setBank_no(String bank_no) {
        this.bank_no = bank_no;
    }

    public String getBank_bank() {
        return bank_bank;
    }

    public void setBank_bank(String bank_bank) {
        this.bank_bank = bank_bank;
    }

    public String getBank_object() {
        return bank_object;
    }

    public void setBank_object(String bank_object) {
        this.bank_object = bank_object;
    }

    public Date getBank_reg_date() {
        return bank_reg_date;
    }

    public void setBank_reg_date(Date bank_reg_date) {
        this.bank_reg_date = bank_reg_date;
    }

    public int getbank_state() {
        return bank_state;
    }

    public void setbank_state(int bank_state) {
        this.bank_state = bank_state;
    }
}
