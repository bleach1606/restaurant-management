package controller;

import DAO.ComboDAO;
import DAO.FoodDAO;
import DTO.KitchenDTO;
import com.google.gson.Gson;
import modul.ComboOrder;
import modul.FoodOrder;
import modul.UsedFood;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ControllerKitchen extends HttpServlet {
    private static long serialVersionUID = 102831973239L;

    private ComboDAO comboDAO;
    private FoodDAO foodDAO;

    public ControllerKitchen() {
        comboDAO = new ComboDAO();
        foodDAO = new FoodDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        try {
            KitchenDTO kitchenDTO = new KitchenDTO();
            System.out.println(FoodOrder.StatusFood.DA_GIAO.toString());
            ArrayList<FoodOrder> usedFoods = foodDAO.listUserFoodForKey(FoodOrder.StatusFood.DA_GIAO.toString());
            kitchenDTO.setFoodOrders(usedFoods);
            kitchenDTO.setComboOrders(comboDAO.listUserComboForKey(ComboOrder.StatusCombo.DA_GIAO.toString()));
            String json = new Gson().toJson(kitchenDTO);
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
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doHead(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        try {
            String type = req.getParameter("type");
            String status = req.getParameter("status");
            System.out.println(type);
            System.out.println(status);
            if(type.equals("combo")) {
                int used_combo_id = Integer.parseInt(req.getParameter("used_combo_id"));
                int number_combo = Integer.parseInt(req.getParameter("number_combo"));
                ComboOrder comboOrder = comboDAO.getComboOrder(used_combo_id);
                System.out.println(comboOrder);
                if(comboOrder.getSoLuong() > number_combo) {
                    comboOrder.setSoLuong(comboOrder.getSoLuong() - number_combo);
                    comboDAO.updateComboOrder(comboOrder);
                    comboOrder.setSoLuong(number_combo);
                    comboOrder.setTrangThai(ComboOrder.StatusCombo.valueOf(status));
                    comboDAO.addUsedComboDone(comboOrder);
                }
            } else {
                int used_food_id = Integer.parseInt(req.getParameter("used_food_id"));
                int number_food = Integer.parseInt(req.getParameter("number_food"));
                FoodOrder foodOrder = foodDAO.getFoodOrder(used_food_id);
                if(foodOrder.getSoLuong() > number_food) {
                    foodOrder.setSoLuong(foodOrder.getSoLuong() - number_food);
                    foodDAO.updateFoodOrder(foodOrder);
                    foodOrder.setSoLuong(number_food);
                    foodOrder.setTrangThai(FoodOrder.StatusFood.valueOf(status));
                    foodDAO.addUsedFoodDone(foodOrder);
                }
            }
            resp.setStatus(200);
            resp.setContentType("text/xml");
            writer.println("ok");
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
