package com.material.components.erp;

public class DepartmentVO {

    private int dep_code;		// 부서코드
    private String dep_name;	// 부서명
    private int dep_state;		// 상태

    public int getDep_code() {
        return dep_code;
    }

    public void setDep_code(int dep_code) {
        this.dep_code = dep_code;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public int getDep_state() {
        return dep_state;
    }

    public void setDep_state(int dep_state) {
        this.dep_state = dep_state;
    }

}
