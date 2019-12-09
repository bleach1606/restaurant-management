package controller;

import DAO.*;
import DTO.KitchenDTO;
import DTO.Reception;
import DTO.StockDTO;
import bleach.JwtTokenProvider;
import modul.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class ControllerLogin extends HttpServlet {
	private static long serialVersionUID = 102831973239L;
	private TableDAO tableDAO;
	private FoodDAO foodDAO;
	private ComboDAO comboDAO;
	private NCCDAO nccdao;
	private JwtTokenProvider jwtTokenProvider;

	public ControllerLogin() {
		// TODO Auto-generated constructor stub
		 tableDAO = new TableDAO();
		 foodDAO = new FoodDAO();
		 comboDAO = new ComboDAO();
		 nccdao = new NCCDAO();
		 jwtTokenProvider = new JwtTokenProvider();
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response, User user, String token) throws ServletException, IOException {
		ArrayList<Table> list = tableDAO.getListTable("");
		ArrayList<Food> foods = foodDAO.getAllFood();
		ArrayList<Combo> combos = comboDAO.getAllCombo();
		Reception reception = new Reception(user, list, foods, combos);
		reception.setToken(token);
		request.setAttribute("reception", reception);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/process/main.jsp");
		dispatcher.forward(request, response);
	}

	private void processRequest1(HttpServletRequest request, HttpServletResponse response, User user, String token) throws ServletException, IOException {
		KitchenDTO kitchenDTO = new KitchenDTO();
		kitchenDTO.setUser(user);
		System.out.println(FoodOrder.StatusFood.DA_GIAO.toString());
		ArrayList<FoodOrder> usedFoods = foodDAO.listUserFoodForKey(FoodOrder.StatusFood.DA_GIAO.toString());
		kitchenDTO.setFoodOrders(usedFoods);
		kitchenDTO.setComboOrders(comboDAO.listUserComboForKey(ComboOrder.StatusCombo.DA_GIAO.toString()));
		kitchenDTO.setToken(token);
		request.setAttribute("kitchen", kitchenDTO);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/process/Kitchen.jsp");
		dispatcher.forward(request, response);
	}

	private void processRequest2(HttpServletRequest request, HttpServletResponse response, User user, String token) throws ServletException, IOException {
		ArrayList<NhaCungCap> nhaCungCaps = nccdao.getALl();
		StockDTO stockDTO = new StockDTO();
		stockDTO.setNhaCungCaps(nhaCungCaps);
		stockDTO.setUser(user);
		stockDTO.setToken(token);
		request.setAttribute("stock", stockDTO);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/process/Stock.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.print("username test\n");
	}

	private boolean checkString(String s) {
		s= s.toLowerCase();
		for(int i = 0; i < s.length(); i++) {
			if((s.charAt(i) <= '9' && s.charAt(i) >= '0') || (s.charAt(i) <= 'z' && s.charAt(i) >= 'a')) {
				continue;
			}
			return true;
		}
		return false;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		writer.print("username : " + username + " </br> \n");
		writer.print("password : " + password + " </br> \n");
		if(checkString(username) || checkString(password)) {
			writer.println("<script type=\"text/javascript\">");
			writer.println("alert('Tài khoản hoặt mật khẩu chứa kí tự đặc biệt');");
			writer.println("location='process/login.jsp';");
			writer.println("</script>");
		}

		UserDAO userDAO = new UserDAO();
		User user = userDAO.CheckUser(username, password);
		if(user == null) {
			writer.println("<script type=\"text/javascript\">");
			writer.println("alert('Tài khoản hoặt mật khẩu không chính xác');");
			writer.println("location='process/login.jsp';");
			writer.println("</script>");
		}
		else {
			System.out.println(user.toString());
			String token = jwtTokenProvider.generateToken(user);
			if (user.getRole().equals("LE_TAN")) {
				processRequest(req, resp, user, token);
			} else if (user.getRole().equals("KHO")) {
				processRequest2(req, resp, user, token);
			} else{
				processRequest1(req, resp, user, token);
			}
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.print("This is Put method");
	}
}
