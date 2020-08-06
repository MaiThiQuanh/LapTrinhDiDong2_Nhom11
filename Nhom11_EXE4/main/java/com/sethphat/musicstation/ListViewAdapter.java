package com.sethphat.musicstation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Video> list;

    public ListViewAdapter(Context context, int layout, List<Video> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView =  layoutInflater.inflate(R.layout.dong_listview,null);
        TextView txtTenBh = (TextView) convertView.findViewById(R.id.txtTenBaiHat);
        ImageView imgM3 = (ImageView) convertView.findViewById(R.id.imgMp3);
        txtTenBh.setText(list.get(position).getTxtTenBaiHat());
        imgM3.setImageResource(list.get(position).getImgHinh());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MediaPlayer.class);
                Bundle bundle = new Bundle();
                bundle.putString("TENBH",list.get(position).getId());
                intent.putExtra("BH",bundle);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}

