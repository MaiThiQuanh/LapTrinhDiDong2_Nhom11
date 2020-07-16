package com.example.thucdonnhahang.Model;

public class Loaimonan {
    public int Id;
    public String Tenloaimonan;
    public String Hinhanhloaimonan;

    public Loaimonan(int id, String tenloaimonan, String hinhanhloaimonan) {
        Id = id;
        Tenloaimonan = tenloaimonan;
        Hinhanhloaimonan = hinhanhloaimonan;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTenloaimonan() {
        return Tenloaimonan;
    }

    public void setTenloaimonan(String tenloaimonan) {
        Tenloaimonan = tenloaimonan;
    }

    public String getHinhanhloaimonan() {
        return Hinhanhloaimonan;
    }

    public void setHinhanhloaimonan(String hinhanhloaimonan) {
        Hinhanhloaimonan = hinhanhloaimonan;
    }
}
