package controller;

import DAO.Book_Order_Bill_DAO;
import DAO.TableDAO;
import DAO.UserDAO;
import modul.Bok_Order_Bill;
import modul.Table;
import modul.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

public class ComtrollerBookOrderBill extends HttpServlet {
    private static long serialVersionUID = 102831973239L;

    private Book_Order_Bill_DAO bookOrderBillDao;
    private TableDAO tableDAO;
    private UserDAO userDAO;

    public ComtrollerBookOrderBill() {
        bookOrderBillDao = new Book_Order_Bill_DAO();
        tableDAO = new TableDAO();
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Table table = new Table();
        int tableID = Integer.parseInt(req.getParameter("id"));
        table = tableDAO.getTableById(tableID);
        Bok_Order_Bill bokOrderBill = bookOrderBillDao.getViecDatBan_Order_HoaDon(table);
        System.out.println(bokOrderBill);
        PrintWriter writer = resp.getWriter();
        writer.println(bokOrderBill);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int clientId = Integer.parseInt(req.getParameter("client_id"));
            int receptionistId = Integer.parseInt(req.getParameter("receptionist_id"));
            int tableID = Integer.parseInt(req.getParameter("table_id"));
            User client = userDAO.getUser(clientId);
            User recepreceptionist = userDAO.getUser(receptionistId);
            Bok_Order_Bill bokOrderBill = new Bok_Order_Bill();
            bokOrderBill.setClient(client);
            bokOrderBill.setReceptionist(recepreceptionist);
            Table table = tableDAO.getTableById(tableID);
            bokOrderBill.setTable(table);
            int numberClient = Integer.parseInt(req.getParameter("number_client"));
            bokOrderBill.setNumberClient(numberClient);
            bokOrderBill.setNote(req.getParameter("note"));
            bokOrderBill.setBookingTime(Timestamp.valueOf(req.getParameter("time")));
            bokOrderBill = bookOrderBillDao.addBooking(bokOrderBill);
            resp.setStatus(200);
            resp.setContentType("text/xml");
            PrintWriter writer = resp.getWriter();
            writer.println(bokOrderBill);
        } catch (Exception ex) {
            resp.setStatus(404);
            resp.setContentType("text/xml");
            PrintWriter writer = resp.getWriter();
            writer.println(ex.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int booking_id = Integer.parseInt(req.getParameter("booking_id"));
        Bok_Order_Bill bokOrderBill = bookOrderBillDao.getBok_Order_Bill(booking_id);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bok_Order_Bill_id = Integer.parseInt(req.getParameter("bok_Order_Bill_id"));
        int k = bookOrderBillDao.deleteBookOrderBill(bok_Order_Bill_id);
        PrintWriter writer = resp.getWriter();
        writer.println(k);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
