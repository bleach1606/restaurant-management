package modul;

import java.sql.Date;
import java.sql.Timestamp;





public class Bok_Order_Bill {

    public static enum Status
    {
        BAN_TRONG, BAN_DA_DAT, KHACH_NGOI;
    }

    private int id;
    private int numberClient;
    private Timestamp bookingTime;
    private String note;
    private Status status;
    private Timestamp datePayment;
    private User client;
    private User receptionist;
    private Table table;



    public Bok_Order_Bill(int numberClient, Timestamp bookingTime, String note, Status status, Timestamp datePayment, User client, User receptionist, Table table) {
        this.numberClient = numberClient;
        this.bookingTime = bookingTime;
        this.note = note;
        this.status = status;
        this.datePayment = datePayment;
        this.client = client;
        this.receptionist = receptionist;
        this.table = table;
    }

    public Table getTable() {
        return table;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Bok_Order_Bill() {
        this.status = Status.BAN_TRONG;
    }

    public int getNumberClient() {
        return numberClient;
    }

    public void setNumberClient(int numberClient) {
        this.numberClient = numberClient;
    }

    public Timestamp getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Timestamp bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Timestamp getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(Timestamp datePayment) {
        this.datePayment = datePayment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public User getReceptionist() {
        return receptionist;
    }

    public void setReceptionist(User receptionist) {
        this.receptionist = receptionist;
    }

    @Override
    public String toString() {
        return "Bok_Order_Bill{" +
                "numberClient=" + numberClient +
                ", bookingTime=" + bookingTime +
                ", note='" + note + '\'' +
                ", status='" + status + '\'' +
                ", datePayment=" + datePayment +
                ", client=" + client +
                ", receptionist=" + receptionist +
                '}';
    }
}
