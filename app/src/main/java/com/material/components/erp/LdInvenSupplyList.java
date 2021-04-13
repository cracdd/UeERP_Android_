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

public class LdInvenSupplyList extends AppCompatActivity {

    private Toolbar toolbar;
    private ActionBar actionBar;

    Button statusinfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._erp_ldinventorysupply);

        initToolbar();

        statusinfo = findViewById(R.id.statusinfo);

        statusinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent invenStatus = new Intent(LdInvenSupplyList.this, LdInvenStatusList.class);
                startActivity(invenStatus);
            }
        });

        InnerTask ldsupply = new InnerTask();
        ldsupply.link = "android/androidSupply";
        ldsupply.execute();
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
            if(link.equals("android/androidSupply")) {
                if(s.length() > 0 ) {
                    Gson gson = new Gson();
//                    Gson gson = new GsonBuilder().setDateFormat("MM dd, yyyy HH:mm:ss").create();
//                      List<StockSupplyVO> vo = new ArrayList<StockSupplyVO>() {
//                      };

                    StockSupplyVO[] list = gson.fromJson(s, StockSupplyVO[].class);
                    List<StockSupplyVO> supplyList = Arrays.asList(list);



                    Ld_StockSupplyAdapter supplyAdapter = new Ld_StockSupplyAdapter(supplyList);

                    ListView supply_list = (ListView)findViewById(R.id.supply_list);
                    supply_list.setAdapter(supplyAdapter);

                }
            }
        }
    }

}
