package com.example.qlbanhang;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class DienThoaiAdapter extends BaseAdapter {

    private MainActivity context;
    private int layout;
    private List<DienThoai> dienThoaiList;

    public DienThoaiAdapter(MainActivity context, int layout, List<DienThoai> dienThoaiList) {
        this.context = context;
        this.layout = layout;
        this.dienThoaiList = dienThoaiList;
    }

    @Override
    public int getCount() {
        return dienThoaiList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class ViewHolder{
        public TextView txttendienthoai,txtgiadienthoai,txtmotadienthoai;
        public ImageView imgdienthoai, imgDelete, imgEdit;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            holder.txttendienthoai = (TextView) view.findViewById(R.id.textviewdienthoai);
            holder.txtgiadienthoai = (TextView) view.findViewById(R.id.textviewgiadienthoai);
            holder.txtmotadienthoai = (TextView) view.findViewById(R.id.textviewmotadienthoai);
            holder.imgdienthoai = (ImageView) view.findViewById(R.id.imageviewdienthoai);
            holder.imgDelete = (ImageView) view.findViewById(R.id.imageDelete);
            holder.imgEdit = (ImageView) view.findViewById(R.id.imageviewEdit);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        final DienThoai dienThoai = dienThoaiList.get(i);
        holder.txttendienthoai.setText(dienThoai.getTenSanPham());
        holder.txtgiadienthoai.setText(dienThoai.getGiaSanPham());
        holder.txtmotadienthoai.setText(dienThoai.getMoTaSanPham());

        //bat su kien xoa va sua
        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.DialogSuaSanPham(dienThoai.getTenSanPham(),dienThoai.getId());
            }
        });

        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.DialogXoaSanPham(dienThoai.getTenSanPham(),dienThoai.getId());
            }
        });

        //chuyen
        byte[] hinhAnh = dienThoai.getHinhAnhSanPham();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinhAnh,0,hinhAnh.length);
        holder.imgdienthoai.setImageBitmap(bitmap);
        return view;
    }
}
