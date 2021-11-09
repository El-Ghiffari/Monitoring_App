package com.example.test_aja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class tws_view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tws_view);
        getSupportActionBar().hide();
        Intent i = getIntent();
        TwsClass tw_item1 = i.getParcelableExtra("tw item");
        TextView lastcheck = findViewById(R.id.editText2);
        String check1 = tw_item1.getLastCheck();
        lastcheck.setText("Last Check : " + check1);
        if (tw_item1.getState()){
            ImageView imgUtama = findViewById(R.id.imageView6);
            imgUtama.setImageResource(R.drawable.tws_ok);
            TextView responsetime = findViewById(R.id.responseTime1);
            int restime = Integer.parseInt(tw_item1.getResponseTime());
            int seconds = (int) (restime / 1000) % 60 ;
            int minutes = (int) ((restime / (1000*60)) % 60);
            int hours   = (int) ((restime / (1000*60*60)) % 24);
            responsetime.setText(hours+"H "+minutes+"m "+seconds+" s");
            ImageView imgBut = findViewById(R.id.imageView7);
            imgBut.setImageResource(R.drawable.ok_status);
        } else {
            ImageView imgUtama = findViewById(R.id.imageView6);
            imgUtama.setImageResource(R.drawable.fault_state);
            ImageView imgBut = findViewById(R.id.imageView7);
            imgBut.setImageResource(R.drawable.notokbutton);
        }

        ImageButton btnDB2 = (ImageButton) findViewById(R.id.btn_db_intent2);
        btnDB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(tws_view.this, db_view.class);
                startActivity(i);
                //finish();
            }
        });

        ImageButton btnSwitch2 = (ImageButton) findViewById(R.id.btn_switch_intent2);
        btnSwitch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(tws_view.this, switch_view.class);
                startActivity(i);
                //finish();
            }
        });

        ImageButton btnHome2 = (ImageButton) findViewById(R.id.imageButton7);
        btnHome2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(tws_view.this, HomeActivity.class);
                startActivity(i);
                //finish();
            }
        });
    }
}