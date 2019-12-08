package modul;

import java.sql.Timestamp;

public class ComboOrder {
    public static enum StatusCombo {
        CHO, LAM_XONG, DA_GIAO
    }
    private int id;
    private Combo combo;
    private Bok_Order_Bill bok_order_bill;
    private Timestamp timestamp;
    private int soLuong;
    private StatusCombo trangThai;

    public ComboOrder() {
        this.trangThai = StatusCombo.CHO;
    }

    public ComboOrder(Combo nguyenLieu, Bok_Order_Bill table, Timestamp timestamp, int soLuong) {
        this.combo = nguyenLieu;
        this.bok_order_bill = table;
        this.timestamp = timestamp;
        this.soLuong = soLuong;
        this.trangThai = StatusCombo.CHO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Combo getCombo() {
        return combo;
    }

    public void setCombo(Combo combo) {
        this.combo = combo;
    }

    public Bok_Order_Bill getBok_order_bill() {
        return bok_order_bill;
    }

    public void setBok_order_bill(Bok_Order_Bill bok_order_bill) {
        this.bok_order_bill = bok_order_bill;
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

    public StatusCombo getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(StatusCombo trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "ComboOrder{" +
                "id=" + id +
                ", combo=" + combo +
                ", bok_order_bill=" + bok_order_bill +
                ", timestamp=" + timestamp +
                ", soLuong=" + soLuong +
                ", trangThai=" + trangThai +
                '}';
    }
}
