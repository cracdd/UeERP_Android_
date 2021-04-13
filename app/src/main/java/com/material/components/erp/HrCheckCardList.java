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

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class HrCheckCardList extends AppCompatActivity {

    private Toolbar toolbar;
    private ActionBar actionBar;

    Button wagedetail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._erp_hrcardcheck);

        initToolbar();

        wagedetail = findViewById(R.id.wagedetail);

        wagedetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent invenSupply = new Intent(HrCheckCardList.this, HrWageDetailList.class);
                startActivity(invenSupply);
            }
        });

        InnerTask hrcheck = new InnerTask();
        hrcheck.link = "android/androidEmployee";
        hrcheck.execute();


    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.hrtoolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setTitle("인사 관리");
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

        public String link = "";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Map... maps) {
            HttpClient.Builder http = new HttpClient.Builder("POST", Web.servletURL + link);

            HttpClient post = http.create();
            post.request();

            String body = post.getBody();
            Log.d("body body", body);

            return body;
        }

        @Override
        protected void onPostExecute(String s) {
            Log.d("JSON_RESULT", s);
            if(link.equals("android/androidEmployee")) {
                if(s.length() > 0 ) {
                    Gson gson = new Gson();
//                    Gson gson = new GsonBuilder().setDateFormat("MM dd, yyyy HH:mm:ss").create();
//                      List<StockSupplyVO> vo = new ArrayList<StockSupplyVO>() {
//                      };

                    EmployeeVO[] list = gson.fromJson(s, EmployeeVO[].class);
                    List<EmployeeVO> checkList = Arrays.asList(list);

                    Hr_CheckCardAdapter checkAdapter = new Hr_CheckCardAdapter(checkList);

                    ListView check_list = (ListView)findViewById(R.id.check_list);
                    check_list.setAdapter(checkAdapter);

                }
            }
        }
    }
}
