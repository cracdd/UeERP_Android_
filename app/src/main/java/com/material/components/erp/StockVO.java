package com.material.components.erp;

import java.util.Date;

public class StockVO {

    private int sto_code;			// 재고코드
    private String sto_quantity;		// 재고수량
    private Date sto_reg_date;		// 등록일
    private int ware_code;			// 창고번호
    private int pro_code; 			// 상품코드
    WarehouseVO warehouse;
    ProductVO product;

    public int getSto_code() {
        return sto_code;
    }
    public void setSto_code(int sto_code) {
        this.sto_code = sto_code;
    }
    public String getSto_quantity() {
        return sto_quantity;
    }
    public void setSto_quantity(String sto_quantity) {
        this.sto_quantity = sto_quantity;
    }
    public Date getSto_reg_date() {
        return sto_reg_date;
    }
    public void setSto_reg_date(Date sto_reg_date) {
        this.sto_reg_date = sto_reg_date;
    }
    public int getWare_code() {
        return ware_code;
    }
    public void setWare_code(int ware_code) {
        this.ware_code = ware_code;
    }
    public int getPro_code() {
        return pro_code;
    }
    public void setPro_code(int pro_code) {
        this.pro_code = pro_code;
    }
    public WarehouseVO getWarehouse() {
        return warehouse;
    }
    public void setWarehouse(WarehouseVO warehouse) {
        this.warehouse = warehouse;
    }
    public ProductVO getProduct() {
        return product;
    }
    public void setProduct(ProductVO product) {
        this.product = product;
    }

}
