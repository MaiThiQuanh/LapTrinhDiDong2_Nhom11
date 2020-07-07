package com.example.thucdonnhahang.Model;

import java.io.Serializable;

public class MonAn implements Serializable {

    public int ID;
    public String Tenmonan;
    public Integer Giamonan;
    public String Hinhanhmonan;
    public String Motamonan;
    public int IDMonan;

    public MonAn(int ID, String tenmonan, Integer giamonan, String hinhanhmonan, String motamonan, int IDMonan) {
        this.ID = ID;
        Tenmonan = tenmonan;
        Giamonan = giamonan;
        Hinhanhmonan = hinhanhmonan;
        Motamonan = motamonan;
        this.IDMonan = IDMonan;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenmonan() {
        return Tenmonan;
    }

    public void setTenmonan(String tenmonan) {
        Tenmonan = tenmonan;
    }

    public Integer getGiamonan() {
        return Giamonan;
    }

    public void setGiamonan(Integer giamonan) {
        Giamonan = giamonan;
    }

    public String getHinhanhmonan() {
        return Hinhanhmonan;
    }

    public void setHinhanhmonan(String hinhanhmonan) {
        Hinhanhmonan = hinhanhmonan;
    }

    public String getMotamonan() {
        return Motamonan;
    }

    public void setMotamonan(String motamonan) {
        Motamonan = motamonan;
    }

    public int getIDMonan() {
        return IDMonan;
    }

    public void setIDMonan(int IDMonan) {
        this.IDMonan = IDMonan;
    }
}
