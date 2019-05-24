package com.example.myapplication;

public class NhanVien {
    public boolean gt;
    public String tenNV;
    public String maNV;
    public int img;
    public NhanVien() {
    }

    public NhanVien(boolean gt, String tenNV, String maNV) {
        this.gt = gt;
        this.tenNV = tenNV;
        this.maNV = maNV;
        this.img = img;
    }

    public boolean isGt() {
        return gt;
    }

    public boolean setGt(boolean gt) {
        this.gt = gt;
        return gt;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
