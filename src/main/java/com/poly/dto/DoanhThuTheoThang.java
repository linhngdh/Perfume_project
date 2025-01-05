package com.poly.dto;

public class DoanhThuTheoThang {
	private int nam;
    private int thang;
    private int ngay;
    private double doanhThu;

    // Constructors
    public DoanhThuTheoThang() {
    }

    public DoanhThuTheoThang( int nam, int thang, int ngay, double doanhThu) {

    	this.nam = nam;
        this.thang = thang;
        this.ngay = ngay;
        this.doanhThu = doanhThu;
    }

    // Getters and Setters
    
    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }
    
    public int getNgay() {
        return ngay;
    }

    public void setNgay(int ngay) {
        this.ngay = ngay;
    }

    public double getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(double doanhThu) {
        this.doanhThu = doanhThu;
    }
}
