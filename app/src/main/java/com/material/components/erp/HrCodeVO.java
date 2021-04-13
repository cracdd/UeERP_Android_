package com.material.components.erp;

public class HrCodeVO {
    private int hr_code;			// 인사코드
    private String hr_code_name;	// 인사코드명
    private int hr_state;			// 사용상태
    private int hcg_code;			// 그룹번호
    HrCodeGroupVO hrCodeGroup;

    public int getHr_code() {
        return hr_code;
    }
    public void setHr_code(int hr_code) {
        this.hr_code = hr_code;
    }
    public String getHr_code_name() {
        return hr_code_name;
    }
    public void setHr_code_name(String hr_code_name) {
        this.hr_code_name = hr_code_name;
    }
    public int getHr_state() {
        return hr_state;
    }
    public void setHr_state(int hr_state) {
        this.hr_state = hr_state;
    }
    public int getHcg_code() {
        return hcg_code;
    }
    public void setHcg_code(int hcg_code) {
        this.hcg_code = hcg_code;
    }
    public HrCodeGroupVO getHrCodeGroup() {
        return hrCodeGroup;
    }
    public void setHrCodeGroup(HrCodeGroupVO hrCodeGroup) {
        this.hrCodeGroup = hrCodeGroup;
    }
}
