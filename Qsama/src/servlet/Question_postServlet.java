package servlet;

import java.io.IOException;
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

import dao.Question_postDAO;
import model.Question_post;

/**
 * Servlet implementation class Question_postServlet
 */

//multipart/form-dataリクエストを認識して、 getPart()を機能させるようにする
@MultipartConfig(location = "C:\\pleiades\\workspace\\E-4\\Qsama\\WebContent\\images") // アップロードファイルの一時的な保存先

//URLパターンを使用すると、サーブレットは正確にそのパス上のリクエストのみをリッスン
@WebServlet("/Question_postServlet")


public class Question_postServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	// processRequestメソッドはGETとPOSTの両方のHTTPリクエストを処理
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 // もしもログインしていなかったらログインサーブレットにリダイレクトする
			HttpSession session = request.getSession();
			if (session.getAttribute("user_id") == null) {
				response.sendRedirect("/Qsama/LoginServlet");
				return;
			}

		// ログインしているユーザID（ac_id)の取得
//			String ac_id = (String) session.getAttribute("ac_id");
//			System.out.print("ac_idの中身:" + ac_id );

		// -------------- よくある質問 ------------------
			Question_postDAO qDao = new Question_postDAO();
			List<Question_post> PostFaqList = qDao.PostFaq();
			List<Question_post> WeekFaqList = qDao.WeekFaqRanking();

			System.out.println("scope PostFaqList:" + PostFaqList);   // 結果出力
			System.out.println("scope WeekFaqList:" + WeekFaqList);

			// 結果をリクエストスコープに格納する
			request.setAttribute("PostFaqList", PostFaqList);
			request.setAttribute("WeekFaqList", WeekFaqList);

		// 個人投稿ページにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question_post.jsp");
			dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
			HttpSession session = request.getSession();
			if (session.getAttribute("user_id") == null) {
				response.sendRedirect("/Qsama/LoginServlet");
				return;
			}

		// ログインしているユーザID（ac_id)の取得
			String ac_id = (String) session.getAttribute("ac_id");

		// ----------------------   よくある質問   ----------------------

			Question_postDAO qDao = new Question_postDAO();
			List<Question_post> PostFaqList = qDao.PostFaq();
			List<Question_post> WeekFaqList = qDao.WeekFaqRanking();

			// 結果をリクエストスコープに格納する
			request.setAttribute("PostFaqList", PostFaqList);
			request.setAttribute("WeekFaqList", WeekFaqList);

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
	//	int ac_id = Integer.parseInt(request.getParameter("ac_id"));
	//	int QQ_id = Integer.parseInt(request.getParameter("QQ_id"));
	//	int Post_Number = Integer.parseInt(request.getParameter("Post_Number"));

		int Post_Number = qDao.MAXpost_number()+1;				// post_numberの最大値を検索して「最大値+1」代入
		qDao.NewPost_number(Post_Number);							// テーブル「MANAGEMENT_WORD」に新規post_nemuberを追加
//		System.out.println("Post_number："+Post_Number);

		String M_items = request.getParameter("M_items");
		String S_items = request.getParameter("S_items");
		String Q_date = request.getParameter("Q_date");
		String Q_content = request.getParameter("Q_content");
		int A_level = Integer.parseInt(request.getParameter("A_level"));
	//	int A_level = 0;
	//	int Q_flag = Integer.parseInt(request.getParameter("Q_flag"));
		int Q_flag = 0;
		int emergency = Integer.parseInt(request.getParameter("emergency"));
	//	int emergency = 0;
		String Postpic_url = request.getParameter("Postpic_url");

		// ----------パラメータの取得確認 ----------

		System.out.println("大項目：" + M_items);
		System.out.println("中項目：" + S_items);
		System.out.println("日付：" + Q_date);
		System.out.println("質問内容：" + Q_content);
		System.out.println("回答レベル：" + A_level);
	//	System.out.println("回答フラグ：" + Q_flag);
		System.out.println("緊急レベル：" + emergency);
		System.out.println("画像URL：" + Postpic_url);          // null値

		 // ---------------------  画像アップロード  ------------------------

		// 文字列作成
			StringBuilder sb = new StringBuilder();

		//ここで名前を決定
		//	 LocalDateTime nowDateTime = LocalDateTime.now();
		//	 DateTimeFormatter java8Format = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

			 // 日時情報を指定フォーマットの文字列で取得
			//  String rename = nowDateTime.format( java8Format );
			 // System.out.println(rename);

		//Part part = request.getPart("Postpic_url"); // getPartで取得

		 for (Part part : request.getParts()) {
            if (part.getName().equals("Postpic_url")) {

            //	for(int i = 0; i < 2; i++) {

                String name = this.getFileName(part);
                System.out.println("nameの中身:" + name);     // ファイル名そのまま
           //     String fileReName = rename + "_" + i + ".jpg";
            //    System.out.println("renameの中身:" + fileReName);   // 日付でのリネーム

            //    String Url = "Qsama/WebContent/" + name;

                part.write(name);                       // ファイルへの書き込み
                sb.append(name).append("<br>");
                //part.write(getServletContext().getRealPath("/WEB-INF/images") + "/" + name);

                System.out.println("partの中身:" + part);

         //   } else {
          //  	break;
            }
        }

		 	// 配列作成
		 	request.setAttribute("upload_files", sb.toString());
	        //  request.getRequestDispatcher("index.jsp").forward(request, response);
	        System.out.print("sb.toStringの中身: "+ sb.toString());    // OK

	     // ----------------------- 配列分解  --------------------------
	        String newPostpic_url = sb.toString();

			String array1[] = newPostpic_url.split("<br>");
			for (String a : array1) {
				System.out.println("配列分解：" + a);       // OK

				// URL化
				// String post_url = "Qsama/images/"+ a;
				String post_url = "file:///C:/pleiades/workspace/E-4/Qsama/WebContent/images/" + a ;

				System.out.println("URL化：" + post_url);
			}

//			boolean YES = qDao.post_url(new Question_post(newPostpic_url, Post_Number));		// DBに画像URL書き込み

//			 System.out.println("DBに画像URL書き込み→"+YES);

//			 System.out.println("\n ac:"+ac_id+"\t post:"+Post_Number+"\t url:"+newPostpic_url);
	/*			// 文字列作成
			       StringBuilder sb = new StringBuilder();

				//Part part = request.getPart("Postpic_url"); // getPartで取得,ここが配列？

		 		for (Part part : request.getParts()) {
            		if (part.getName().equals("Postpic_url")) {

	                String name = this.getFileName(part);
	                part.write(name);                       // ファイルへの書き込み
	                sb.append(name).append("<br>");

	                System.out.println("nameの中身:" + name);
	                System.out.println("partの中身:" + part);

	            } else {
	            	break;
	            }
	        }

     	//ここで名前を決定
	/*	 LocalDateTime nowDateTime = LocalDateTime.now();
		 DateTimeFormatter java8Format = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

		 // 日時情報を指定フォーマットの文字列で取得
		 String java8Disp = nowDateTime.format( java8Format );

		 part.write(java8Disp+".jpg");

       */

		// ------------------------------  登録処理を行う  -----------------------------
			 boolean AAA;
		//Question_postDAO q2Dao = new Question_postDAO();
		if (AAA = qDao.P_insert(ac_id, Post_Number, M_items, S_items, Q_date, Q_content, A_level, Q_flag, emergency, newPostpic_url)) {
       // if (qDao.P_insert(new Question_post(M_items, S_items, Q_date, Q_content, A_level, emergency, Postpic_url))) {
			System.out.println("登録成功");
			System.out.println("AAA中身："+AAA);

		}else {
			System.out.println("登録失敗");
		}

		// 投稿ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question_post.jsp");
				dispatcher.forward(request, response);
	}


	// 名前を取得するメソッド

	private String getFileName(Part part) {
		String name = null;

        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {

            if (dispotion.trim().startsWith("filename")) {

                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
                name = name.substring(name.lastIndexOf("\\") + 1);
                System.out.println(name);
                break;
            }
        }
		return name;
	}
}
