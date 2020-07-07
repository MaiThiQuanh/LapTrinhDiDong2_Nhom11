package com.example.thucdonnhahang.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thucdonnhahang.Model.Loaimonan;
import com.example.thucdonnhahang.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LoaimonanAdapter extends BaseAdapter {

    ArrayList<Loaimonan> arrayListloaimonan;
    Context context;

    public LoaimonanAdapter(ArrayList<Loaimonan> arrayListloaimonan, Context context) {
        this.arrayListloaimonan = arrayListloaimonan;
        this.context = context;
    }
    @Override
    public int getCount() {
        return arrayListloaimonan.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListloaimonan.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{
        TextView txttenloaimonan;
        ImageView imgloaimonan;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dong_listview_loaimonan,null);
            viewHolder.txttenloaimonan = (TextView) convertView.findViewById(R.id.textviewloaimonan);
            viewHolder.imgloaimonan = (ImageView) convertView.findViewById(R.id.imageviewloaimonan);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();

        }
        Loaimonan loaimonan = (Loaimonan) getItem(position);
        viewHolder.txttenloaimonan.setText(loaimonan.getTenloaimonan());
        //Add thu vien doc dan hinh anh tu internet
        Picasso.with(context).load(loaimonan.getHinhanhloaimonan()).into(viewHolder.imgloaimonan);

        return convertView;
    }
}
