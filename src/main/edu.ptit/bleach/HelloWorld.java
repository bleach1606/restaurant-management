package bleach;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {
	private static long serialVersionUID = 1L;
	
	public HelloWorld() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		loadParameter(req, resp, "by get");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		loadParameter(req, resp, "by Post");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.print("This is Put method");
	}

	private void loadParameter(HttpServletRequest req, HttpServletResponse resp, String method) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		PrintWriter writer = resp.getWriter();
		writer.print("This is Post method : " + method + " </br> \n");
		writer.print("This is an example");
		writer.print("username : " + username + " </br> \n");
		writer.print("password : " + password + " </br> \n");
	}

	
	
}
