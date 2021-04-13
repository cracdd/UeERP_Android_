package com.material.components.erp;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

/* 스프링 컨트롤러와 JSON 연동을 위해 Map<키,값>으로 받기위한 클래스 */
public class Data {

    private String data1;
    private String data2;
    private String data3;
    private String data4;

    @SerializedName("member")   /*import후 오른쪽 위 sync now를 클릭해야 동기화됨*/
    private Map<String, String> member = new HashMap<String, String>();

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public String getData3() {
        return data3;
    }

    public void setData3(String data13) {
        this.data3 = data3;
    }

    public String getData4() {
        return data4;
    }

    public void setData4(String data4) {
        this.data4 = data4;
    }

    public Map<String, String> getMember() {
        return member;
    }

    public void setMember(Map<String, String> member) {
        this.member = member;
    }

}
