package com.material.components.erp;

public class WarehouseVO {

    private int ware_code;			// 창고코드
    private String ware_name;		// 창고명
    private String ware_location;	// 창고주소
    private int	ware_state;			// 상태
    private int ware_type;

    public int getWare_code() {
        return ware_code;
    }
    public void setWare_code(int ware_code) {
        this.ware_code = ware_code;
    }
    public String getWare_name() {
        return ware_name;
    }
    public void setWare_name(String ware_name) {
        this.ware_name = ware_name;
    }
    public String getWare_location() {
        return ware_location;
    }
    public void setWare_location(String ware_location) {
        this.ware_location = ware_location;
    }
    public int getWare_state() {
        return ware_state;
    }
    public void setWare_state(int ware_state) {
        this.ware_state = ware_state;
    }
    public int getWare_type() {
        return ware_type;
    }
    public void setWare_type(int ware_type) {
        this.ware_type = ware_type;
    }

}
