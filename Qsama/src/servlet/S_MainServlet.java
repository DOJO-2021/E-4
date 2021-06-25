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

import dao.MainDAO;
import model.S_Main;

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

		String user_id = String.valueOf(session.getAttribute("login_user_id"));
		System.out.println(user_id + "user_idの中身");
		String ac_id = String.valueOf(session.getAttribute("ac_id"));
		System.out.println(ac_id + "ac_idの中身");

		MainDAO qDao = new MainDAO();
		//---お知らせ----
		List<S_Main> NoticeList = qDao.Notice(user_id);
		// 結果をリクエストスコープに格納する
		request.setAttribute("NoticeList", NoticeList);
		System.out.println(NoticeList + "NoticeListの中身");

		//---最近の質問----
		List<S_Main> RecentqList = qDao.RecentQ();
		// 結果をリクエストスコープに格納する
		request.setAttribute("RecentqList", RecentqList);

		//---HTMLの解決済み質問----
		// 結果をリクエストスコープに格納する
		List<S_Main> ResoledQList = qDao.ResolvedQuestion();
		request.setAttribute("ResoledQList", ResoledQList);

		//---CSSの解決済み質問----
		// 結果をリクエストスコープに格納する
		List<S_Main> ResoledQList2 = qDao.ResolvedQuestion2();
		request.setAttribute("ResoledQList2", ResoledQList2);

		//---JavaScriptの解決済み質問----
		// 結果をリクエストスコープに格納する
		List<S_Main> ResoledQList3 = qDao.ResolvedQuestion3();
		request.setAttribute("ResoledQList3", ResoledQList3);

		//---Javaの解決済み質問----
		// 結果をリクエストスコープに格納する
		List<S_Main> ResoledQList4 = qDao.ResolvedQuestion4();
		request.setAttribute("ResoledQList4", ResoledQList4);

		//---SQLの解決済み質問----
		// 結果をリクエストスコープに格納する
		List<S_Main> ResoledQList5 = qDao.ResolvedQuestion5();
		request.setAttribute("ResoledQList5", ResoledQList5);

		//---サーブレット・JSPの解決済み質問----
		// 結果をリクエストスコープに格納する
		List<S_Main> ResoledQList6 = qDao.ResolvedQuestion6();
		request.setAttribute("ResoledQList6", ResoledQList6);

		//---事務局の解決済み質問----
		// 結果をリクエストスコープに格納する
		List<S_Main> ResoledQList7 = qDao.ResolvedQuestion7();
		request.setAttribute("ResoledQList7", ResoledQList7);

		//---ドリルの解決済み質問----
		// 結果をリクエストスコープに格納する
		List<S_Main> ResoledQList8 = qDao.ResolvedQuestion8();
		request.setAttribute("ResoledQList8", ResoledQList8);

		//---段位認定の解決済み質問----
		// 結果をリクエストスコープに格納する
		List<S_Main> ResoledQList9 = qDao.ResolvedQuestion9();
		request.setAttribute("ResoledQList9", ResoledQList9);

		// mainページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/s_main.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// メインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/s_main.jsp");
				dispatcher.forward(request, response);

	}
}
