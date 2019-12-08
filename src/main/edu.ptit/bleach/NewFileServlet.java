package bleach;

import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class NewFileServlet extends HttpServlet {
	private void processRequest(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("TEST","HI, im from Servlet class");
		Gson gson = new Gson();
		gson.toJson(request);
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/process/NewFile.jsp");
		dispatcher.forward(request, response);

	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		processRequest(request,response);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		processRequest(req,res);
	}
}
