package controller;

import DAO.StockDAO;
import DAO.UserDAO;
import bleach.JwtTokenProvider;
import modul.HoaDonNhap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

public class ControlerStock extends HttpServlet {
    private static long serialVersionUID = 102831973239L;

    private StockDAO stockDAO;
    private UserDAO userDAO;

    public ControlerStock() {
        stockDAO = new StockDAO();
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        try {
            String token = req.getParameter("token");
            System.out.println(token);
            JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();
            int id = jwtTokenProvider.getUserIdFromJWT(token);
            stockDAO = new StockDAO();

            HoaDonNhap hoaDonNhap = new HoaDonNhap();
            hoaDonNhap.setThanhVien(userDAO.getUser(id));
            hoaDonNhap.setThoiGian(new Timestamp(new Date().getTime()));
        } catch (Exception ex) {
            resp.setStatus(404);
            resp.setContentType("text/xml");
            writer.println("Lỗi khởi tạo");
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