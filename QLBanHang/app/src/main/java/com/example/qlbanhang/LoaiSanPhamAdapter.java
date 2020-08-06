package com.example.qlbanhang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class LoaiSanPhamAdapter extends BaseAdapter {

    ArrayList<Loaisp> arraylistloaisp;
    Context context;

    public LoaiSanPhamAdapter(ArrayList<Loaisp> arraylistloaisp, Context context) {
        this.arraylistloaisp = arraylistloaisp;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arraylistloaisp.size();
    }

    @Override
    public Object getItem(int position) {
        return arraylistloaisp.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class ViewHolder{
        TextView txttenloaisp;
        ImageView imgloaisp;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dong_listview_loaisp,null);
            viewHolder.txttenloaisp = (TextView) convertView.findViewById(R.id.textviewloaisp);
            viewHolder.imgloaisp = (ImageView) convertView.findViewById(R.id.imageviewloaisp);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();

        }
        Loaisp loaisp = (Loaisp) getItem(position);
        viewHolder.txttenloaisp.setText(loaisp.getTenloaisp());
        Picasso.with(context).load(loaisp.getHinhanhloaisp())
                .placeholder(R.drawable.noimage)
                .error(R.drawable.er)
                .into(viewHolder.imgloaisp);
        //Gan animation
//        Animation animation = AnimationUtils.loadAnimation(context, R.anim.fade_in);
//        convertView.startAnimation(animation);

        return convertView;
    }
}

