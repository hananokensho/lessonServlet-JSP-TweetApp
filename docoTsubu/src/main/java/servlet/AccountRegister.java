package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountRegisterDAO;
import model.User;

/**
 * Servlet implementation class AccountRegister
 */
@WebServlet("/AccountRegister")
public class AccountRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/register.jsp");
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// registe.jspから受けとった情報をJavaBeans（User）に保存
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String id = request.getParameter("id");
		
		User user = new User(name , pass, id);
		
		//アカウントをデータベースに登録処理
		AccountRegisterDAO ar = new AccountRegisterDAO();
		if(ar.accountRegister(user)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/registerSuccess.jsp");
			rd.forward(request, response);
			//セッションにアカウント情報を保存
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser" ,user);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/registerError.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
