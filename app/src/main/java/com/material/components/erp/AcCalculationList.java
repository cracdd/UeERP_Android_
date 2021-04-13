package com.material.components.erp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.material.components.R;
import com.material.components.utils.Tools;

import java.util.Map;

public class AcCalculationList extends AppCompatActivity {

    private Toolbar toolbar;
    private ActionBar actionBar;
    TextInputEditText sum, sum1, sum2, sum3, sum4;

    Button financial;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._erp_accalculation);

        initToolbar();

        InnerTask accal = new InnerTask();
        accal.execute();


        financial = findViewById(R.id.financial);

        financial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent invenSupply = new Intent(AcCalculationList.this, AcFinancialList.class);
                startActivity(invenSupply);
            }
        });

    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.actoolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setTitle("회계 관리");
        Tools.setSystemBarColor(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu._erp_commonmenu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        //or switch문을 이용하면 될듯 하다.
        if (id == R.id.nav_home) {
            Intent mainHome = new Intent(this, MainActivity.class);
            startActivity(mainHome);
        }

        if (id == R.id.nav_hr) {
            Intent hrTeam = new Intent(this, HrCheckCardList.class);
            startActivity(hrTeam);
        }

        if (id == R.id.nav_ld) {
            Intent ldTeam = new Intent(this, LdInvenStatusList.class);
            startActivity(ldTeam);
        }

        if (id == R.id.nav_ac) {
            Intent acTeam = new Intent(this, AcFinancialList.class);
            startActivity(acTeam);
        }

        return super.onOptionsItemSelected(item);
    }

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
            HttpClient.Builder http = new HttpClient.Builder("POST", Web.servletURL + "android/androidIS"); // 스프링 url
            // 파라미터 전송
//            http.addAllParameters(maps[0]);

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
                SumVO m = gson.fromJson(s, SumVO.class);

                TextView sum = findViewById(R.id.calsum);
                sum.setText(m.getSum());
                TextView sum1 = findViewById(R.id.calsum1);
                sum1.setText(m.getSum1());
                TextView sum2 = findViewById(R.id.calsum2);
                sum2.setText(m.getSum2());
                TextView sum3 = findViewById(R.id.calsum3);
                sum3.setText(m.getSum3());
                TextView sum4 = findViewById(R.id.calsum4);
                sum4.setText(m.getSum4());
            }
        }

    }
}