package com.example.nhanvien2;

import java.io.Serializable;

public class Item implements Serializable {
    private int id;
    private String ten,noidung,ngayht,tt,ct;

    public Item() {
    }

    public Item(int id, String ten, String noidung, String ngayht, String tt, String ct) {
        this.id = id;
        this.ten = ten;
        this.noidung = noidung;
        this.ngayht = ngayht;
        this.tt = tt;
        this.ct = ct;
    }
    public Item( String ten, String noidung, String ngayht, String tt, String ct) {

        this.ten = ten;
        this.noidung = noidung;
        this.ngayht = ngayht;
        this.tt = tt;
        this.ct = ct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getNgayht() {
        return ngayht;
    }

    public void setNgayht(String ngayht) {
        this.ngayht = ngayht;
    }

    public String getTt() {
        return tt;
    }

    public void setTt(String tt) {
        this.tt = tt;
    }

    public String getCt() {
        return ct;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }
}
