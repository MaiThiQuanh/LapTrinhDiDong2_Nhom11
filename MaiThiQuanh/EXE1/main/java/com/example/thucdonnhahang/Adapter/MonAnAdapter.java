package com.example.thucdonnhahang.Adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thucdonnhahang.Model.MonAn;
import com.example.thucdonnhahang.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MonAnAdapter extends BaseAdapter {
    Context context;
    ArrayList<MonAn> arraymonan;

    public MonAnAdapter(Context context, ArrayList<MonAn> arraymonan) {
        this.context = context;
        this.arraymonan = arraymonan;
    }

    @Override
    public int getCount() {
        return arraymonan.size();
    }

    @Override
    public Object getItem(int position) {
        return arraymonan.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class ViewHolder{
        public TextView txttenmonan,txtgiamonan,txtmotamonan;
        public ImageView imgmonan;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dong_monan,null);
            viewHolder.txttenmonan = (TextView) convertView.findViewById(R.id.textviewmonan);
            viewHolder.txtgiamonan = (TextView) convertView.findViewById(R.id.textviewgiamonan);
            viewHolder.txtmotamonan = (TextView) convertView.findViewById(R.id.textviewmotamonan);
            viewHolder.imgmonan = (ImageView) convertView.findViewById(R.id.imageviewmoan);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        MonAn monAn = (MonAn) getItem(position);
        viewHolder.txttenmonan.setText(monAn.getTenmonan());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtgiamonan.setText("Giá: " + decimalFormat.format(monAn.getGiamonan()) + "đ");
        viewHolder.txtmotamonan.setMaxLines(2);
        //Kieu mo ta neu dai se hien thi dau ...
        viewHolder.txtmotamonan.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.txtmotamonan.setText(monAn.getMotamonan());
        Picasso.with(context).load(monAn.getHinhanhmonan()).into(viewHolder.imgmonan);
        return convertView;
    }
}
