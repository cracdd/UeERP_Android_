package com.material.components.erp;

public class

Web {

    // servlet-context.xml
    // <beans:property name="jndiName" value="java:comp/env/jdbc/mybatis_76" 으로 수정
    // context.xml  id: mybatis_76  password : tiger


    // 크롬 실행 : http://localhost:8081/android/
    // ipconfig 확인.. 연결이 끊김으로 되어있으면 연결불가
    public static String ip = "192.168.219.130"; //본인 IP
    public static String servletURL = "http://" + ip + "/UsERP/"; // 연결할 JSP URL

}
