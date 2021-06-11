package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Question_postDAO;
import model.Question_post;


/**
 * Servlet implementation class Question_postServlet
 */
@WebServlet("/Question_postServlet")
public class Question_postServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 個人投稿ページにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question_post.jsp");
			dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String Major_items = request.getParameter("Major_items");
		String Medium_item = request.getParameter("Medium_item");
		String Q_date = request.getParameter("Q_date");
		String A_date = request.getParameter("A_date");
		String Q_content = request.getParameter("Q_content");
		String A_content = request.getParameter("A_content");
		int A_level = Integer.parseInt(request.getParameter("A_level"));
		int Q_flag = Integer.parseInt(request.getParameter(" Q_flag"));
		int A_flag = Integer.parseInt(request.getParameter("A_flag"));
		int emergency = Integer.parseInt(request.getParameter("emergency"));

		// 登録処理を行う
		Question_postDAO qDao = new Question_postDAO();
		if (qDao.insert(new Question_post(0, 0, Major_items, Medium_item, Q_date, A_date, Q_content, A_content, A_level, Q_flag, A_flag, emergency))) {	// 登録成功
			System.out.println("登録成功");
		}
		else {
			System.out.println("登録失敗");
		}
		
		// 投稿ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question_post.jsp");
				dispatcher.forward(request, response);

	}
}
