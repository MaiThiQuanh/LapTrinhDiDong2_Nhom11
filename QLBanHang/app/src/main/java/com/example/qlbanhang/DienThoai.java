package com.example.qlbanhang;

public class DienThoai {

    private int Id;
    private String TenSanPham;
    private String GiaSanPham;
    private String MoTaSanPham;
    private byte[] HinhAnhSanPham;

    public DienThoai(int id, String tenSanPham, String giaSanPham, String moTaSanPham, byte[] hinhAnhSanPham) {
        Id = id;
        TenSanPham = tenSanPham;
        GiaSanPham = giaSanPham;
        MoTaSanPham = moTaSanPham;
        HinhAnhSanPham = hinhAnhSanPham;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        TenSanPham = tenSanPham;
    }

    public String getGiaSanPham() {
        return GiaSanPham;
    }

    public void setGiaSanPham(String giaSanPham) {
        GiaSanPham = giaSanPham;
    }

    public String getMoTaSanPham() {
        return MoTaSanPham;
    }

    public void setMoTaSanPham(String moTaSanPham) {
        MoTaSanPham = moTaSanPham;
    }

    public byte[] getHinhAnhSanPham() {
        return HinhAnhSanPham;
    }

    public void setHinhAnhSanPham(byte[] hinhAnhSanPham) {
        HinhAnhSanPham = hinhAnhSanPham;
    }
}

