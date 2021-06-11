package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProfileDAO;
import model.Profile;
/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// プロフィールページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profile.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			// もしもログインしていなかったらログインサーブレットにリダイレクトする
	/*	HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/Qsama/LoginServlet");
			return;
	}
	*/

	//リクエストパラメータを取得する
	request.setCharacterEncoding("UTF-8");
		String company= request.getParameter("COMPANY");
		String class_number= request.getParameter("My_CLASS");
		String name= request.getParameter("NAME");
		String experience= request.getParameter("EXPERIENCE");
		String bloodtype= request.getParameter("BLOODTYPE");
		String birthday= request.getParameter("BIRTHDAY");
		String college= request.getParameter("COLLEGE");
		String undergraduate= request.getParameter("UNDERGRADUATE");
		String hobby= request.getParameter("HOBBY");
		String special_skill= request.getParameter("SPECIAL_SKILL");
		String qualification= request.getParameter("QUALIFICATION");
        String fovorite= request.getParameter("FAVORITE");
        String comment= request.getParameter ("COMMENT");
	}



    // 登録処理を行う

	ProfileDAO pDao = new ProfileDAO();
	List<Profile> ProfileList = pDao.profileAll(new Profile("COMPANY, MY_CLASS, NAME, EXPERIENCE, BLOODTYPE,BIRTHDAY, COLLEGE, UNDERGRADUATE, HOBBY, SPECIAL_SKILL, QUALIFICATION, FAVORITE, COMMENT"));
	// 検索結果をリクエストスコープに格納する
	request.setAttribute("ProfileList", ProfileList);


	 // 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profile.jsp");
		dispatcher.forward(request, response);


}
