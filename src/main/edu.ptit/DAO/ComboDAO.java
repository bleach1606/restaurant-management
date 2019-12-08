package DAO;

import DTO.ii;
import modul.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ComboDAO extends DAO {

    public ComboDAO() {
        super();
    }

    public Combo getById(int id) {
        Combo combo = null;
        String sql = "SELECT * from tblCombo WHERE id = ?";
        try{
            combo = new Combo();
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps.toString());
            if (rs.next()) {
                combo.setId(rs.getInt(1));
                combo.setName(rs.getString(2));
                combo.setValue(rs.getInt(3));
                combo.setUnit(rs.getString(4));
//                combo.setDescription(rs.getString(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return combo;
    }

    public void addUsedCombo(int bob, ii k) {
        String sql = "INSERT INTO `tblViecChonComBo`(`viecdatban_order_hoadon_id`, `combo_id`, `so_luong_combo`, `trang_thai`)" +
                "VALUES ( "+ String.valueOf(bob) +", "+ String.valueOf(k.getX()) +", "+ String.valueOf(k.getY()) +", 'CHO')";
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            System.out.println(sql);
            ps.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void addUsedComboDone(ComboOrder comboOrder) {
        String sql = "INSERT INTO `tblViecChonComBo`(`viecdatban_order_hoadon_id`, `combo_id`, `so_luong_combo`, `trang_thai`)" +
                "VALUES ( "+ String.valueOf(comboOrder.getBok_order_bill().getId()) +", "+ String.valueOf(comboOrder.getCombo().getId()) +", "+ String.valueOf(comboOrder.getSoLuong()) +
                ", '" + comboOrder.getTrangThai() + "')";
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            System.out.println(sql);
            ps.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Combo> getAllCombo() {
        ArrayList<Combo> combos = null;
        String sql = "SELECT * from tblCombo";
        try{
            combos = new ArrayList<>();
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps.toString());
            while (rs.next()) {
                Combo combo = new Combo();
                combo.setId(rs.getInt(1));
                combo.setName(rs.getString(2));
                combo.setValue(rs.getInt(3));
                combo.setUnit(rs.getString(4));
                combo.setDescription(rs.getString(5));
                combos.add(combo);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return combos;
    }

    public Bok_Order_Bill getBok_Order_Bill(int id){
        String sql = "SELECT * FROM tblviecdatban_order_hoadon as tb WHERE id = ? ";
        Bok_Order_Bill ban_Order_HoaDon = null;
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            System.out.println(sql);
            if(rs.next()) {
                ban_Order_HoaDon = new Bok_Order_Bill();
                ban_Order_HoaDon.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ban_Order_HoaDon;
    }

    public ArrayList<ComboOrder> listUserComboForKey(String key) {
        String sql = "SELECT * FROM `tblViecChonMon` WHERE tinh_trang <> ?";
        ArrayList<ComboOrder> comboOrders = null;
        try{
            comboOrders = new ArrayList<>();
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps.toString());
            while (rs.next()) {
                ComboOrder comboOrder = new ComboOrder();
                comboOrder.setId(rs.getInt(1));
                comboOrder.setBok_order_bill(getBok_Order_Bill(rs.getInt(2)));
                comboOrder.setCombo(getById(rs.getInt(3)));
                comboOrder.setSoLuong(rs.getInt(4));
                comboOrder.setTrangThai(ComboOrder.StatusCombo.valueOf(rs.getString(5)));
                comboOrders.add(comboOrder);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return comboOrders;
    }

    public ComboOrder getComboOrder(int id) {
        String sql = "SELECT * FROM `tblViecChonComBo` WHERE id = ?";
        ComboOrder comboOrder = null;
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps.toString());
            if (rs.next()) {
                comboOrder = new ComboOrder();
                comboOrder.setId(rs.getInt(1));
                comboOrder.setCombo(getById(rs.getInt(3)));
                comboOrder.setBok_order_bill(getBok_Order_Bill(rs.getInt(2)));
                comboOrder.setSoLuong(rs.getInt(4));
                comboOrder.setTrangThai(ComboOrder.StatusCombo.valueOf(rs.getString(5)));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return comboOrder;
    }

    public int updateComboOrder(ComboOrder comboOrder) {
        String sql = "UPDATE `tblViecChonComBo` SET `so_luong_combo`= ? WHERE id = ?";
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, comboOrder.getSoLuong());
            ps.setInt(2, comboOrder.getId());
            return ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
}
