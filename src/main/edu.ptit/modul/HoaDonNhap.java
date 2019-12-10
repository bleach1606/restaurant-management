package modul;

import java.sql.Date;
import java.sql.Timestamp;


public class HoaDonNhap {
    private int id;
    private Timestamp thoiGian;
    private User thanhVien;

    public HoaDonNhap(int id, Timestamp thoiGian) {
        this.id = id;
        this.thoiGian = thoiGian;
    }

    public HoaDonNhap() {
    }

    public HoaDonNhap(int id, Timestamp thoiGian, User thanhVien) {
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

    public Timestamp getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Timestamp thoiGian) {
        this.thoiGian = thoiGian;
    }

    @Override
    public String toString() {
        return "HoaDonNhap{" + "id=" + id + ", thoiGian=" + thoiGian + ", thanhVien=" + thanhVien + '}';
    }
}
