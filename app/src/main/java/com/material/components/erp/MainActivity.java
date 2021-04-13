package com.material.components.erp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.material.components.R;

public class MainActivity extends AppCompatActivity {

    String id;
    TableLayout hr;
    TableLayout ac;
    TableLayout ld;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._erp_main);

        Intent intent = getIntent();
        id = intent.getStringExtra("name"); //req.getParameter("id")'

        //추가 시작
        hr=findViewById(R.id.hr_team);
        ac=findViewById(R.id.ac_team);
        ld=findViewById(R.id.ld_team);

        hr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hri = new Intent(MainActivity.this,HrCheckCardList.class);
                startActivity(hri);
            }
        });

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aci = new Intent(MainActivity.this, AcFinancialList.class);
                startActivity(aci);
            }
        });

        ld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ldi = new Intent(MainActivity.this, LdInvenStatusList.class);
                startActivity(ldi);
            }
        });

    }


}
