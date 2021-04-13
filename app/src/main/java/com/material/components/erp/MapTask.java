package com.material.components.erp;


// AsyncTack : 따로 쓰레드를 만들지 않아도 알아서 쓰레드로 처리. 추상. BaseClass(부모, SuperClass)
// 사용하지 않을 경우 모든 쓰레드에 대한 처리가 필요
// 쓰레드 + 핸들러

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.util.Map;

/**
 * Parameter Type of doInBackground : Map
 * Progress : Integer
 * Return Type of
 */
public class MapTask extends AsyncTask<Map, Integer, String> {

    private String url;

    MapTask() {
        url = Web.servletURL + "androidTest";
    }

    MapTask(String url) {
        this.url = Web.servletURL + url;
    }

    // doInBackground 실행되기 이전에 동작
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    // 작업을 쓰레드로 처리
    @Override
    protected String doInBackground(Map... maps) {
        // HTTP 요청 준비
        HttpClient.Builder http = new HttpClient.Builder("POST", url);

        // 파라미터 전송
        http.addAllParameters(maps[0]);

        // HTTP 요청 전송
        HttpClient post = http.create();
        post.request();

        // 응답 상태 코드
        int statusCode = post.getHttpStatusCode();

        // 응답 본문
        String body = post.getBody(); //Web의 Controller에서 리턴한 값
        return body;
    }

    //doInBackground 종료되면 동작
    /**
     * 직렬화(Object -> json) : gson.toJson() :
     * 역직렬화 (json -> object) : gson.fromJson()
     * @param s : doInBackground에서 리턴한 body. JSON 데이터
     *
     */
    @Override
    protected void onPostExecute(String s) {
        //super.onPostExecute(s);
        Log.d("JSON_RESULT", s);

        //JSON으로 받은 데이터를 VO Obejct로 바꿔준다.
        Gson gson = new Gson();

        // gson이 역직렬화하는 코드
        EmployeeVO vo = gson.fromJson(s, EmployeeVO.class);
        Log.d("JSON_RESULT", vo.getEmp_code());
        Log.d("JSON_RESULT", vo.getEmp_pwd());
    }

}
