package DAO;

import modul.Bok_Order_Bill;
import modul.Table;
import sun.tools.jconsole.Tab;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TableDAO extends DAO{
    final private String database = "LTM";

    private Book_Order_Bill_DAO orderBillDao;

    public TableDAO() {
        super();
        orderBillDao = new Book_Order_Bill_DAO();
    }

    public ArrayList<Table> getListTable(String key) {
        if(key == null) key = "";
        ArrayList<Table> list = null;
        String sql = "SELECT * from tblban WHERE ten_ban LIKE ?";
        try{
            list = new ArrayList<>();
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1,"%" + key + "%");
            ResultSet rs = ps.executeQuery();
            System.out.println(ps.toString());
            while (rs.next()) {
                Table table = new Table();
                table.setId(rs.getInt(1));
                table.setNameTable(rs.getString(2));
                table.setQuantitySeat(rs.getInt(3));
                table.setDescription(rs.getString(4));
                Bok_Order_Bill orderBill = orderBillDao.getViecDatBan_Order_HoaDon(table);
                if(orderBill == null) {
                    table.setStatus("BAN_TRONG");
                }
                else table.setStatus("BAN_DANG_XU_DUNG");
                list.add(table);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public Table getTableById(int id) {
        Table table = null;
        String sql = "SELECT * from tblban WHERE id = ?";
        try{
            table = new Table();
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            System.out.println(ps.toString());
            if (rs.next()) {
                table.setId(rs.getInt(1));
                table.setNameTable(rs.getString(2));
                table.setQuantitySeat(rs.getInt(3));
                table.setDescription(rs.getString(4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return table;
    }

    public Table AddTableId(Table table) {
        String sql = "INSERT INTO `tblban`(`ten_ban`, `so_cho`, `mo_ta`) VALUES (?, ?, ?)";
        try{
            PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, table.getNameTable());
            ps.setInt(2,table.getQuantitySeat());
            ps.setString(3, table.getDescription());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int k = -1;
            if (rs.next()) {
                k = rs.getInt(1);
            }
            table.setId(k);
        }catch(Exception e){
            e.printStackTrace();
        }
        return table;
    }

    public Table updateTable(Table table) {
        String sql = "UPDATE `tblban` SET `ten_ban`= ?,`so_cho`= ?,`mo_ta`= ? WHERE id = ?";
        try{
            PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, table.getNameTable());
            ps.setInt(2,table.getQuantitySeat());
            ps.setString(3, table.getDescription());
            ps.setInt(4, table.getId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int k = -1;
            if (rs.next()) {
                k = rs.getInt(1);
            }
            table.setId(k);
        }catch(Exception e){
            e.printStackTrace();
        }
        return table;
    }

    public int deleteTable(int id) {
        String sql = "DELETE FROM `tblban` WHERE id = ?";
        int k = -1;
        try{
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1,id);
            k = ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
        return k;
    }

    public static void main(String[] args) {
        TableDAO t = new TableDAO();
        ArrayList<Table> list = t.getListTable("");
        for (Table x: list) {
            System.out.println(x.toString());
        }
    }
}
