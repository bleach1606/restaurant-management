package modul;

import java.sql.Date;


public class HoaDonNhap {
    private int id;
    private Date thoiGian;
    private User thanhVien;

    public HoaDonNhap(int id, Date thoiGian) {
        this.id = id;
        this.thoiGian = thoiGian;
    }

    public HoaDonNhap() {
    }

    public HoaDonNhap(int id, Date thoiGian, User thanhVien) {
        this.id = id;
        this.thoiGian = thoiGian;
        this.thanhVien = thanhVien;
    }

    public void setThanhVien(User thanhVien) {
        this.thanhVien = thanhVien;
    }

    public User getThanhVien() {
        return thanhVien;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    @Override
    public String toString() {
        return "HoaDonNhap{" + "id=" + id + ", thoiGian=" + thoiGian + ", thanhVien=" + thanhVien + '}';
    }
}
