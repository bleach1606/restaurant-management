package DAO;

import modul.HoaDonNhap;
import modul.NguyenLieu;
import modul.NguyenLieuNhap;
import modul.NguyenLieuTonKho;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StockDAO extends DAO {

    public StockDAO() {
        super();
    }

    public HoaDonNhap themHoaDOn(HoaDonNhap hoaDonNhap){
        String sql = "INSERT INTO tblhoadonnhap(thoi_gian, thanh_vien_id) VALUES (?, ?)";
        int k = -1;
        HoaDonNhap rs1 = hoaDonNhap;
        try{
            PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setTimestamp(1, hoaDonNhap.getThoiGian());
            ps.setInt(2, hoaDonNhap.getThanhVien().getId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                k = rs.getInt(1);
            }
        }catch(Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
        }
        hoaDonNhap.setId(k);
        return rs1;
    }

    public int chonNguyenLieuNhap(NguyenLieuNhap nguyenLieuNhap) {
        String sql = "INSERT INTO tblchonnguyenlieunhap(so_luong, nguyen_lieu_id, hoa_don_nhap_id) VALUES (?, ?, ?)";
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, nguyenLieuNhap.getSoLuong());
            ps.setInt(2, nguyenLieuNhap.getNguyenLieu().getId());
            ps.setInt(3, nguyenLieuNhap.getHoaDonNhap().getId());
            return ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    public NguyenLieuTonKho getNguyenLieuTonKho1(NguyenLieu nguyenLieu){
        String sql = "SELECT * FROM tblnguyenlieutonkho WHERE nguyen_lieu_id = ?";
        NguyenLieuTonKho nguyenLieuTonKho = null;
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, nguyenLieu.getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                nguyenLieuTonKho = new NguyenLieuTonKho();
                nguyenLieuTonKho.setNguyenLieu(nguyenLieu);
                nguyenLieuTonKho.setTongSoLuongNhap(rs.getInt(2));
                nguyenLieuTonKho.setTongSoLuongXuat(rs.getInt(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return nguyenLieuTonKho;
    }

    public int NhapNguyenLieu(NguyenLieuNhap nguyenLieu){
        String sql = "UPDATE tblnguyenlieutonkho SET tong_so_luong_nhap = ? WHERE nguyen_lieu_id = ?";
        NguyenLieuTonKho nguyenLieuTonKho = getNguyenLieuTonKho1(nguyenLieu.getNguyenLieu());
        int soLuong = nguyenLieu.getSoLuong() + nguyenLieuTonKho.getTongSoLuongNhap();
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, soLuong);
            ps.setInt(2, nguyenLieu.getNguyenLieu().getId());
            return ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
}
