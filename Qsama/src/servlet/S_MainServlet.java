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
import dao.MainDAO;
import model.LoginUser;
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

		MainDAO qDao = new MainDAO();
		//---最近の質問----
		List<S_Main> RecentqList = qDao.RecentQ();
		// 結果をリクエストスコープに格納する
		request.setAttribute("RecentqList", RecentqList);
		//System.out.println("scope RecentqList:" + RecentqList);   // 結果出力

		//---HTMLの解決済み質問----
		// 結果をリクエストスコープに格納する
		List<S_Main> ResoledQList = qDao.ResolvedQuestion();
		request.setAttribute("ResoledQList", ResoledQList);

		// mainページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/s_main.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String M_items = request.getParameter("M_items");		//大項目
		System.out.println("大項目"+M_items);
		String Q_date = request.getParameter("Q_date");			//投稿日
		System.out.println("日付"+Q_date);
		String Q_content = request.getParameter("Q_content");	//投稿内容
		System.out.println("質問内容"+Q_content);*/

		// 検索処理を行う
		//MainDAO sDao = new MainDAO();
		//List<S_Main> RecentqList = sDao.RecentQ();

		// 検索結果をリクエストスコープに格納する
		//request.setAttribute("RecentqList", RecentqList);

		// メインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/s_main.jsp");
				dispatcher.forward(request, response);

	}
}
