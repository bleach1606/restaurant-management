package controller;

import DAO.*;
import DTO.ii;
import bleach.Convert;
import bleach.JwtTokenProvider;
import com.google.gson.Gson;
import modul.Bok_Order_Bill;
import modul.Table;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class ControllerBill extends HttpServlet {
    private static long serialVersionUID = 102831973239L;

    private Book_Order_Bill_DAO bookOrderBillDao;
    private ComboDAO comboDAO;
    private FoodDAO foodDAO;
    private TableDAO tableDAO;
    private UserDAO userDAO;

    public ControllerBill() {
        bookOrderBillDao = new Book_Order_Bill_DAO();
        comboDAO = new ComboDAO();
        foodDAO = new FoodDAO();
        tableDAO = new TableDAO();
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        try {
            int table_id = Integer.parseInt(req.getParameter("table_id"));
            Table table = tableDAO.getTableById(table_id);
            Bok_Order_Bill bokOrderBill = bookOrderBillDao.getBOB_NOT_PAY(table);
            resp.setContentType("text/xml");
            String json = new Gson().toJson(bokOrderBill);
            resp.setStatus(200);
            resp.setContentType("json");
            writer.println(json);
        } catch (Exception ex) {
            resp.setStatus(404);
            resp.setContentType("text/xml");
            writer.println(ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        try {
            int table_id = Integer.parseInt(req.getParameter("table_id"));
            int numberCLient = Integer.parseInt(req.getParameter("number_client"));
            int receptionist_id = Integer.parseInt(req.getParameter("receptionist_id"));
            Table table = tableDAO.getTableById(table_id);
            Bok_Order_Bill bokOrderBill = new Bok_Order_Bill();
            bokOrderBill.setBookingTime(new Timestamp(new Date().getTime()));
            bokOrderBill.setTable(table);
            bokOrderBill.setNumberClient(numberCLient);
            bokOrderBill.setClient(userDAO.getUser(receptionist_id));
            bokOrderBill.setReceptionist(userDAO.getUser(receptionist_id));
            bokOrderBill.setNote(null);
            bokOrderBill.setStatus(Bok_Order_Bill.Status.KHACH_NGOI);
            bokOrderBill = bookOrderBillDao.addBooking(bokOrderBill);
            String json = new Gson().toJson(bokOrderBill);
            resp.setStatus(200);
            resp.setContentType("json");
            writer.println(json);
        } catch (Exception ex) {
            resp.setStatus(404);
            resp.setContentType("text/xml");
            writer.println(ex.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        try {
            String token = req.getParameter("token");
            System.out.println(token);
            JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();
            int id = jwtTokenProvider.getUserIdFromJWT(token);
            int bob_id = Integer.parseInt(req.getParameter("bob_id"));
            int k = bookOrderBillDao.xacNhanThanhToan(bob_id);
            resp.setStatus(200);
            resp.setContentType("text/xml");
            writer.println(k);
        } catch (Exception ex) {
            resp.setStatus(404);
            resp.setContentType("text/xml");
            writer.println(ex.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
