package com.material.components.erp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.gson.Gson;
import com.material.components.R;
import com.material.components.utils.Tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LdInvenStatusList extends AppCompatActivity {

    List<StockVO> list;
    private Toolbar toolbar;
    private ActionBar actionBar;

    Button supply;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._erp_ldinventorystatus);

        initToolbar();

        supply = findViewById(R.id.supplyinfo);

        supply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent invenSupply = new Intent(LdInvenStatusList.this, LdInvenSupplyList.class);
                startActivity(invenSupply);
            }
        });

        list=new ArrayList<StockVO>();
        InnerTask task = new InnerTask();
        task.execute();
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.ldtoolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setTitle("물류 관리");
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

    public class InnerTask extends AsyncTask<Map, Integer, String> {

        @Override
        protected void onPreExecute() {super.onPreExecute();}

        @Override
        protected String doInBackground(Map... maps) {
            //HTTP 요청 준비
            HttpClient.Builder http = new HttpClient.Builder("POST", Web.servletURL + "android/androidStock"); //스프링 url
            //파라미터 전송

            //HTTP 요청 전송
            HttpClient post = http.create();
            post.request();

            // 안드로이드에서 응답받음
            String body = post.getBody(); //Web의 Controller에서 리턴한 값
            Log.d("body------", body);

            return body;
        }

        @Override
        protected void onPostExecute(String s) {
            Log.d("json------", s);

            if(s.length()>0) {
                Gson gson = new Gson();

                StockVO[] m = gson.fromJson(s.toString(), StockVO[].class);
                list = Arrays.asList(m);

                // 2. 어댑터 생성 .. 데이터를 가져오기 위함
                Ld_StockStautsAdapter adapter = new Ld_StockStautsAdapter(list);  // WeatherAdapter 매개변수 생성자를 먼저 만들 만들고 생성

                // 3. 뷰와 어댑터를 연결
                ListView listview = findViewById(R.id.stock_list_2);
                listview.setAdapter(adapter);
            }
        }
    }
}