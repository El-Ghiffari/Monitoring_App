package com.example.test_aja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class switch_view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_view);
        getSupportActionBar().hide();

        ImageButton btnDB1 = (ImageButton) findViewById(R.id.btn_db_intent1);
        btnDB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(switch_view.this, db_view.class);
                startActivity(i);
                //finish();
            }
        });

        ImageButton btnTWS1 = (ImageButton) findViewById(R.id.btn_tws_intent1);
        btnTWS1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(switch_view.this, tws_view.class);
                startActivity(i);
                //finish();
            }
        });

        ImageButton btnHome1 = (ImageButton) findViewById(R.id.imageButton5);
        btnHome1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(switch_view.this, HomeActivity.class);
                startActivity(i);
                //finish();
            }
        });
    }
}