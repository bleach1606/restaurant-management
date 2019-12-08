package modul;

public class NguyenLieuXuat {
    private int SoLuong;
    private NguyenLieu nguyenLieu;
    private ViecXuatNguyenLieu viecXuatNguyenLieu;

    public NguyenLieuXuat() {
    }

    public NguyenLieuXuat(int soLuong, NguyenLieu nguyenLieu, ViecXuatNguyenLieu viecXuatNguyenLieu) {
        SoLuong = soLuong;
        this.nguyenLieu = nguyenLieu;
        this.viecXuatNguyenLieu = viecXuatNguyenLieu;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public NguyenLieu getNguyenLieu() {
        return nguyenLieu;
    }

    public void setNguyenLieu(NguyenLieu nguyenLieu) {
        this.nguyenLieu = nguyenLieu;
    }

    public ViecXuatNguyenLieu getViecXuatNguyenLieu() {
        return viecXuatNguyenLieu;
    }

    public void setViecXuatNguyenLieu(ViecXuatNguyenLieu viecXuatNguyenLieu) {
        this.viecXuatNguyenLieu = viecXuatNguyenLieu;
    }

    @Override
    public String toString() {
        return "NguyenLieuXuat{" + "SoLuong=" + SoLuong + ", nguyenLieu=" + nguyenLieu + ", viecXuatNguyenLieu=" + viecXuatNguyenLieu + '}';
    }

    
}
