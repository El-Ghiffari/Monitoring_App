package com.example.test_aja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class db_view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_view);
        getSupportActionBar().hide();
        Intent i = getIntent();
        DBclass db_item1 = i.getParcelableExtra("db item");
        TextView lastcheck = findViewById(R.id.lastcheck);
        String check1 = db_item1.getLastCheck();
        lastcheck.setText("Last Check : " + check1);
        if (db_item1.isState()){
            ImageView imgUtama = findViewById(R.id.imageView);
            imgUtama.setImageResource(R.drawable.group_1);
            TextView responsetime = findViewById(R.id.responseTime);
            int restime = Integer.parseInt(db_item1.getResponseTime());
            int seconds = (int) (restime / 1000) % 60 ;
            int minutes = (int) ((restime / (1000*60)) % 60);
            int hours   = (int) ((restime / (1000*60*60)) % 24);
            responsetime.setText(hours+"H "+minutes+"m "+seconds+" s");
            ImageView imgBut = findViewById(R.id.imageButton2);
            imgBut.setImageResource(R.drawable.ok_status);
        } else {
            ImageView imgUtama = findViewById(R.id.imageView);
            imgUtama.setImageResource(R.drawable.fault_state);
            ImageView imgBut = findViewById(R.id.imageButton2);
            imgBut.setImageResource(R.drawable.notokbutton);
        }

        ImageButton btnSwitch = (ImageButton) findViewById(R.id.btn_switch_intent);
        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(db_view.this, switch_view.class);
                startActivity(i);
                //finish();
            }
        });

        ImageButton btnTWS = (ImageButton) findViewById(R.id.btn_tws_intent);
        btnTWS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(db_view.this, tws_view.class);
                startActivity(i);
                //finish();
            }
        });

        ImageButton btnHome = (ImageButton) findViewById(R.id.imageButton3);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(db_view.this, HomeActivity.class);
                startActivity(i);
                //finish();
            }
        });
    }
}