package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import model.Admin;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 検索処理を行う
		AdminDAO aDao = new AdminDAO();
		List<Admin> GetList = aDao.PostGet();			// 未回答の検索
		List<Admin> GetList2 = aDao.PostGet2();		// 回答済の検索

//		System.out.println("DoGetのGetListの中身："+GetList);		//結果出力　テストok

		request.setAttribute("GetList", GetList);
		request.setAttribute("GetList2", GetList2);

		// 管理者ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin.jsp");
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// もしもログインしていなかったらログインサーブレットにリダイレクトする
/*		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/Qsama/LoginServlet");
			return;
		}
*/
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String post_number = request.getParameter("post_number");		// 講師：検索キーワードを取得
		String answer = request.getParameter("answer_area");			// 回答の投稿

//		System.out.println(display_no);

		// 質問内容の検索処理を行う
		AdminDAO aDao = new AdminDAO();
		List<Admin> GetList = aDao.PostGet();							// 未回答の検索
		List<Admin> GetList2 = aDao.PostGet2();						// 回答済の検索
		List<Admin> DisplayGetList = aDao.DisplayPostGet(post_number);// 右欄へ表示する内容検索

//		System.out.println("DoPostのGetListの中身："+GetList);
//		System.out.println("DoPostのGetList2の中身："+GetList2);
//		System.out.println("DoPostのDisplayGetListの中身"+DisplayGetList);
//		System.out.println("DoPostの変数post_numberの中身"+post_number+"\t answerは："+answer);

		if(answer != null) {				// 回答欄に書き込みがあれば書き込む
		// 回答の登録処理を行う
		aDao.PostAnswer(post_number,answer);
		}

		request.setAttribute("GetList", GetList);
		request.setAttribute("GetList2", GetList2);
		request.setAttribute("DisplayGetList", DisplayGetList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin.jsp");
		dispatcher.forward(request, response);
	}
}
