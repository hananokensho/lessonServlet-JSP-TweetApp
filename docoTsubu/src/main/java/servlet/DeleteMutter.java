package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MutterListDAO;

/**
 * Servlet implementation class DeleteMutter
 */
@WebServlet("/DeleteMutter")
public class DeleteMutter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		MutterListDAO mld = new MutterListDAO();
		if(mld.deleteMutter(id)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/deleteSuccess.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/deleteError.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
