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
 * Servlet implementation class S_MainServlet
 */
@WebServlet("/S_MainServlet")
public class S_MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/Qsama/LoginServlet");
			return;
		}

		//個人情報を抽出
		String user_id = request.getParameter("USER_ID");
		String user_pw = request.getParameter("USER_PW");
		IdpwDAO iDao = new IdpwDAO();

		//「MyList」にac_id, user_id, user_pw, my_class, e_mail, name, user_rank が格納されている
		List<LoginUser> MyList = iDao.Mydata(user_id, user_pw);
		System.out.println(MyList);

		// 「Rank」にuser_rankが格納されている
		int Rank = iDao.MyRank(user_id, user_pw);
		System.out.println(Rank);

		// mainページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/s_main.jsp");
		dispatcher.forward(request, response);
	}

}
