package com.example.auser.java110902;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv =(ListView)findViewById(R.id.listView);
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        StringRequest request =new StringRequest("http://data.taipei/opendata/datalist/apiAccess?scope=resourceAquire&rid=5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a",
               new Response.Listener<String>() {

                   @Override
                   public void onResponse(String response) {
                       Gson gson =new Gson();
                       Myzoo z =gson.fromJson(response,Myzoo.class);
                       Log.d("ZOO",z.result.results[0].E_Name);
                       adapter = new MyAdapter(MainActivity.this,z.result.results);
                       lv.setAdapter(adapter);
                   }
               },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ZOO","Error"+error.toString());
            }
        });
        queue.add(request);
        queue.start();
    }

}
