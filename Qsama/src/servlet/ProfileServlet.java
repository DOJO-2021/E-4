package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.ProfileDAO;
import model.Admin;
import model.Profile;

/**
 * Servlet implementation class ProfileServlet
 */
@MultipartConfig(location = "C:\\pleiades\\workspace\\E-4\\Qsama\\WebContent\\img")
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/Qsama/LoginServlet");
			return;
		}
	    // ac_idを設定
		String Sac_id = (String)session.getAttribute("ac_id");
		int ac_id = Integer.parseInt(Sac_id);

//		System.out.println("プロフィールのac_id＝"+ac_id);
//		int ac_id = 100; // test用

		ProfileDAO pDao = new ProfileDAO();
		List<Profile> ProfileList = pDao.profileAll(ac_id);
		List<Admin> MyGetList = pDao.MyPostGet(ac_id);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("ProfileList", ProfileList);
		request.setAttribute("MyGetList", MyGetList);

//		System.out.println("プロフィールの中身:"+ ProfileList);
//		System.out.println("自分の質問の中身:"+ MyGetList);

		 // 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profile.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/Qsama/LoginServlet");
			return;
		}

		request.setCharacterEncoding("UTF-8");
		ProfileDAO pDao = new ProfileDAO();

	    // ac_idを設定
		String Sac_id = (String)session.getAttribute("ac_id");
		int ac_id = Integer.parseInt(Sac_id);

		String prof_url = "";
		String back_url = "";

	    // 登録処理を行う
		// ---------------背景画像を処理・格納-----------------------------------------------------
		try {
			Part part = request.getPart("IMAGE"); // getPartで取得

			String image = this.getFileName(part);
			request.setAttribute("image", image);

			//ここで名前を決定
			 LocalDateTime nowDateTime = LocalDateTime.now();
			 DateTimeFormatter java8Format = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
			 // 日時情報を指定フォーマットの文字列で取得
			 String java8Disp = nowDateTime.format( java8Format );
			 part.write(java8Disp+image);
			 String filename = java8Disp+image;
			 back_url = "img/"+filename;
		}catch (Exception e) {
			System.out.println("背景画像入力されてません");
	   	}

		// ---------------顔画像を処理・格納-----------------------------------------------------
		try {
			Part part2 = request.getPart("IMAGE2"); // getPartで取得

			String image2 = this.getFileName(part2);
			request.setAttribute("image2", image2);

			//ここで名前を決定
			 LocalDateTime nowDateTime2 = LocalDateTime.now();
			 DateTimeFormatter java8Format2 = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
			 // 日時情報を指定フォーマットの文字列で取得
			 String java8Disp2 = nowDateTime2.format( java8Format2 );
			 part2.write(java8Disp2+image2);
			 String filename2 = java8Disp2+image2;
			 prof_url = "img/"+filename2;
		}catch (Exception e) {
			System.out.println("顔画像入力されてません");
	   	}


		System.out.println("acid"+ac_id +"顔："+ prof_url +"背景："+ back_url);
		 pDao.pic_insert(ac_id, prof_url, back_url);		// 画像の更新

	//------------リクエストパラメータを取得する-----------------------------
		String company= request.getParameter("COMPANY");
		String my_class= request.getParameter("MY_CLASS");
		String name= request.getParameter("NAME");
		String experience= request.getParameter("EXPERIENCE");
		String bloodtype= request.getParameter("BLOODTYPE");
		String birthday= request.getParameter("BIRTHDAY");
		String college= request.getParameter("COLLEGE");
		String undergraduate= request.getParameter("UNDERGRADUATE");
		String hobby= request.getParameter("HOBBY");
		String special_skill= request.getParameter("SPECIAL_SKILL");
		String qualification= request.getParameter("QUALIFICATION");
        String favorite_artist = request.getParameter("FAVORITE_ARTIST");
        String comment= request.getParameter ("COMMENT");

	pDao.p_update(company, my_class, name, experience, bloodtype, birthday, college, undergraduate, hobby, special_skill, qualification, favorite_artist, comment, ac_id);
	List<Profile> ProfileList = pDao.profileAll(ac_id);
	List<Admin> MyGetList = pDao.MyPostGet(ac_id);

	// -------検索結果をリクエストスコープに格納する-----------
	request.setAttribute("ProfileList", ProfileList);
	request.setAttribute("MyGetList", MyGetList);

//	System.out.println("プロフィールの中身:"+ ProfileList);
//	System.out.println("自分の質問の中身:"+ MyGetList);

	 // ------------結果ページにフォワードする--------------
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profile.jsp");
		dispatcher.forward(request, response);
	}

	//--------ファイルの名前を取得してくる-----------------
	private String getFileName(Part part) {
        String name = null;
        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
            if (dispotion.trim().startsWith("filename")) {
                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
                name = name.substring(name.lastIndexOf("\\") + 1);
                break;
            }
        }
		return name;
	}
}
