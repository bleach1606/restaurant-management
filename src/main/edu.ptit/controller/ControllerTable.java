package controller;

import DAO.TableDAO;
import com.google.gson.Gson;
import modul.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "table", urlPatterns = {"/table"})
public class ControllerTable extends HttpServlet {
    private static long serialVersionUID = 102831973239L;

    private TableDAO tableDAO;

    public ControllerTable() {
        tableDAO = new TableDAO();
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response,  ArrayList<Table> list) throws ServletException, IOException {
        request.setAttribute("listTable", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/process/Table.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String key = req.getParameter("key");
        System.out.printf("this is get");
        TableDAO tableDAO = new TableDAO();
        ArrayList<Table> list = tableDAO.getListTable(key);
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        String json = new Gson().toJson(list);
        resp.setStatus(200);
        resp.setContentType("json");
        writer.println(json);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Table table = new Table();
            String nameTable = req.getParameter("nameTable"); table.setNameTable(nameTable);
            String status = req.getParameter("status"); table.setStatus(status);
            String quantitySeat = req.getParameter("quantitySeat"); table.setQuantitySeat(Integer.parseInt(quantitySeat));
            String description = req.getParameter("description"); table.setDescription(description);
            table = tableDAO.AddTableId(table);
            resp.setStatus(200);
            resp.setContentType("text/xml");
            PrintWriter writer = resp.getWriter();
            writer.println(table);
        } catch (Exception ex) {
            resp.setStatus(404);
            resp.setContentType("text/xml");
            PrintWriter writer = resp.getWriter();
            writer.println(ex.getMessage());
        }
    }

    protected void doPut (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonData = req.getParameter("para");
        Gson gson = new Gson();
        Table table = gson.fromJson(jsonData, Table.class);
        table = tableDAO.updateTable(table);
        String jsonOBj = gson.toJson(table);
        resp.setStatus(200);
        resp.setContentType("text/xml");
        PrintWriter writer = resp.getWriter();
        writer.println(jsonOBj);
    }

    protected void doDelete (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonData = req.getParameter("para");
        Gson gson = new Gson();
        Table table = gson.fromJson(jsonData, Table.class);
        int k = tableDAO.deleteTable(table.getId());
        resp.setStatus(200);
        resp.setContentType("text/xml");
        PrintWriter writer = resp.getWriter();
        writer.println(k);
    }
}
