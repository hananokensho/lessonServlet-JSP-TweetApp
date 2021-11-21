package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import model.User;

/**
 * Servlet implementation class AccountSerch
 */
@WebServlet("/AccountSerch")
public class AccountSerch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//idとpassをindex.jspから受け取る
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		//受け取った値をUserインスタンスにセット
		User user = new User();
		user.setId(id);
		user.setPass(pass);
		
		//AccountDAOクラスで判定
		AccountDAO adao = new AccountDAO();
		User returnUser = adao.findAccount(user);
		if(returnUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", returnUser);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/loginSuccess.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/loginError.jsp");
			rd.forward(request, response);
		}
	}

}
