package controller;

import DAO.*;
import DTO.ListUserFoodvsCombo;
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

public class ControllerOrder extends HttpServlet {
    private static long serialVersionUID = 102831973239L;

    private Book_Order_Bill_DAO bookOrderBillDao;
    private ComboDAO comboDAO;
    private FoodDAO foodDAO;
    private TableDAO tableDAO;
    private UserDAO userDAO;

    public ControllerOrder() {
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
            System.out.println(table);
            Bok_Order_Bill bokOrderBill = bookOrderBillDao.getBOB_NOT_PAY(table);
            System.out.println(bokOrderBill.getId());
            ListUserFoodvsCombo result = new ListUserFoodvsCombo();
            result.setComboOrders(comboDAO.listComboForBOB(bokOrderBill.getId()));
            result.setFoodOrders(foodDAO.listFoodForBOB(bokOrderBill.getId()));
            String json = new Gson().toJson(result);
            resp.setStatus(200);
            System.out.println(json);
            resp.setContentType("json");
            writer.println(json);
        } catch (Exception ex) {
            resp.setStatus(404);
            resp.setContentType("json");
            writer.println("data: token het han");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String token = req.getParameter("token");
            System.out.println(token);
            JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();
            jwtTokenProvider.getUserIdFromJWT(token);
            String listFood = req.getParameter("listFood");
            String tmp = "";
            String ok = "[]{}123456789,";
            for(int i = 0; i < listFood.length(); i++) {
                for(int j = 0; j < ok.length(); j++) {
                    if(listFood.charAt(i) == ok.charAt(j) ) {
                        tmp = tmp + listFood.charAt(i);
                    }
                }
            }
            listFood = tmp;
            System.out.println(listFood.toString());
            int table_id = Integer.parseInt(req.getParameter("table_id"));
            int numberCLient = Integer.parseInt(req.getParameter("number_client"));
            int receptionist_id = Integer.parseInt(req.getParameter("receptionist_id"));
            Convert convert = new Convert();
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
            System.out.println(bokOrderBill.toString());
            //list food
            if(listFood != null) {
                convert.setKey(listFood);
                ArrayList<ii> p = convert.getListII();
                for(ii x : p) {
                    foodDAO.addUsedFood(bokOrderBill.getId(), x);
                }
                System.out.println(p.toString());
            }

            //list combo
            String listCombo = req.getParameter("listCombo");
            tmp = "";
            ok = "[]{}123456789,";
            for(int i = 0; i < listCombo.length(); i++) {
                for(int j = 0; j < ok.length(); j++) {
                    if(listCombo.charAt(i) == ok.charAt(j) ) {
                        tmp = tmp + listCombo.charAt(i);
                    }
                }
            }
            listCombo = tmp;
            System.out.println(listCombo.toString());
            if(listCombo != null) {
                convert.setKey(listCombo);
                ArrayList<ii> p = convert.getListII();
                for(ii x : p) {
                    comboDAO.addUsedCombo(bokOrderBill.getId(), x);
                }
                System.out.printf(p.toString());
            }

            PrintWriter writer = resp.getWriter();
            String json = new Gson().toJson(bokOrderBill);
            resp.setStatus(200);
            resp.setContentType("json");
            writer.println(json);
        } catch (Exception ex) {
            PrintWriter writer = resp.getWriter();
            resp.setStatus(404);
            resp.setContentType("json");
            writer.println("data: token het han");
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
