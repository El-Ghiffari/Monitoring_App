//package com.example.test_aja;
//
//import android.os.AsyncTask;
//import android.app.AlertDialog;
//import android.content.Context;
//import android.content.Intent;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.io.OutputStreamWriter;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLEncoder;
//
//public class background extends AsyncTask <String, Void, String> {
//    AlertDialog dialog;
//    Context context;
//    public Boolean login = false;
//    public background(Context context)
//    {
//        this.context = context;
//    }
//
//    @Override
//    protected void onPreExecute() {
//        dialog = new AlertDialog.Builder(context).create();
//        dialog.setTitle("DB OK");
//
//    }
//    @Override
//    protected void onPostExecute(String s) {
//        dialog.setMessage(s);
//        dialog.show();
//        if(s.contains("successful"))
//        {
//            Intent intent_name = new Intent();
//            intent_name.setClass(context.getApplicationContext(),db_view.class);
//            context.startActivity(intent_name);
//        } else {
//            //DB is Not OK...
//        }
//    }
//
//    @Override
//    protected boolean doInBackground(String... voids){
//        String user = voids[0];
//        String pass = voids[1];
//
//        String connstr = "http://localhost:127.0.0.1/konek.php";
//
//        try {
//            URL url = new URL(connstr);
//            HttpURLConnection http = (HttpURLConnection) url.openConnection();
//            http.connect();
////            if (http.){
////                return true;
////            }
//            http.disconnect();
//        } catch (IOException e) {
//            result = e.getMessage();
//        }
//        return false;
//    }
//}
