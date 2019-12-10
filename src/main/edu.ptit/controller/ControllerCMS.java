package controller;

import DAO.ComboDAO;
import DAO.FoodDAO;
import com.google.gson.Gson;
import modul.Combo;
import modul.Food;
import modul.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cms")
public class ControllerCMS extends HttpServlet {
    private static long serialVersionUID = 102831973239L;

    private FoodDAO foodDAO;
    private ComboDAO comboDAO;

    public ControllerCMS() {
        foodDAO = new FoodDAO();
        comboDAO = new ComboDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        try {
            String json = "";
            String type = req.getParameter("type");
            if (type.equals("food")) {
                Food food = new Food();
                food.setAvatar(req.getParameter("avatar"));
                food.setDescription(req.getParameter("des"));
                food.setUnit(req.getParameter("unit"));
                food.setValue(Integer.parseInt(req.getParameter("value")));
                food.setName(req.getParameter("name"));
                food = foodDAO.addMonAn(food);
                json = new Gson().toJson(food);
            }
            else {
                Combo combo = new Combo();
                combo.setAvater(req.getParameter("avatar"));
                combo.setDescription(req.getParameter("des"));
                combo.setUnit(req.getParameter("unit"));
                combo.setValue(Integer.parseInt(req.getParameter("value")));
                combo.setName(req.getParameter("name"));
                combo = comboDAO.addCombo(combo);
                json = new Gson().toJson(combo);
            }
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
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
