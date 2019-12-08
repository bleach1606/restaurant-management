package DAO;

import DTO.ii;
import modul.Bok_Order_Bill;
import modul.Food;
import modul.FoodOrder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FoodDAO extends DAO{

    public FoodDAO() {
        super();
    }

    public Food getById(int id) {
        Food food = null;
        String sql = "SELECT * from tblban WHERE id = ?";
        try{
            food = new Food();
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps.toString());
            if (rs.next()) {
                food.setId(rs.getInt(1));
                food.setName(rs.getString(2));
                food.setValue(rs.getInt(3));
                food.setUnit(rs.getString(4));
//                food.setDescription(rs.getString(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return food;
    }

    public int addUsedFood(int bob, ii k) {
        String sql = "INSERT INTO tblViecChonMon(viecdatban_order_hoadon_id, mon_an_id, so_luong_mon_an, tinh_trang) " +
                "VALUES ( "+ String.valueOf(bob) +", "+ String.valueOf(k.getX()) +", "+ String.valueOf(k.getY()) +", 'CHO')";
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            return ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    public ArrayList<FoodOrder> listUserFoodForKey(String key) {
        String sql = "SELECT * FROM `tblViecChonMon` WHERE tinh_trang <> ?";
        ArrayList<FoodOrder> foods = null;
        try{
            foods = new ArrayList<>();
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps.toString());
            while (rs.next()) {
                FoodOrder usedFood = new FoodOrder();
                usedFood.setId(rs.getInt(1));
                usedFood.setFood(getById(rs.getInt(3)));
                usedFood.setSoLuong(rs.getInt(4));
                usedFood.setTrangThai(FoodOrder.StatusFood.valueOf(rs.getString(5)));
                foods.add(usedFood);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return foods;
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

    public FoodOrder getFoodOrder(int id) {
        String sql = "SELECT * FROM `tblViecChonMon` WHERE id = ?";
        FoodOrder foodOrder = null;
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps.toString());
            if (rs.next()) {
                foodOrder = new FoodOrder();
                foodOrder.setId(rs.getInt(1));
                foodOrder.setBok_order_bill(getBok_Order_Bill(rs.getInt(2)));
                foodOrder.setFood(getById(rs.getInt(3)));
                foodOrder.setSoLuong(rs.getInt(4));
                foodOrder.setTrangThai(FoodOrder.StatusFood.valueOf(rs.getString(5)));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return foodOrder;
    }

    public int getFoodOrder(FoodOrder foodOrder) {
        String sql = "UPDATE `tblViecChonMon` SET `so_luong_mon_an`= ? WHERE id = ?";
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, foodOrder.getSoLuong());
            ps.setInt(2, foodOrder.getId());
            return ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    public void addUsedFoodDone(FoodOrder foodOrder) {
        String sql = "INSERT INTO `tblViecChonComBo`(`viecdatban_order_hoadon_id`, `combo_id`, `so_luong_combo`, `trang_thai`)" +
                "VALUES ( "+ String.valueOf(foodOrder.getBok_order_bill()) +", "+ String.valueOf(foodOrder.getFood().getId()) +
                ", "+ String.valueOf(foodOrder.getSoLuong()) +", '" + foodOrder.getTrangThai() + "')";
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            System.out.println(sql);
            ps.execute();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Food> getAllFood() {
        ArrayList<Food> combos = null;
        String sql = "SELECT * from tblMonAn";
        try{
            combos = new ArrayList<>();
            PreparedStatement ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps.toString());
            while (rs.next()) {
                Food combo = new Food();
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

    public int updateFoodOrder(FoodOrder foodOrder) {
        String sql = "UPDATE `tblViecChonMon` SET `so_luong_mon_an`= ? WHERE id = ?";
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, foodOrder.getSoLuong());
            ps.setInt(2, foodOrder.getId());
            return ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }

}
