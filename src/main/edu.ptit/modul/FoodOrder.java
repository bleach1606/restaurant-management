package modul;

import java.sql.Timestamp;

public class FoodOrder {

    public static enum StatusFood {
        CHO, LAM_XONG, DA_GIAO
    }

    private int id;
    private Food food;
    private Bok_Order_Bill bok_order_bill;
    private Timestamp timestamp;
    private int soLuong;
    private StatusFood trangThai;

    public FoodOrder() {
        this.trangThai = StatusFood.CHO;
    }

    public FoodOrder(Food nguyenLieu, Bok_Order_Bill table, Timestamp timestamp, int soLuong) {
        this.food = nguyenLieu;
        this.bok_order_bill = table;
        this.timestamp = timestamp;
        this.soLuong = soLuong;
        this.trangThai = StatusFood.CHO;
    }

    public StatusFood getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(StatusFood trangThai) {
        this.trangThai = trangThai;
    }

    public Bok_Order_Bill getBok_order_bill() {
        return bok_order_bill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBok_order_bill(Bok_Order_Bill bok_order_bill) {
        this.bok_order_bill = bok_order_bill;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "FoodOrder{" +
                "id=" + id +
                ", food=" + food +
                ", bok_order_bill=" + bok_order_bill +
                ", timestamp=" + timestamp +
                ", soLuong=" + soLuong +
                ", trangThai=" + trangThai +
                '}';
    }
}
