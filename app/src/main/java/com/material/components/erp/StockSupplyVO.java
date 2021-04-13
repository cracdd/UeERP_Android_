package com.material.components.erp;

public class StockSupplyVO {

    private int stsu_code;         // 재고수불부코드
    private String stsu_reg_date;    // 일자
    private String stsu_type;         // 유형
    private String stsu_quantity;     // 재고
    private String stsu_content;   // 사유
    private String stsu_amount;       // 수량
    private String stsu_startwh;   // 출발창고
    private String stsu_arrivewh;  // 도착창고
    private int sto_code;          // 재고코드
    private int pro_code;          // 상품코드
    private String emp_code;       // 사원코드
    StockVO stock;
    ProductVO product;
    EmployeeVO employee;

    public int getStsu_code() {
        return stsu_code;
    }
    public void setStsu_code(int stsu_code) {
        this.stsu_code = stsu_code;
    }
    public String getStsu_reg_date() {
        return stsu_reg_date;
    }
    public void setStsu_reg_date(String stsu_reg_date) {
        this.stsu_reg_date = stsu_reg_date;
    }
    public String getStsu_type() {
        return stsu_type;
    }
    public void setStsu_type(String stsu_type) {
        this.stsu_type = stsu_type;
    }
    public String getStsu_quantity() {
        return stsu_quantity;
    }
    public void setStsu_quantity(String stsu_quantity) {
        this.stsu_quantity = stsu_quantity;
    }
    public String getStsu_content() {
        return stsu_content;
    }
    public void setStsu_content(String stsu_content) {
        this.stsu_content = stsu_content;
    }
    public String getStsu_amount() {
        return stsu_amount;
    }
    public void setStsu_amount(String stsu_amount) {
        this.stsu_amount = stsu_amount;
    }
    public String getStsu_startwh() {
        return stsu_startwh;
    }
    public void setStsu_startwh(String stsu_startwh) {
        this.stsu_startwh = stsu_startwh;
    }
    public String getStsu_arrivewh() {
        return stsu_arrivewh;
    }
    public void setStsu_arrivewh(String stsu_arrivewh) {
        this.stsu_arrivewh = stsu_arrivewh;
    }
    public int getSto_code() {
        return sto_code;
    }
    public void setSto_code(int sto_code) {
        this.sto_code = sto_code;
    }
    public int getPro_code() {
        return pro_code;
    }
    public void setPro_code(int pro_code) {
        this.pro_code = pro_code;
    }
    public String getEmp_code() {
        return emp_code;
    }
    public void setEmp_code(String emp_code) {
        this.emp_code = emp_code;
    }
    public StockVO getStock() {
        return stock;
    }
    public void setStock(StockVO stock) {
        this.stock = stock;
    }
    public ProductVO getProduct() {
        return product;
    }
    public void setProduct(ProductVO product) {
        this.product = product;
    }
    public EmployeeVO getEmployee() {
        return employee;
    }
    public void setEmployee(EmployeeVO employee) {
        this.employee = employee;
    }
}
