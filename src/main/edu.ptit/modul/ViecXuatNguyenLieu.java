package modul;

import java.sql.Date;

public class ViecXuatNguyenLieu {
    private int id;
    private Date thoiGian;
    private User thanhVien1;
    private User thanhVien2;

    public ViecXuatNguyenLieu() {
    }

    public ViecXuatNguyenLieu(int id, Date thoiGian, User thanhVien1, User thanhVien2) {
        this.id = id;
        this.thoiGian = thoiGian;
        this.thanhVien1 = thanhVien1;
        this.thanhVien2 = thanhVien2;
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

    public User getThanhVien1() {
        return thanhVien1;
    }

    public void setThanhVien1(User thanhVien1) {
        this.thanhVien1 = thanhVien1;
    }

    public User getThanhVien2() {
        return thanhVien2;
    }

    public void setThanhVien2(User thanhVien2) {
        this.thanhVien2 = thanhVien2;
    }
}
