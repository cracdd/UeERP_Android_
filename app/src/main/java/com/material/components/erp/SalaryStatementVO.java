package com.material.components.erp;

import java.util.Date;

public class SalaryStatementVO {
    private int ss_code;		// 급여전표번호
    private String ss_total_sal;	// 총 급여
    private Date ss_reg_date;	// 발행일
    private Date ss_sal_date;	// 지급일
    private String ss_state;		// 상태
    private int sal_code;		// 급여코드
    private String emp_code;	// 사원번호
    private int hr_code;		// 인사코드
    private int dep_code;		// 부서코드
    private int acco_code;		// 계정번호
    private int bank_code; 		// 계좌코드
    HrCodeVO hrCode;
    SalaryVO salary;
    EmployeeVO employee;
    DepartmentVO department;
    AccountVO account;
    BankVO bank;

    public int getSs_code() {
        return ss_code;
    }
    public void setSs_code(int ss_code) {
        this.ss_code = ss_code;
    }
    public String getSs_total_sal() {
        return ss_total_sal;
    }
    public void setSs_total_sal(String ss_total_sal) {
        this.ss_total_sal = ss_total_sal;
    }
    public Date getSs_reg_date() {
        return ss_reg_date;
    }
    public void setSs_reg_date(Date ss_reg_date) {
        this.ss_reg_date = ss_reg_date;
    }
    public Date getSs_sal_date() {
        return ss_sal_date;
    }
    public void setSs_sal_date(Date ss_sal_date) {
        this.ss_sal_date = ss_sal_date;
    }
    public String getSs_state() {
        return ss_state;
    }
    public void setSs_state(String ss_state) {
        this.ss_state = ss_state;
    }
    public int getSal_code() {
        return sal_code;
    }
    public void setSal_code(int sal_code) {
        this.sal_code = sal_code;
    }
    public String getEmp_code() {
        return emp_code;
    }
    public void setEmp_code(String emp_code) {
        this.emp_code = emp_code;
    }
    public int getHr_code() {
        return hr_code;
    }
    public void setHr_code(int hr_code) {
        this.hr_code = hr_code;
    }
    public int getDep_code() {
        return dep_code;
    }
    public void setDep_code(int dep_code) {
        this.dep_code = dep_code;
    }
    public int getAcco_code() {
        return acco_code;
    }
    public void setAcco_code(int acco_code) {
        this.acco_code = acco_code;
    }
    public int getBank_code() {
        return bank_code;
    }
    public void setBank_code(int bank_code) {
        this.bank_code = bank_code;
    }
    public HrCodeVO getHrCode() {
        return hrCode;
    }
    public void setHrCode(HrCodeVO hrCode) {
        this.hrCode = hrCode;
    }
    public SalaryVO getSalary() {
        return salary;
    }
    public void setSalary(SalaryVO salary) {
        this.salary = salary;
    }
    public EmployeeVO getEmployee() {
        return employee;
    }
    public void setEmployee(EmployeeVO employee) {
        this.employee = employee;
    }
    public DepartmentVO getDepartment() {
        return department;
    }
    public void setDepartment(DepartmentVO department) {
        this.department = department;
    }
    public AccountVO getAccount() {
        return account;
    }
    public void setAccount(AccountVO account) {
        this.account = account;
    }
    public BankVO getBank() {
        return bank;
    }
    public void setBank(BankVO bank) {
        this.bank = bank;
    }

}
