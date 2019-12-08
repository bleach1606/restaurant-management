package modul;

public class NguyenLieuNhap {
    private int SoLuong;
    private String GhiChu;
    private NhaCungCap nhaCungCap;
    private NguyenLieu nguyenLieu;
    private User thanhVien;
    private HoaDonNhap hoaDonNhap;

    public NguyenLieuNhap(int soLuong, String ghiChu, NhaCungCap nhaCungCap, NguyenLieu nguyenLieu, User thanhVien, HoaDonNhap hoaDonNhap) {
        SoLuong = soLuong;
        GhiChu = ghiChu;
        this.nhaCungCap = nhaCungCap;
        this.nguyenLieu = nguyenLieu;
        this.thanhVien = thanhVien;
        this.hoaDonNhap = hoaDonNhap;
    }

    public NguyenLieuNhap() {
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String ghiChu) {
        GhiChu = ghiChu;
    }

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public NguyenLieu getNguyenLieu() {
        return nguyenLieu;
    }

    public void setNguyenLieu(NguyenLieu nguyenLieu) {
        this.nguyenLieu = nguyenLieu;
    }

    public User getThanhVien() {
        return thanhVien;
    }

    public void setThanhVien(User thanhVien) {
        this.thanhVien = thanhVien;
    }

    public HoaDonNhap getHoaDonNhap() {
        return hoaDonNhap;
    }

    public void setHoaDonNhap(HoaDonNhap hoaDonNhap) {
        this.hoaDonNhap = hoaDonNhap;
    }

    @Override
    public String toString() {
        return "NguyenLieuNhap{" +
                "SoLuong=" + SoLuong +
                ", GhiChu='" + GhiChu + '\'' +
                ", nhaCungCap=" + nhaCungCap +
                ", nguyenLieu=" + nguyenLieu +
                ", thanhVien=" + thanhVien +
                ", hoaDonNhap=" + hoaDonNhap +
                '}';
    }
}
