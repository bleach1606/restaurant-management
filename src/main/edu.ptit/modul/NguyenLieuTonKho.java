package modul;

public class NguyenLieuTonKho{
    private int tongSoLuongNhap;
    private int tongSoLuongXuat;
    private NguyenLieu nguyenLieu;

    public NguyenLieuTonKho(int tongSoLuongNhap, int tongSoLuongXuat,NguyenLieu nguyenLieu) {
        this.tongSoLuongNhap = tongSoLuongNhap;
        this.tongSoLuongXuat = tongSoLuongXuat;
        this.nguyenLieu = nguyenLieu;
    }

    public NguyenLieuTonKho() {
    }

    public int getTongSoLuongNhap() {
        return tongSoLuongNhap;
    }

    public void setTongSoLuongNhap(int tongSoLuongNhap) {
        this.tongSoLuongNhap = tongSoLuongNhap;
    }

    public int getTongSoLuongXuat() {
        return tongSoLuongXuat;
    }

    public void setTongSoLuongXuat(int tongSoLuongXuat) {
        this.tongSoLuongXuat = tongSoLuongXuat;
    }

    public NguyenLieu getNguyenLieu() {
        return nguyenLieu;
    }

    public void setNguyenLieu(NguyenLieu nguyenLieu) {
        this.nguyenLieu = nguyenLieu;
    }

    @Override
    public String toString() {
        return "NguyenLieuTonKho{" +
                "tongSoLuongNhap=" + tongSoLuongNhap +
                ", tongSoLuongXuat=" + tongSoLuongXuat +
                ", nguyenLieu=" + nguyenLieu +
                '}';
    }
}
