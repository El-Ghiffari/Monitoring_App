package com.example.test_aja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {
    public TextView statusAll;
    public TextView db;
    public TextView sw;
    public TextView tw;
    public ImageView gambarState, serviceImg;
    public ImageView db_img, switch_img, tws_img;
    public DBclass db_item;
    public TwsClass tw_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();
        db_img = (ImageView) findViewById(R.id.btn_db);
        switch_img = (ImageView) findViewById(R.id.btn_switch);
        tws_img = (ImageView) findViewById(R.id.btn_tws);
        TextView serv_txt = findViewById(R.id.status_serv);
        //-------------------------Bagian API gan---------------------------
        statusAll = findViewById(R.id.status_all);
        gambarState = findViewById(R.id.checkBoxBener);
        serviceImg = findViewById(R.id.service);
        db = findViewById(R.id.status_db);
        sw = findViewById(R.id.status_switch);
        tw = findViewById(R.id.status_tws);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:55003/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        MonitoringApi monitoringApi = retrofit.create(MonitoringApi.class);     
        Call<Post> call = monitoringApi.getPosts();
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Post posts = response.body();
                Log.e("cek", String.valueOf(posts.isState()));
                db_item = posts.getDatabase();
                tw_item = posts.getTwsClass();
                Log.e("aman", String.valueOf(posts.isState()));
                //Log.e("respon", posts);

                String content;
                if (posts.isState()) {
                    db.setText("Database OK  ");
                    sw.setText("Switching OK ");
                    tw.setText("TW Service OK");
                    serviceImg.setImageResource(R.drawable.btn_service);
                    serv_txt.setText("Status : Ok");
                    gambarState.setImageResource(R.drawable.group_1);
                } else {
                    if (posts.isSerpis()){
                        serv_txt.setText("Status : Ok");
                        serviceImg.setImageResource(R.drawable.btn_service);
                    } else {
                        serv_txt.setText("Status : Not Ok");
                        serviceImg.setImageResource(R.drawable.btn_service_fault);
                    }
                    gambarState.setImageResource(R.drawable.fault_state);
                    if (posts.getDatabase().isState()){
                        db.setText("Database OK  ");
                    } else {
                        db.setText("Database Not OK ");
                        db_img.setImageResource(R.drawable.db_button_fault);
                    }
                    if (posts.getSwitchClass().isState()){
                        sw.setText("Switching OK  ");
                    } else {
                        sw.setText("Switching Not OK ");
                        switch_img.setImageResource(R.drawable.sw_button_fault);
                    }
                    if (posts.getTwsClass().getState()) {
                        tw.setText("TW Service OK");
                    } else {
                        tw.setText("TW Service Not OK");
                        tws_img.setImageResource(R.drawable.tw_button_fault);
                    }
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                //friendly user message jangan pake baris dibawah
                statusAll.setText("Try to restart app please");
                Log.e("Failure due to : ", t.getMessage());
            }
        });

        //Bagian API berakhir disini gan ---------------------------------------
        db_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, db_view.class);
                intent.putExtra("db item", db_item);
                startActivity(intent);
                //finish();
            }
        });

        switch_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, switch_view.class);
                startActivity(intent);
                //finish();
            }
        });

        tws_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, tws_view.class);
                intent.putExtra("tw item", tw_item);
                startActivity(intent);
                //finish();
            }
        });

        serviceImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, services.class);
                startActivity(i);
            }
        });
//        background bg = new background(HomeActivity.this);
//        bg.execute("root", "");
    }
}