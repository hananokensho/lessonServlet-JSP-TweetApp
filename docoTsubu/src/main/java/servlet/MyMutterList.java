package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MutterListDAO;
import model.User;

/**
 * Servlet implementation class MyMutterList
 */
@WebServlet("/MyMutterList")
public class MyMutterList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		MutterListDAO mld = new MutterListDAO();
		System.out.println(loginUser.getName());
		//投稿リストをリクエストスコープに保存
		request.setAttribute("myMutterList",mld.findAllMyMutterList(loginUser));

		//フォワード
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/myMutterList.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//セッションスコープに保存されたユーザー情報を取得

		
				
	}

}
