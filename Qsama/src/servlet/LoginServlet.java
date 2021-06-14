package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.IdpwDAO;
import model.LoginUser;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
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
		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("ID");
		String user_pw = request.getParameter("PW");

		// ログイン処理を行う
		IdpwDAO iDao = new IdpwDAO();
		if (iDao.isLoginOK(user_id, user_pw)) {	// ログイン成功

			//個人情報を抽出
			List<LoginUser> MyList = iDao.Mydata(user_id, user_pw);
			System.out.println(MyList);

			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			session.setAttribute("user_id", new LoginUser(user_id));
			session.setAttribute("user_pw", new LoginUser(user_id, user_pw));

			// メインサーブレットにリダイレクトする
			response.sendRedirect("/Qsama/S_MainServlet");
		}
		else {									// ログイン失敗
			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/s_main.jsp");
			dispatcher.forward(request, response);
		}
	}
}
