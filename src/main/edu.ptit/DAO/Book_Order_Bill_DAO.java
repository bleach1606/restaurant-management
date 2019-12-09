package DAO;

import modul.Bok_Order_Bill;
import modul.Bok_Order_Bill.Status;
import modul.Ordering;
import modul.Table;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;


public class Book_Order_Bill_DAO extends DAO {

    private UserDAO userDAO;
    private TableDAO tableDAO;
    private FoodDAO foodDAO;
    private ComboDAO comboDAO;

    public Book_Order_Bill_DAO() {
        super();
        userDAO = new UserDAO();
        foodDAO = new FoodDAO();
        comboDAO = new ComboDAO();
    }

    public int xacNhanThanhToan(int viecdatban_order_hoadon_id) throws Exception {
        String sql = "UPDATE tblviecdatban_order_hoadon SET tinh_trang = 'DA_THANH_TOAN', ngay_thanh_toan = ? WHERE id = ?";
        int k = -1;
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setTimestamp(1, timestamp);
            ps.setInt(2, viecdatban_order_hoadon_id);
            System.out.println(ps.toString());
            k = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return k;
    }

    public Bok_Order_Bill getViecDatBan_Order_HoaDon(Table table){
        String sql = "SELECT * FROM tblviecdatban_order_hoadon as tb WHERE tb.tinh_trang = 'BAN_DA_DAT' AND tb.ban_id = "
                + String.valueOf(table.getId());
        Bok_Order_Bill ban_Order_HoaDon = null;
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ban_Order_HoaDon = new Bok_Order_Bill();
                ban_Order_HoaDon.setId(rs.getInt(1));
                ban_Order_HoaDon.setClient(userDAO.getUser(rs.getInt(2)));
                ban_Order_HoaDon.setReceptionist(userDAO.getUser(rs.getInt(3)));
                ban_Order_HoaDon.setTable(table);
                ban_Order_HoaDon.setBookingTime(rs.getTimestamp(5));
                ban_Order_HoaDon.setNote(rs.getString(6));
                ban_Order_HoaDon.setNumberClient(rs.getInt(7));
                ban_Order_HoaDon.setDatePayment(rs.getTimestamp(8));
                ban_Order_HoaDon.setStatus(Status.valueOf(rs.getString(9)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ban_Order_HoaDon;
    }

    public Bok_Order_Bill getBOB_NOT_PAY(Table table){
        String sql = "SELECT * FROM tblviecdatban_order_hoadon as tb WHERE tb.tinh_trang <> 'DA_THANH_TOAN' AND tb.ban_id = "
                + String.valueOf(table.getId());
        Bok_Order_Bill ban_Order_HoaDon = null;
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
//            ps.setInt(1, ban.getId());
            ResultSet rs = ps.executeQuery();
            System.out.println(sql);
            if(rs.next()) {
                ban_Order_HoaDon = new Bok_Order_Bill();
                ban_Order_HoaDon.setId(rs.getInt(1));
                ban_Order_HoaDon.setClient(userDAO.getUser(rs.getInt(2)));
                ban_Order_HoaDon.setReceptionist(userDAO.getUser(rs.getInt(3)));
                ban_Order_HoaDon.setTable(table);
                ban_Order_HoaDon.setBookingTime(rs.getTimestamp(5));
                ban_Order_HoaDon.setNote(rs.getString(6));
                ban_Order_HoaDon.setNumberClient(rs.getInt(7));
                ban_Order_HoaDon.setDatePayment(rs.getTimestamp(8));
                ban_Order_HoaDon.setStatus(Status.valueOf(rs.getString(9)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ban_Order_HoaDon;
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
                ban_Order_HoaDon.setClient(userDAO.getUser(rs.getInt(2)));
                ban_Order_HoaDon.setReceptionist(userDAO.getUser(rs.getInt(3)));
                ban_Order_HoaDon.setTable(tableDAO.getTableById(rs.getInt(4)));
                ban_Order_HoaDon.setBookingTime(rs.getTimestamp(5));
                ban_Order_HoaDon.setNote(rs.getString(6));
                ban_Order_HoaDon.setNumberClient(rs.getInt(7));
                ban_Order_HoaDon.setDatePayment(rs.getTimestamp(8));
                ban_Order_HoaDon.setStatus(Status.valueOf(rs.getString(9)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ban_Order_HoaDon;
    }

    public ArrayList<Ordering> timViecChonMon(int viecdatban_order_hoadon_id) throws Exception {
        String sql = "SELECT * FROM tblviecchonmon WHERE viecdatban_order_hoadon_id = ?";
        ArrayList<Ordering> list = new ArrayList<>();
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, viecdatban_order_hoadon_id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Ordering chonMon = new Ordering();
                chonMon.setId(rs.getInt(1));
                chonMon.setBook_order_bill(getBok_Order_Bill(rs.getInt(2)));
                int k = rs.getInt(3);
                chonMon.setFood(null);
                if(k != -1) {
                    chonMon.setFood(foodDAO.getById(k));
                }
                chonMon.setQuantityFood(rs.getInt(4));
                k = rs.getInt(5);
                chonMon.setCombo(null);
                if(k != -1) {
                    chonMon.setCombo(comboDAO.getById(k));
                }
                chonMon.setQuantityCombo(rs.getInt(6));
                list.add(chonMon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Bok_Order_Bill addBooking(Bok_Order_Bill booking) {
        System.out.println(booking.toString());
        String sql = "INSERT INTO `tblViecDatBan_Order_HoaDon`" +
                "(`khach_hang_id`, `thanh_vien_id`, `ban_id`, `thoi_gian_dat`, `ghi_chu`, `so_khach`, `tinh_trang`)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,booking.getClient().getId());
            ps.setInt(2,booking.getReceptionist().getId());
            ps.setInt(3,booking.getTable().getId());
            ps.setTimestamp(4,booking.getBookingTime());
            ps.setString(5,booking.getNote());
            ps.setInt(6,booking.getNumberClient());
            ps.setString(7,booking.getStatus().name());
            ps.executeUpdate();
            System.out.println(ps.toString());
            ResultSet rs = ps.getGeneratedKeys();
            int k = -1;
            if (rs.next()) {
                k = rs.getInt(1);
            }
            booking.setId(k);
        }catch(Exception e){
            e.printStackTrace();
        }
        return booking;

    }

    public int deleteBookOrderBill(int id) {
        String sql = "DELETE FROM `tblViecDatBan_Order_HoaDon` WHERE id = ?";
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


}
