package com.material.components.erp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;
import com.material.components.R;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText edtId, edtPwd;
    TextView btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._erp_login);

        // 토큰 가져와서 Firebase에 입력
        String msg = FirebaseInstanceId.getInstance().getToken();
        System.out.println("msg : "+msg);
        // 입력 끝

        edtId = (TextInputEditText) findViewById(R.id.edt_id);
        edtPwd = (TextInputEditText) findViewById(R.id.edt_pwd);
        btnLogin = (TextView) findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                InnerTask task = new InnerTask();
                Map<String, String> map = new HashMap<>();
                map.put("id", edtId.getText().toString());
                map.put("pwd", edtPwd.getText().toString());
                task.execute(map);
            }
        });
//        actionBar();
    }

//    public void actionBar() {
//        ActionBar bar = getSupportActionBar();
//        bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        bar.setCustomView(R.layout._erp_custom_bar);
//
//        LayoutInflater inflater = LayoutInflater.from(this);
//        View v = inflater.inflate(R.layout._erp_custom_bar, null);
//        TextView tv_bar = (TextView) v.findViewById(R.id.tv_bar);
//        tv_bar.setText("로그인");
//        bar.setCustomView(v);
//    }

    // 각 Activity 마다 Task 작성
    public class InnerTask extends AsyncTask<Map, Integer, String> {

        // doInBackground 실행되기 이전에 동작
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        // 작업을 쓰레드로 처리
        @Override
        protected String doInBackground(Map... maps) {
            // HTTP 요청 준비
            HttpClient.Builder http = new HttpClient.Builder("POST", Web.servletURL + "android/androidLogin"); // 스프링 url
            // 파라미터 전송
            http.addAllParameters(maps[0]);

            // HTTP 요청 전송
            HttpClient post = http.create();
            post.request();

            String body = post.getBody(); // Web의 Controller에서 리턴한 값
            Log.d("--- body ---", body);
            return body;
        }

        //doInBackground 종료되면 동작
        /**
         * @param s : doInBackground에서 리턴한 body. JSON 데이터
         */
        @Override
        protected void onPostExecute(String s) {
            Log.d("JSON_RESULT", s);

            // JSON으로 받은 데이터를 VO Obejct로 바꿔준다
            if(s.length() > 0) {
                Gson gson = new Gson();
                EmployeeVO m = gson.fromJson(s, EmployeeVO.class);
                if (m.getEmp_name() != null) {
                    // 페이지 이동
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("name", m.getEmp_name());
                    startActivity(intent);
                }
            } else {
                Toast.makeText(getApplicationContext(), "등록되지 않은 계정이거나, 사원번호 또는 비밀번호를 잘못 입력하셨습니다. \n확인 후 다시 시도해 주십시오.", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
