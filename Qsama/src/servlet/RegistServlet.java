package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IdpwDAO;
import model.LoginUser;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//新規登録
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String myclass = request.getParameter("belong");
		String email = request.getParameter("email");
		String name = request.getParameter("name");

		//user_rankの判定 radioボタンのvalueを取得し1か2で判定する
		String rank1 = request.getParameter("rank");
		if(rank1 == "1") {
			//Stringからintに変換
			int rank2 = Integer.parseInt(rank1);
			// 管理者として新規登録処理を行う
			IdpwDAO bDao = new IdpwDAO();
			if (bDao.insert(new LoginUser(0, id, pw, myclass, email, name, rank2))) {	// 登録成功
				System.out.println("登録成功！");
			}
			else {												// 登録失敗
				System.out.println("登録失敗！");
			}
			// ログインページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
					dispatcher.forward(request, response);
		}
		else {
			//Stringからintに変換
			int rank2 = Integer.parseInt(rank1);
			// 受講生として新規登録処理を行う
			IdpwDAO bDao = new IdpwDAO();
			if (bDao.insert(new LoginUser(0, id, pw, myclass, email, name, rank2))) {	// 登録成功
				System.out.println("登録成功！");
			}
			else {												// 登録失敗
				System.out.println("登録失敗！");
			}

			// ログインページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
					dispatcher.forward(request, response);
		}
	}

}
