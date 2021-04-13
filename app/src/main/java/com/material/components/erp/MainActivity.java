package com.material.components.erp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.material.components.R;

public class MainActivity extends AppCompatActivity {

//    InnerTask task = null;
    String id;


    /*@Override
    protected void onResume() {
        super.onResume();

        if(task != null) {
            task.cancel(true);
            task = null;

            task = new InnerTask();
            task.execute(id);
        }
    }*/

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._erp_main);



        Intent intent = getIntent();
        id = intent.getStringExtra("id"); //req.getParameter("id")'



//        task = new InnerTask();
//        task.execute(id);

//        actionBar();
    }

//    private void actionBar() {
//        LayoutInflater inflater = getLayoutInflater();
//        View v = inflater.inflate(R.layout._erp_custom_bar, null);
//        TextView tv_bar = v.findViewById(R.id.tv_bar);
//        tv_bar.setText("MyProject");
//
//        ActionBar bar = getSupportActionBar();
//        bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        bar.setCustomView(v);
//    }

//    private class InnerTask extends AsyncTask {
//
//        //MypageRecyAdapter adapter;
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//        }
//
//        @Override
//        protected Object doInBackground(Object[] objects) {
//            HttpClient.Builder http = new HttpClient.Builder("POST", Web.servletURL + "androidMyPageMain"); //@RequestMapping url
//            http.addOrReplace("id", (String) objects[0]);
//
//            HttpClient post = http.create();
//            post.request();
//
//            String body = post.getBody();
//            return body;
//        }
//
//        @Override
//        protected void onPostExecute(Object o) {
//            Log.d("JSON_RESULT", (String) o);
//            Gson gson = new Gson();
//            Data data = gson.fromJson((String) o, Data.class);
//
//            try {
//                TextView name = (TextView) findViewById(R.id.tv_name);
//                name.setText(data.getData1() + "님");
//
//                Log.d("JSON_RESULT", "사원명 = " + data.getMember().get("emp_name"));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }

}
