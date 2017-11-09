package com.example.auser.java110902;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by auser on 2017/11/9.
 */

public class MyAdapter extends BaseAdapter {
    Context context;
    ZooInfo[] zooInfo;
    public MyAdapter(Context context,ZooInfo[] zooInfo){
        this.context = context;
        this.zooInfo = zooInfo;
    }
    @Override
    public int getCount() {
        return zooInfo.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View conveview, ViewGroup parent) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View v =inflater.inflate(R.layout.myitem,null);
        TextView tv =(TextView)v.findViewById(R.id.textView);
        tv.setText(zooInfo[position].E_Name);
        ImageView img =(ImageView)v.findViewById(R.id.imageView);
        Picasso.with(context).load(zooInfo[position].E_Pic_URL).into(img);
        EditText et =(EditText)v.findViewById(R.id.editText3);
        et.setText(zooInfo[position].E_Info);




        return v;
    }
}
