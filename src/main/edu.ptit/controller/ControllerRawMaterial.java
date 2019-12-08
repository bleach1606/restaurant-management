package controller;

import DAO.RawMaterialDAO;
import com.google.gson.Gson;
import modul.NguyenLieu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ControllerRawMaterial extends HttpServlet {
    private static long serialVersionUID = 102831973239L;

    private RawMaterialDAO rawMaterialDAO;

    public ControllerRawMaterial() {
        rawMaterialDAO = new RawMaterialDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        try {
            int ncc_id = Integer.parseInt(req.getParameter("ncc_id"));
            ArrayList<NguyenLieu> nguyenLieus = rawMaterialDAO.timNguyenLieu("", ncc_id);
            String json = new Gson().toJson(nguyenLieus);
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
            NguyenLieu nguyenLieu = new NguyenLieu();
            String name = req.getParameter("name"); nguyenLieu.setTenNL(name);
            String unit = req.getParameter("don_vi"); nguyenLieu.setDonVi(unit);
            String value = req.getParameter("value"); nguyenLieu.setDonGia(Integer.parseInt(value));
            String des = req.getParameter("mo_ta"); nguyenLieu.setMoTa(des);
            nguyenLieu = rawMaterialDAO.themNguyenLieu(nguyenLieu);
            resp.setStatus(200);
            resp.setContentType("text/xml");
            writer.println(nguyenLieu);
        } catch (Exception ex) {
            resp.setStatus(404);
            resp.setContentType("text/xml");
            writer.println(ex.getMessage());
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
