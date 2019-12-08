package DAO;

import modul.NguyenLieu;
import modul.NguyenLieuNhap;
import modul.NguyenLieuTonKho;
import modul.NguyenLieuXuat;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class RawMaterialDAO extends DAO {

    public RawMaterialDAO() {
        super();
    }

    public NguyenLieu themNguyenLieu(NguyenLieu nguyenLieu){
        String sql = "INSERT INTO `tblnguyenlieu`(`ten_nguyen_lieu`, `don_vi`, `don_gia`, `mo_ta`) " +
                "VALUES (?, ?, ?, ?)";
        try{
            PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nguyenLieu.getTenNL());
            ps.setString(2, nguyenLieu.getDonVi());
            ps.setDouble(3, nguyenLieu.getDonGia());
            ps.setString(4, nguyenLieu.getMoTa());
            System.out.println(ps.toString());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int k = -1;
            if (rs.next()) {
                k = rs.getInt(1);
            }
            nguyenLieu.setId(k);
            return nguyenLieu;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public NguyenLieuTonKho getNguyenLieuTonKho(NguyenLieuTonKho nguyenLieuTonKho) {
        String sql = "SELECT * FROM tblnguyenlieutonkho WHERE nguyen_lieu_id = ?";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1,nguyenLieuTonKho.getNguyenLieu().getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                nguyenLieuTonKho.setTongSoLuongNhap(rs.getInt(2));
                nguyenLieuTonKho.setTongSoLuongXuat(rs.getInt(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nguyenLieuTonKho;
    }

    public ArrayList<NguyenLieuTonKho> timKiemNguyenLieu(String key){
        if(key == null) key = "";
        ArrayList<NguyenLieuTonKho> listNL = new ArrayList<NguyenLieuTonKho>();
        String sql = "SELECT * FROM tblnguyenlieu WHERE ten_nguyen_lieu LIKE ?";
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1,"%" + key + "%");
            ResultSet rs = ps.executeQuery();
            System.out.println(ps.toString());
            while (rs.next()) {
                NguyenLieu nguyenLieu = new NguyenLieu();
                nguyenLieu.setId(rs.getInt(1));
                nguyenLieu.setTenNL(rs.getString(2));
                nguyenLieu.setDonVi(rs.getString(3));
                nguyenLieu.setDonGia(rs.getInt(4));
                nguyenLieu.setMoTa(rs.getString(5));
                NguyenLieuTonKho nguyenLieuTonKho = new NguyenLieuTonKho();
                nguyenLieuTonKho.setNguyenLieu(nguyenLieu);
                nguyenLieuTonKho = getNguyenLieuTonKho(nguyenLieuTonKho);
                listNL.add(nguyenLieuTonKho);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listNL;
    }

    public ArrayList<NguyenLieu> timNguyenLieu(String key, int ncc_id){
        if(key == null) key = "";
        ArrayList<NguyenLieu> listNL = new ArrayList<NguyenLieu>();
        String sql = "SELECT\n" +
                "    *\n" +
                "FROM\n" +
                "    tblnguyenlieu\n" +
                "WHERE\n" +
                "    ten_nguyen_lieu LIKE ? AND tblnguyenlieu.id IN(\n" +
                "    SELECT\n" +
                "        tblcungcap.nguyen_lieu_id\n" +
                "    FROM\n" +
                "        tblcungcap\n" +
                "    WHERE\n" +
                "        tblcungcap.nha_cung_cap_id = ?" +
                ")";
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1,"%" + key + "%");
            ps.setInt(2, ncc_id);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps.toString());
            while (rs.next()) {
                NguyenLieu nguyenLieu = new NguyenLieu();
                nguyenLieu.setId(rs.getInt(1));
                nguyenLieu.setTenNL(rs.getString(2));
                nguyenLieu.setDonVi(rs.getString(3));
                nguyenLieu.setDonGia(rs.getInt(4));
                nguyenLieu.setMoTa(rs.getString(5));
                listNL.add(nguyenLieu);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listNL;
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

    public int chonNguyenLieuXuat(NguyenLieuXuat lieuXuat) {
        String sql = "INSERT INTO nguyenlieuxuat(so_luong, nguyen_lieu_id, hoa_don_xuat_id) VALUES (?, ?, ?)";
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, lieuXuat.getSoLuong());
            ps.setInt(2, lieuXuat.getNguyenLieu().getId());
            ps.setInt(3, lieuXuat.getViecXuatNguyenLieu().getId());
            return ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
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

    public int xuatNguyenLieu(NguyenLieuXuat nguyenLieu){
        String sql = "UPDATE tblnguyenlieutonkho SET tong_so_luong_xuat = ? WHERE nguyen_lieu_id = ?";
        NguyenLieuTonKho nguyenLieuTonKho = getNguyenLieuTonKho1(nguyenLieu.getNguyenLieu());
        int soLuong = nguyenLieu.getSoLuong() + nguyenLieuTonKho.getTongSoLuongXuat();
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

    //    INSERT INTO `tblcungcap`(`nha_cung_cap_id`, `nguyen_lieu_id`) VALUES (?, ?)
    public int CungCap(int ncc_id, int nl_id){
        String sql = "INSERT INTO `tblcungcap`(`nha_cung_cap_id`, `nguyen_lieu_id`) VALUES (?, ?)";
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, ncc_id);
            ps.setInt(2, nl_id);
            return ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
}
